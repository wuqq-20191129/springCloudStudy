package com.wuqq.feign;

import com.wuqq.config.FeignCnfigration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nacos-provider",fallback = TestServiceFallback.class,configuration = FeignCnfigration.class)
public interface   TestService {
    @GetMapping("/testRibbon/{str}")
    //@FeignClient 中 方法如果参数则需注明value
    String getFromFeign(@PathVariable("str") String str);

}
