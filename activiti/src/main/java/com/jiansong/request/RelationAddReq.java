package com.jiansong.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/*
 * 元素之间关系
 *
 * songshu 2018/4/19/019 11:44
 */
@Getter
@Setter
@ApiModel("元素之间关系")
public class RelationAddReq {

    @NotBlank(message = "任务开始节点不能为空")
    @ApiModelProperty("开始的节点传start，任务顺序编号")
    private String key;

    @NotBlank(message = "任务结束节点不能为空")
    @ApiModelProperty("任务的下一个节点编号，结束的节点传end")
    private String nextKey;

}
