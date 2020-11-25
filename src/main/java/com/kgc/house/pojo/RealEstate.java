package com.kgc.house.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate {
    private Integer id;
    private String cardId;
    private String projectName;
    private String address;
    private String houseType;
    private Integer area;
    private Date buildTime;
    private User user;

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", cardId='" + cardId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", address='" + address + '\'' +
                ", houseType='" + houseType + '\'' +
                ", area=" + area +
                ", buildTime=" + buildTime +
                ", user=" + user +
                '}';
    }
}
