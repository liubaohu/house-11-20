package com.kgc.house.service;

import com.github.pagehelper.PageInfo;
import com.kgc.house.pojo.RealEstate;

import java.util.List;

public interface RealEstateService {
    public PageInfo<RealEstate> selectRealEstate(Integer pageNum,Integer pageSize);
    public List<RealEstate> selectAll();
    public PageInfo<RealEstate> selectByCard(String cardId,Integer pageNum,Integer pageSize);
}
