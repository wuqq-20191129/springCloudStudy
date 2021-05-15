package com.wuqq.mongodb.entry;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/5/13 9:56
 * @Created by mh
 */

public class User implements Serializable {

    @Id
    private Integer id;

    private String name;

    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User : [ id="+id+",age= "+age+"name="+name+"] ";

    }
}
