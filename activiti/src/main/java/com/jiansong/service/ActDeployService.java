package com.jiansong.service;

import com.jiansong.request.CustomizationAddReq;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/*
 * activiti自定义工作流
 *
 * songshu 2018/4/23/023 13:59
 */
@Slf4j
@Service
public class ActDeployService {

    @Resource
    private RepositoryService repositoryService;

    /**
     * 自定义工作流
     *
     * @param req
     */
    public void customizationProcess(CustomizationAddReq req) {
        // 1.创建bpmn模型
        BpmnModel model = new BpmnModel();
        Process process = new Process();
        model.addProcess(process);
        //流程id自动生成
        process.setId(req.getName());

        //添加流程元素
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        process.addFlowElement(startEvent);
        req.getUserTaskAddReqList().forEach((bean) -> {
            UserTask userTask = new UserTask();
            //设置id
            userTask.setId(bean.getKey());
            //设置任务名称
            userTask.setName(bean.getName());

            //设置处理人
            userTask.setAssignee(bean.getTaskType().value + bean.getAssignee());

            //设置候选人
            //userTask.setCandidateUsers();
            process.addFlowElement(userTask);
        });
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        process.addFlowElement(endEvent);

        //连接流程元素
        req.getRelationAddReqList().forEach((relationAddReq) -> {
            process.addFlowElement(createSequenceFlow(relationAddReq.getKey(), relationAddReq.getNextKey()));
        });

        // 2.对BPMN元素进行自动布局
        new BpmnAutoLayout(model).execute();

        // 3. 部署这个BPMN模型
        Deployment deployment = repositoryService
                .createDeployment()
                .addBpmnModel(req.getName() + ".bpmn", model)  //添加bpmn文件
                .name(req.getName()) //声明流程的名称
                .deploy();
        // 4. 保存为bpmn文件，springboot重启之后，会自动加载
        saveBpmn(deployment.getId(), deployment.getName() + ".bpmn");
    }

    /**
     * 保存bpmn文件
     * @param deploymentId
     * @param resourceName
     */
    public void saveBpmn(String deploymentId, String resourceName) {
        InputStream processBpmn = repositoryService.getResourceAsStream(deploymentId, resourceName);
        try {
            // TODO: 2018/4/20/020 尝试文件存到服务器。保证安全
            FileUtils.copyInputStreamToFile(processBpmn, new File("src/main/resources/processes/" + resourceName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建箭头
     *
     * @param from 开始节点
     * @param to   指向节点
     * @return
     */
    protected SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

}
