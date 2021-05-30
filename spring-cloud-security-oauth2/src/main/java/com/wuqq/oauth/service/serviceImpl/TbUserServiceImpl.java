package com.wuqq.oauth.service.serviceImpl;

import com.wuqq.oauth.entity.TbUser;
import com.wuqq.oauth.mapper.TbUserMapper;
import com.wuqq.oauth.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {


    @Override
    public TbUser getByName(String username) {
        TbUser user = this.baseMapper.selectByUserName(username);
        return user;
    }
}
