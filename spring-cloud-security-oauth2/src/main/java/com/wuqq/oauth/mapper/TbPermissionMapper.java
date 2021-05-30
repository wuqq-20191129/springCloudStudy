package com.wuqq.oauth.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wuqq.oauth.entity.TbPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
public interface TbPermissionMapper extends BaseMapper<TbPermission> {

    List<TbPermission> selectByID(@Param("userID") Long userID);
}
