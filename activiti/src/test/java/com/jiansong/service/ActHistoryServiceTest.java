package com.jiansong.service;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 2018/4/23/023.
 */
public class ActHistoryServiceTest extends BaseServiceTest{

    @Resource
    private ActHistoryService actHistoryService;

    @Test
    public void findHisVariablesList() {
        List<HistoricVariableInstance> hisVariablesList = actHistoryService.findHisVariablesList("47508");
        for (HistoricVariableInstance historicVariableInstance : hisVariablesList) {

        }
    }

    @Test
    public void findHisTaskList() {
        List<HistoricTaskInstance> hisTaskList = actHistoryService.findHisTaskList("47508");
        for (HistoricTaskInstance historicTaskInstance : hisTaskList) {

        }
    }

    @Test
    public void findHisActivityList() {
        List<HistoricActivityInstance> hisActivityList = actHistoryService.findHisActivityList("47508");
        for (HistoricActivityInstance historicActivityInstance : hisActivityList) {

        }
    }
}