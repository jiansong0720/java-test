package com.jiansong.service;

import org.activiti.engine.task.Task;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 2018/4/20/020.
 */
public class ActTaskServiceTest extends BaseServiceTest {

    @Resource
    private ActTaskService actTaskService;

    @Test
    public void taskList() {
        //获取个人任务
        List<Task> taskList = actTaskService.getUserTasks(1L);
        List<Task> taskList1 = actTaskService.getRoleTasks(1L);
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                System.out.println("代办任务ID:" + task.getId());
                System.out.println("代办任务name:" + task.getName());
                System.out.println("代办任务创建时间:" + task.getCreateTime());
                System.out.println("代办任务办理人:" + task.getAssignee());
                System.out.println("流程实例ID:" + task.getProcessInstanceId());
                System.out.println("执行对象ID:" + task.getExecutionId());
            }
        }

    }

    @Test
    public void completeTasks() {
        //完成个人任务
        actTaskService.completeTasks("50002");
    }

}