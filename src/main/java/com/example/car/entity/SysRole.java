package com.example.car.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRole implements Serializable {
    private Integer id;

    private String name;
}
