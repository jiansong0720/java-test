package com.jiansong.service;

import org.activiti.engine.RuntimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Map;

/*
 * activiti运行服务
 *
 * songshu 2018/4/23/023 14:16
 */
@Service
@Transactional
public class ActRuntimeService {

    @Resource
    private RuntimeService runtimeService;

    /**
     * 使用流程定义的key启动流程实例
     *
     * @param instanceByKey 对应processVariables文件中的id的属性值
     * @param params        流程需要携带的参数
     */
    public String startProcess(String instanceByKey, Map<String, Object> params) {
        // TODO: 2018/4/23/023 将流程id保存到记录中
        return runtimeService.startProcessInstanceByKey(instanceByKey, params).getId();
    }


}