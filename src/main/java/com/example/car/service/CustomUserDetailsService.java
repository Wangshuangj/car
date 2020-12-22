package com.example.car.service;

import com.example.car.entity.SysRole;
import com.example.car.entity.SysUser;
import com.example.car.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("用户名"+username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库取出用户信息
        SysUser user = sysUserService.selectByName(username);
        // 判断用户是否存在
        if (user==null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }


        //添加权限
        List<SysUserRole> userRoles = sysUserRoleService.listByUserId(user.getId());
        for (SysUserRole userRole: userRoles) {
            SysRole sysRole = sysRoleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        System.out.println(authorities);
        // 返回UserDetails实现类
        return new User(user.getName(),user.getPassword(),authorities);
    }
}
