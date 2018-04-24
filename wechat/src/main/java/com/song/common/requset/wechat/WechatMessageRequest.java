package com.song.common.requset.wechat;

import com.song.common.constants.EventType;
import com.song.common.constants.MsgType;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatMessageRequest {

    @XmlElement(name = "ToUserName")
    private String toUserName;

    @XmlElement(name = "FromUserName")
    private String fromUserName;

    @XmlElement(name = "CreateTime")
    private Long createTime;

    @XmlElement(name = "MsgType")
    private MsgType msgType;

    @XmlElement(name = "Event")
    private EventType event;

    @XmlElement(name = "EventKey")
    private String eventKey;

    @XmlElement(name = "Content")
    private String content;

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    private String format;

    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgID")
    private String msgID;

    /**
     * 地理位置维度
     */
    @XmlElement(name = "Location_X")
    private String locationX;

    /**
     * 地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private String locationY;

    /**
     * 地图缩放大小
     */
    @XmlElement(name = "Scale")
    private String scale;

    /**
     * 地理位置信息
     */
    @XmlElement(name = "Label")
    private String label;

}