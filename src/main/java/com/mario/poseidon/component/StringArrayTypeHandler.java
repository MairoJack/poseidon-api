package com.mario.poseidon.component;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author mario on 2021/7/20.
 */
public class StringArrayTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, CollUtil.join(parameter, ","));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null : getResult(rs.getString(columnName));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int i) throws SQLException {
        return rs.wasNull() ? null : getResult(rs.getString(i));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int i) throws SQLException {
        return cs.wasNull() ? null : getResult(cs.getString(i));
    }

    private static List<String> getResult(String str) {
        return StrUtil.isEmpty(str) ? CollUtil.newArrayList() : StrUtil.split(str, ",");
    }
}
