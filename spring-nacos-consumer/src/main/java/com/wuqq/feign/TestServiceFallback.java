package com.wuqq.feign;

public class TestServiceFallback implements TestService{

    @Override
    public String getFromFeign(String str) {
        return "getFromFeign fallback";
    }
}
