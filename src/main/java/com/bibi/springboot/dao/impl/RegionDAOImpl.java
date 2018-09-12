package com.bibi.springboot.dao.impl;

import com.bibi.springboot.common.MybatisDAO;
import com.bibi.springboot.common.util.Pagination;
import com.bibi.springboot.common.util.ParameterUtil;
import com.bibi.springboot.dao.RegionDAO;
import com.bibi.springboot.model.NewRegion;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "regionDAO")
public class RegionDAOImpl extends MybatisDAO<NewRegion, String> implements RegionDAO {

    @Override
    public List<NewRegion> findAll(Pagination pagination) {
        Map<String, Object> params = new HashMap<>();
        params.put(ParameterUtil.PAGE_SIZE, pagination.getPageSize());
        params.put(ParameterUtil.OFFSET, pagination.getOffset());
        List<NewRegion> list = this.getSqlSession().selectList(this.getSqlNameSpace() + "findAll", params);
        return list;
    }

    @Override
    public Long findAllCount() {
        return this.getSqlSession().selectOne(this.getSqlNameSpace() + "findAllCount");
    }

}
