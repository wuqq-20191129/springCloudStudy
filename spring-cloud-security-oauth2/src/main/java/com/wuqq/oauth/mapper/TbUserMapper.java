package com.wuqq.oauth.mapper;

import com.wuqq.oauth.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
public interface TbUserMapper extends BaseMapper<TbUser> {
    TbUser selectByUserName(@Param("username") String username);
}
