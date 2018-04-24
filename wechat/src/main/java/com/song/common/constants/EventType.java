package com.song.common.constants;

/*
 * 事件类型
 * 
 * songshu 2017/11/30 10:06
 */
public enum EventType {

    subscribe("订阅"),
    unsubscribe("取消订阅"),
    LOCATION("上报地理位置"),
    CLICK("自定义菜单");

    EventType() {
    }

    EventType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

}
