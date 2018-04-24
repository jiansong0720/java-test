package com.song.common.response.wechat;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class WechatBaseMessageResponse {

    /**
     * 接收方帐号（收到的OpenID）
     */
    @XStreamAlias("ToUserName")
    private String ToUserName;

    /**
     * 开发者微信号
     */
    @XStreamAlias("FromUserName")
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private long CreateTime;

    /**
     * 消息类型（text/music/news）
     */
    @XStreamAlias("MsgType")
    private com.song.common.constants.MsgType MsgType;

}