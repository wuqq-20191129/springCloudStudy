package com.wuqq.rocket.service;

import com.wuqq.rocket.entity.OrderTest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-19
 */
public interface IOrderTestService extends IService<OrderTest> {

    boolean saveFortest(OrderTest orderTest,String id);

}
