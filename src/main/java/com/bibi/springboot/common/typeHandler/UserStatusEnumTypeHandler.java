package com.bibi.springboot.common.typeHandler;

import com.bibi.springboot.common.Enum.UserStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 重写EnumTypeHandler类
 */
public class UserStatusEnumTypeHandler extends BaseTypeHandler<UserStatusEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserStatusEnum userStatusEnum, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setString(i, userStatusEnum.getValue());
        } else {
            preparedStatement.setObject(i, userStatusEnum.getValue(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public UserStatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        return Enum.valueOf(UserStatusEnum.class, result);
    }

    @Override
    public UserStatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        return Enum.valueOf(UserStatusEnum.class, result);
    }

    @Override
    public UserStatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        return Enum.valueOf(UserStatusEnum.class, result);
    }
}
