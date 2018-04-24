package com.song.service;


import com.song.common.requset.wechat.WechatMessageRequest;
import com.song.service.webservice.WeatherWebService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/*
 * 位置处理
 *
 * songshu 2017/12/1 17:02
 */
@Service
public class WechatLocationService {

    @Resource
    private WeatherWebService weatherWebService;

    /**
     * 处理消息
     */
    public String handleMessage(WechatMessageRequest bean) {
        try {
            Map map = weatherWebService.getByLocation(bean.getLocationX() + "," + bean.getLocationY());
            return "Date:" + map.get("date") + ",Weather:" + map.get("tmp_min") + "~" + map.get("tmp_max") + "℃.你若安好便是晴天.";
        } catch (IOException e) {
            e.printStackTrace();
            return "获取地址失败";
        }
    }
}
