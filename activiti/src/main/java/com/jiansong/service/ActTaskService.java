package com.jiansong.service;

import com.jiansong.contant.TaskType;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/*
 * activiti任务服务
 *
 * songshu 2018/4/23/023 14:16
 */
@Service
@Transactional
public class ActTaskService {

    @Resource
    private TaskService taskService;

    /**
     * 获得某个人的任务别表
     *
     * @param assignee 受理人id
     * @return 任务集合
     */
    public List<Task> getUserTasks(Long assignee) {
        return taskService.createTaskQuery().taskAssignee(TaskType.USER.value + assignee).list();
    }

    /**
     * 获取角色的任务列表
     *
     * @param assignee 候选角色id
     * @return 任务集合
     */
    public List<Task> getRoleTasks(Long assignee) {
        return taskService.createTaskQuery().taskAssignee(TaskType.ROLE.value + assignee).list();
    }

    /**
     * 获得任务参数
     *
     * @param taskId 任务id
     * @return 任务参数集合
     */
    public Map<String, Object> getVariables(String taskId) {
        return taskService.getVariables(taskId);
    }

    /**
     * 完成任务
     *
     * @param taskId 任务id
     */
    public void completeTasks(String taskId) {
        taskService.complete(taskId);
    }
}