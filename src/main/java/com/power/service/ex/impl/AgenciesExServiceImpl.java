package com.power.service.ex.impl;

import com.power.dao.ex.IAgenciesExDAO;
import com.power.entity.AgenciesEntity;
import com.power.entity.ex.BaseSearch;
import com.power.service.ex.IAgenciesExService;
import io.renren.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨永平 on 2017/9/8.
 */
@Service
public class AgenciesExServiceImpl  implements IAgenciesExService{
    @Autowired
    IAgenciesExDAO agenciesExDAO;
    @Override
    public List<BaseSearch> search(String key, String whereSql) {
        return agenciesExDAO.search(key,whereSql);
    }
    @Override
    public List<BaseSearch> searchAccount(String key,Integer type, String whereSql) {
        return agenciesExDAO.searchAccount(key,type,whereSql);
    }
}
