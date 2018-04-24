package com.jiansong.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/*
 * 用户对象
 *
 * songshu 2018/4/23/023 14:16
 */
@Getter
@Setter
@Entity
public class User {

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
     * 账号
     */
    @Column(nullable = false)
    private String account;

    /**
     * 姓名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 用户角色
     */
    @ManyToOne
    private Role role;

}