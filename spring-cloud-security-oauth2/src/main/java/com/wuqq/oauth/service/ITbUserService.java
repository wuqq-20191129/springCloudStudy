package com.wuqq.oauth.service;

import com.wuqq.oauth.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
public interface ITbUserService extends IService<TbUser> {
    TbUser getByName(String username);
}
