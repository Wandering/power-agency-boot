package com.power.dao.ex;

import org.apache.ibatis.annotations.Param;

/**
 * Created by 杨永平 on 2017/9/8.
 */
public interface IPermissionDAO {
    String query(@Param("sql") String sql);
}
