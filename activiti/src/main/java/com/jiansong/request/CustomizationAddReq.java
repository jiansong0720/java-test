package com.jiansong.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * 日志新增
 *
 * songshu 2018/4/19/019 11:44
 */
@Getter
@Setter
@ApiModel("自定义流程化请求")
public class CustomizationAddReq {

    @NotBlank(message = "流程名称不能为空")
    @ApiModelProperty("流程名称")
    private String name;

    @NotNull(message = "用户任务不能为空")
    @ApiModelProperty("用户任务")
    private List<UserTaskAddReq> userTaskAddReqList;

    @NotNull(message = "节点关系不能为空")
    @ApiModelProperty("节点关系")
    private List<RelationAddReq> relationAddReqList;

}
