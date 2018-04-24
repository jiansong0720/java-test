package com.song.common.requset.movies;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by song on 2017/11/30.
 */
@Data
@ApiModel("电影更新")
public class MoviesUpdateRequest {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("地址")
    private String url;

}
