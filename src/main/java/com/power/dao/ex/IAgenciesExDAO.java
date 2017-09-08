package com.power.dao.ex;

import com.power.entity.AgenciesEntity;
import com.power.entity.ex.BaseSearch;
import io.renren.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 杨永平 on 2017/9/8.
 */
public interface IAgenciesExDAO {
    List<BaseSearch> search(@Param("key") String key, @Param("whereSql") String whereSql);
    List<BaseSearch> searchAccount(@Param("key") String key, @Param("whereSql") String whereSql);

}
