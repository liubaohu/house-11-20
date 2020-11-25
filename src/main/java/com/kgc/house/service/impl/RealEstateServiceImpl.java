package com.kgc.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.house.mapper.RealEstateMapper;
import com.kgc.house.pojo.RealEstate;
import com.kgc.house.service.RealEstateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RealEstateServiceImpl implements RealEstateService {
    @Resource
    RealEstateMapper realEstateMapper;

    @Override
    public PageInfo<RealEstate> selectRealEstate(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("buildTime desc");
        List<RealEstate> realEstates = realEstateMapper.selectAll();
        PageInfo<RealEstate> pageInfo = new PageInfo<>(realEstates);
        pageInfo.setPageSize(pageSize);
        return pageInfo;
    }

    @Override
    public List<RealEstate> selectAll() {
        List<RealEstate> list = realEstateMapper.selectAll();
        return list;
    }

    @Override
    public PageInfo<RealEstate> selectByCard(String cardId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("servicePageSize:"+pageSize);
        PageHelper.orderBy("buildtime desc");
        List<RealEstate>  list = realEstateMapper.selectByCard(cardId);
        PageInfo<RealEstate> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }
}
