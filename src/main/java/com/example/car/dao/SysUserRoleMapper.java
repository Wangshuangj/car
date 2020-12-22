package com.example.car.dao;

import com.example.car.entity.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SysUserRoleMapper {
    List<SysUserRole> listByUserId(int userId);
}
