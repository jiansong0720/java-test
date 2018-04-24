package com.song.domain;

import com.song.domain.base.BaseDomain;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by song on 2017/11/27.
 */
@Data
@Entity
public class Movies extends BaseDomain {

    /**
     * 电影名称
     */
    private String name;

    /**
     * 电影地址
     */
    private String url;

}
