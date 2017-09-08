package com.power.conf;

/**
 * Created by Administrator on 2017/9/7.
 */
public class PermissionSqlConstant {
    public final static String ORDER_SQL = "select id from orders where FIND_IN_SET(%s,column)";
    public final static String SPILE_SQL = "select id from orders where FIND_IN_SET(%s,column)";
    public final static String BANK_SQL = "select id from orders where FIND_IN_SET(%s,column)";
    public final static String AGENCY_SQL = "select id from agencies ag";
    public final static String BRANCH_SQL = "select id from orders where FIND_IN_SET(%s,column)";
}
