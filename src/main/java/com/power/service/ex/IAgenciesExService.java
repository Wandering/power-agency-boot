package com.power.service.ex;

import com.power.entity.AgenciesEntity;
import com.power.entity.ex.BaseSearch;
import io.renren.entity.SysUserEntity;

import java.util.List;

/**
 * Created by 杨永平 on 2017/9/8.
 */
public interface IAgenciesExService {
    List<BaseSearch> search(String key, String whereSql);
    List<BaseSearch> searchAccount(String key,Integer type, String whereSql);
}
