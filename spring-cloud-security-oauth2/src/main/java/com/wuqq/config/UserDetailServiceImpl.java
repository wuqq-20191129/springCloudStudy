package com.wuqq.config;

import com.wuqq.oauth.entity.TbPermission;
import com.wuqq.oauth.entity.TbUser;
import com.wuqq.oauth.service.ITbPermissionService;
import com.wuqq.oauth.service.ITbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * @author: wuqq
 * @date: 2021/5/29 11:46 PM
 * @version: 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ITbUserService iTbUserService;

    @Autowired
    private ITbPermissionService iTbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = iTbUserService.getByName(username);
        List<GrantedAuthority> authorityList = Lists.newArrayList();
        if(tbUser != null){
            //
            List<TbPermission> tbPermissions = iTbPermissionService.getListByID(tbUser.getId());

            //声明用户授权
            tbPermissions.forEach(tbPermission -> {
                if(tbPermission != null && tbPermission.getEnname() !=null){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                    authorityList.add(grantedAuthority);
                }
            });
        }
        return new User(tbUser.getUsername(),tbUser.getPassword(),authorityList);
    }
}
