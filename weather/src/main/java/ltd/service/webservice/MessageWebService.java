package ltd.service.webservice;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import ltd.config.MessageConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/*
 * 阿里云短信发送服务
 *
 * songshu 2017/11/22 17:25
 */
@Service
public class MessageWebService {

    @Resource
    private IAcsClient iAcsClient;
    @Resource
    private MessageConfig messageConfig;

    public SendSmsResponse sendMessage(String phone, Map<String, String> params) throws ClientException {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);
        request.setSignName(messageConfig.getSignName());
        request.setTemplateCode(messageConfig.getTemplateCode());
        request.setTemplateParam("{\"date\":\"" + params.get("date") + "\", \"weather\":\"" + params.get("tmp_min") + "~" + params.get("tmp_max") + "\"}");
        return iAcsClient.getAcsResponse(request);
    }

    public QuerySendDetailsResponse querySendDetails(String phone, Date date) throws ClientException {
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(phone);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(date));
        request.setPageSize(10L);
        request.setCurrentPage(1L);
        return iAcsClient.getAcsResponse(request);
    }

}
