package com.example.car.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {

    private Integer userId;

    private Integer roleId;
}
