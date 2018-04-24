package com.jiansong.contant;

/*
 * 任务类型
 *
 * songshu 2018/4/23/023 16:57
 */
public enum TaskType {

    USER("指定人","USER_"),
    ROLE("指定角色","ROLE_"),
    ;

    public String message;
    public String value;

    TaskType(String message,String value) {
        this.message = message;
        this.value = value;
    }
}
