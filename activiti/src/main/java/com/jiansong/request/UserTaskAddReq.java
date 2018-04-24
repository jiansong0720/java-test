package com.jiansong.request;

import com.jiansong.contant.TaskType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/*
 * 用户任务新增
 *
 * songshu 2018/4/19/019 11:44
 */
@Getter
@Setter
@ApiModel("用户任务新增请求")
public class UserTaskAddReq {

    @NotBlank(message = "任务key不能为空")
    @ApiModelProperty("任务key")
    private String key;

    @NotBlank(message = "任务名称不能为空")
    @ApiModelProperty("任务名称")
    private String name;

    @NotBlank(message = "任务受理人不能为空")
    @ApiModelProperty("任务受理人，根据任务类型传递对应对象的id")
    private String assignee;

    @NotNull(message = "任务类型不能为空")
    @ApiModelProperty("任务类型")
    private TaskType taskType;

}
