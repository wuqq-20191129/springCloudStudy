package com.wuqq;

public enum Color {
    RED("红色", 1,"222"), GREEN("绿色", 2,"333");
    // 成员变量
    private String name;
    private int index;
    private String value;
    // 构造方法
    private Color(String name, int index,String value) {
        this.name = name;
        this.index = index;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

