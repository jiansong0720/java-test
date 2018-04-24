package com.song.common.requset.movies;

import com.song.common.requset.base.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 电影列表查询
 * Created by song on 2017/11/30.
 */
@Data
@ApiModel("电影列表查询")
public class MoviesListRequest extends BasePageRequest {

    @ApiModelProperty("时间")
    private Date time;

    @ApiModelProperty("名称")
    private String name;

}
