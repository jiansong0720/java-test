package com.jiansong.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * activiti历史服务
 *
 * songshu 2018/4/23/023 17:52
 */
@Service
public class ActHistoryService {

    @Resource
    private HistoryService historyService;

    /**
     * 查询历史流程变量
     *
     * @param processInstanceId 流程id
     */
    public List<HistoricVariableInstance> findHisVariablesList(String processInstanceId) {
        return historyService
                .createHistoricVariableInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();
    }

    /**
     * 查询历史任务（只包括所有任务）
     *
     * @param processInstanceId 流程id
     */
    public List<HistoricTaskInstance> findHisTaskList(String processInstanceId) {
        return historyService
                .createHistoricTaskInstanceQuery()// 创建历史任务实例查询
                .processInstanceId(processInstanceId)// 用流程实例id查询
                .finished()// 查询已经完成的任务
                .list();
    }

    /**
     * 查询历史活动（包括所有节点和任务）
     *
     * @param processInstanceId 流程id
     */
    public List<HistoricActivityInstance> findHisActivityList(String processInstanceId) {
        return historyService
                .createHistoricActivityInstanceQuery()// 创建历史任务实例查询
                .processInstanceId(processInstanceId)// 用流程实例id查询
                .finished()// 查询已经完成的任务
                .list();
    }


}
