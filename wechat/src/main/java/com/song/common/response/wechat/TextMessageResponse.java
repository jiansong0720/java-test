package com.song.common.response.wechat;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class TextMessageResponse extends WechatBaseMessageResponse {

    /**
     * 回复的消息内容
     */
    @XStreamAlias("Content")
    private String content;

}