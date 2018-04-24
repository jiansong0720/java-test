package com.song.common.requset.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created by song on 2018/1/13/013.
 */
@Data
public class BasePageRequest {

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_SIZE = 10;

    @Min(value = 1, message = "当前页必须大于等于1")
    @ApiModelProperty(value = "当前页，首页为1")
    private Integer page = DEFAULT_PAGE;

    @Min(value = 1, message = "每页显示条数必须大于等于1")
    @ApiModelProperty(value = "每页显示条数，须大于等于1，默认10条")
    private Integer pageSize = DEFAULT_SIZE;

}
