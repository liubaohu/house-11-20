package com.kgc.house.mapper;

import com.kgc.house.pojo.RealEstate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealEstateMapper {
    public List<RealEstate> selectAll();
    public List<RealEstate> selectByCard(@Param("cardId") String cardId);

}
