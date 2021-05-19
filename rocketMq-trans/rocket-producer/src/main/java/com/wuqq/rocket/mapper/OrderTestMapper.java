package com.wuqq.rocket.mapper;

import com.wuqq.rocket.entity.OrderTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuqq
 * @since 2021-05-19
 */
public interface OrderTestMapper extends BaseMapper<OrderTest> {

    int insert(@Param("orderTest") OrderTest orderTest, String id);

}
