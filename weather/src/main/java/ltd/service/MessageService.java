package ltd.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import ltd.api.response.MessageResponse;
import ltd.domain.Customer;
import ltd.domain.Message;
import ltd.repository.CustomerRepository;
import ltd.repository.MessageRepository;
import ltd.service.webservice.MailService;
import ltd.service.webservice.MessageWebService;
import ltd.service.webservice.WeatherWebService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * 短信服务
 *
 * songshu 2017/11/23 15:09
 */
@Service
public class MessageService {

    Logger logger = Logger.getLogger(MessageService.class);
    @Resource
    private MailService mailService;
    @Resource
    private MessageRepository messageRepository;
    @Resource
    private WeatherWebService weatherWebService;
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private MessageWebService messageWebService;

//    @Scheduled(cron = "0 0 18 * * ?")
    public void sendMessage() {
        try {
            List<Customer> customerList = customerRepository.findAll();
            for (Customer customer : customerList) {
                Map parse = parse(weatherWebService.getByLocation(customer.getLocation()));
                SendSmsResponse response = messageWebService.sendMessage(customer.getPhone(), parse);
                if (response.getCode() != null && response.getCode().equals("OK")) {
                    //请求成功
                    Message message = new Message();
                    message.setCustomer(customer);
                    message.setSendDate(new Date());
                    message.setContent("Date:" + parse.get("date") + ",Weather:" + parse.get("tmp_min") + "~" + parse.get("tmp_max") + "℃.你若安好便是晴天.");
                    messageRepository.save(message);
                } else {
                    mailService.sendMail("天气", "18227624289@qq.com", "天气Error", "天气短信发送失败");
                    logger.error("短信发送失败");
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public Map parse(String s) {
        Map<String, JSONArray> result = JSONObject.parseObject(s, Map.class);
        Map HeWeather6 = JSONObject.parseObject(result.get("HeWeather6").get(0).toString(), Map.class);
        List dailyForecast = JSONObject.parseObject(HeWeather6.get("daily_forecast").toString(), List.class);
        return JSONObject.parseObject(dailyForecast.get(1).toString(), Map.class);
    }

    public List<MessageResponse> list() {
        List<MessageResponse> messageResponseList = new ArrayList<MessageResponse>();
        List<Message> messageList = messageRepository.findAll();
        for (Message message : messageList) {
            MessageResponse messageResponse = new MessageResponse();
            BeanUtils.copyProperties(message, messageResponse);
            messageResponse.setCustomerName(message.getCustomer().getName());
            messageResponse.setCustomerPhone(message.getCustomer().getPhone());
            messageResponseList.add(messageResponse);
        }
        return messageResponseList;
    }

}
