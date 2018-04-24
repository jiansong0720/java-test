package com.jiansong.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/*
 * 角色对象
 *
 * songshu 2018/4/23/023 14:15
 */
@Getter
@Setter
@Entity
public class Role {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 创建时间
     */
    @Column(updatable = false)
    private Date createTime = new Date();

    /**
     * 名称
     */
    @Column(nullable = false)
    private String name;

}