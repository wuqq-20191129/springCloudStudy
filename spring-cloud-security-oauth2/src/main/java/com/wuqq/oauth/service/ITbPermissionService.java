package com.wuqq.oauth.service;

import com.wuqq.oauth.entity.TbPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
public interface ITbPermissionService extends IService<TbPermission> {

    List<TbPermission> getListByID(long userID);


}
