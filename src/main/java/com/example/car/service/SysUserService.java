package com.example.car.service;

import com.example.car.dao.SysRoleMapper;
import com.example.car.dao.SysUserMapper;
import com.example.car.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
       SysUser sysUser =  userMapper.selectByName(name);
        return sysUser;
    }
}
