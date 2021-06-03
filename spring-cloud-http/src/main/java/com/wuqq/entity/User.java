package com.wuqq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/6/2 15:44
 * @Created by mh
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = -4057648770548574977L;

    private String username;

    private String password;

    private int age;


}
