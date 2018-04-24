package com.song.service;


import com.song.common.constants.MsgType;
import com.song.common.requset.wechat.WechatMessageRequest;
import com.song.common.response.wechat.TextMessageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by song on 2017/11/29.
 */
@Service
public class WechatService {

    @Resource
    private WechatTextService wechatTextService;
    @Resource
    private WechatVoiceService wechatVoiceService;
    @Resource
    private WechatLocationService wechatLocationService;

    /**
     * 处理消息
     */
    public Object handleMessage(WechatMessageRequest bean) {
        switch (bean.getMsgType()) {
            case text: {
                // 回复文本消息
                TextMessageResponse textMessage = new TextMessageResponse();
                textMessage.setToUserName(bean.getFromUserName());
                textMessage.setFromUserName(bean.getToUserName());
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setMsgType(MsgType.text);
                textMessage.setContent(wechatTextService.handleMessage(bean.getContent()));
                return textMessage;
            }
            case image: {
                break;
            }
            case voice: {
                wechatVoiceService.handleMessage(bean.getContent());
                break;
            }
            case video: {

                break;
            }
            case location: {
                // 回复文本消息
                TextMessageResponse textMessage = new TextMessageResponse();
                textMessage.setToUserName(bean.getFromUserName());
                textMessage.setFromUserName(bean.getToUserName());
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setMsgType(MsgType.text);
                textMessage.setContent(wechatLocationService.handleMessage(bean));
                return textMessage;
            }
            case shortvideo: {
                break;
            }
            case link: {
                break;
            }
            case event: {
                switch (bean.getEvent()) {
                    case subscribe: {
                        break;
                    }
                    case unsubscribe: {
                        break;
                    }
                    case CLICK: {
                        break;
                    }
                    default: {
                    }
                }
                break;
            }
            default: {
            }
        }
        return null;
    }
}
