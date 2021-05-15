package com.wuqq.entity;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/4/30 9:53
 * @Created by mh
 */
public class User implements Serializable {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity {id="+id+",name="+name+"}";
    }
}
