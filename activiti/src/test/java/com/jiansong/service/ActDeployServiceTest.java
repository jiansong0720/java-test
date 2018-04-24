package com.jiansong.service;

import com.jiansong.contant.TaskType;
import com.jiansong.request.CustomizationAddReq;
import com.jiansong.request.RelationAddReq;
import com.jiansong.request.UserTaskAddReq;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2018/4/23/023.
 */
public class ActDeployServiceTest extends BaseServiceTest{

    @Resource
    private ActDeployService actDeployService;

    @Test
    public void customizationProcess() {
        CustomizationAddReq req=new CustomizationAddReq();
        req.setName("请假");

        List<UserTaskAddReq> list=new ArrayList<>();
        UserTaskAddReq userTaskAddReq1=new UserTaskAddReq();
        userTaskAddReq1.setAssignee("1");
        userTaskAddReq1.setName("1号用户处理");
        userTaskAddReq1.setKey("bumen");
        userTaskAddReq1.setTaskType(TaskType.USER);
        list.add(userTaskAddReq1);

        UserTaskAddReq userTaskAddReq2=new UserTaskAddReq();
        userTaskAddReq2.setAssignee("1");
        userTaskAddReq2.setName("1号角色处理");
        userTaskAddReq2.setKey("xingzheng");
        userTaskAddReq2.setTaskType(TaskType.ROLE);
        list.add(userTaskAddReq2);
        req.setUserTaskAddReqList(list);

        List<RelationAddReq> relationAddReqlist=new ArrayList<>();
        RelationAddReq relationAddReq1=new RelationAddReq();
        relationAddReq1.setKey("start");
        relationAddReq1.setNextKey("bumen");
        relationAddReqlist.add(relationAddReq1);

        RelationAddReq relationAddReq2=new RelationAddReq();
        relationAddReq2.setKey("bumen");
        relationAddReq2.setNextKey("xingzheng");
        relationAddReqlist.add(relationAddReq2);

        RelationAddReq relationAddReq3=new RelationAddReq();
        relationAddReq3.setKey("xingzheng");
        relationAddReq3.setNextKey("end");
        relationAddReqlist.add(relationAddReq3);

        req.setRelationAddReqList(relationAddReqlist);
        actDeployService.customizationProcess(req);
    }
}