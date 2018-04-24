package com.jiansong.service;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 2018/4/23/023.
 */
public class ActRuntimeServiceTest extends BaseServiceTest {

    @Resource
    private ActRuntimeService actRuntimeService;

    @Test
    public void startProcess() {
        //开始一个流程实例
        Map map = new HashMap();
        map.put("applyName", "张明松");
        actRuntimeService.startProcess("请假", map);
    }
}