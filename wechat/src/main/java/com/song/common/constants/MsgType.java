package com.song.common.constants;

/*
 * 消息类型
 * 
 * songshu 2017/11/30 10:06
 */
public enum MsgType {

    text("文本"),
    image("图片"),
    voice("语音"),
    video("视频"),
    shortvideo("小视频"),
    location("地理位置"),
    link("链接"),
    event("事件");

    MsgType() {
    }

    MsgType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

}
