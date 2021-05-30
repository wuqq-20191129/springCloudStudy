package com.wuqq.oauth.service.serviceImpl;

import com.wuqq.oauth.entity.TbPermission;
import com.wuqq.oauth.mapper.TbPermissionMapper;
import com.wuqq.oauth.service.ITbPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author wuqq
 * @since 2021-05-29
 */
@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionMapper, TbPermission> implements ITbPermissionService {

    @Override
    public List<TbPermission> getListByID(long userID) {
        return this.baseMapper.selectByID(userID);
    }
}
