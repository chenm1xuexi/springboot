package com.bibi.springboot.common.typeHandler;

import com.bibi.springboot.common.Enum.UserEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEnumOrdinalTypeHandler extends BaseTypeHandler<UserEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UserEnum userEnum, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setInt(i, userEnum.getValue());
        } else {
            preparedStatement.setObject(i, userEnum.getValue(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public UserEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Integer result = resultSet.getInt(s);
        UserEnum[] userEnums = UserEnum.values();
        for(int j = 0; j < userEnums.length; j++) {
            if (userEnums[j].getValue() == result) {
                return userEnums[j];
            }
        }
        return null;
    }

    @Override
    public UserEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Integer result = resultSet.getInt(i);
        UserEnum[] userEnums = UserEnum.values();
        for(int j = 0; j < userEnums.length; j++) {
            if (userEnums[j].getValue() == result) {
                return userEnums[j];
            }
        }
        return null;
    }

    @Override
    public UserEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer result = callableStatement.getInt(i);
        UserEnum[] userEnums = UserEnum.values();
        for(int j = 0; j < userEnums.length; j++) {
            if (userEnums[j].getValue() == result) {
                return userEnums[j];
            }
        }
        return null;
    }
}
