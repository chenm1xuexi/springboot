package com.bibi.springboot.common;

import com.bibi.springboot.common.util.ParameterUtil;
import com.bibi.springboot.model.NewRegion;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

public class MybatisDAO<T, V> extends SqlSessionDaoSupport {
    private static final String SQL_CREATE = "create";
    private static final String SQL_UPDATE = "update";
    private static final String SQL_DELETE = "delete";
    private static final String SQL_GET_BY_ID = "getById";
    private static final String SQL_NAME_SPACE_SEPARATOR = ".";

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    private Class<T> getActuallClassType() {
        Class<T> clazz = null;
        ParameterizedType  parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz  = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return clazz;
    }

    public String getSqlNameSpace() {
        String sqlNameSpace = ParameterUtil.EMPTY;
        Class<T> clazz = this.getActuallClassType();
        sqlNameSpace = clazz.toString().substring(6) + SQL_NAME_SPACE_SEPARATOR;
        return sqlNameSpace;
    }

    @Transactional
    public T create(T t) {
        this.getSqlSession().insert(this.getSqlNameSpace() + SQL_CREATE, t);
        return t;
    }

    @Transactional
    public T update(T t) {
        this.getSqlSession().update(this.getSqlNameSpace() + SQL_UPDATE, t);
        return t;
    }

    public T getById(V id) {
        return this.getSqlSession().selectOne(this.getSqlNameSpace() + SQL_GET_BY_ID, id);
    }

    @Transactional
    public void delete(V id) {
        this.getSqlSession().delete(this.getSqlNameSpace() + SQL_DELETE, id);
    }

}
