package com.song.api;

import com.song.common.requset.wechat.WechatMessageRequest;
import com.song.common.util.SignUtils;
import com.song.service.WechatService;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping(value = "/wechat")
public class WechatController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WechatController.class);

    @Resource
    private XStream xStream;
    @Resource
    private WechatService wechatService;

    /**
     * token验证
     */
    @GetMapping("/work")
    public String doGet(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
            // 校验成功则原样返回echostr
            return request.getParameter("echostr");
        } else {
            LOGGER.error("微信公众号验证失败！");
        }
        return "";
    }

    /**
     * 微信消息接收
     */
    @PostMapping(value = "/work")
    public String doPost(@RequestBody WechatMessageRequest bean) {
        Object response = wechatService.handleMessage(bean);
        xStream.processAnnotations(response.getClass());
        return xStream.toXML(response);
    }

}
