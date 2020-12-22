package com.example.car.dao;

import com.example.car.entity.SysUser;

public interface SysUserMapper {


    SysUser selectById(Integer id);

    SysUser selectByName(String name);

}
