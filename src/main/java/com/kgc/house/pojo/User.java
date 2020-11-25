package com.kgc.house.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String cardId;
    private String name;
    private Integer gender;
    private Date createTime;
    private String password;
    private Integer status;

}
