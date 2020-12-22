package com.example.car.service;

import com.example.car.dao.SysUserRoleMapper;
import com.example.car.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(int userId) {
        List<SysUserRole> sysUserRoles = userRoleMapper.listByUserId(userId);
        return sysUserRoles;
    }
}
