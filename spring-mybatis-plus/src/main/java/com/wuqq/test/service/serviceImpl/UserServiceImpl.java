package com.wuqq.test.service.serviceImpl;

import com.wuqq.test.entity.User;
import com.wuqq.test.mapper.UserMapper;
import com.wuqq.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
