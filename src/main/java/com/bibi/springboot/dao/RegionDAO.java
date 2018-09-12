package com.bibi.springboot.dao;

import com.bibi.springboot.common.util.Pagination;
import com.bibi.springboot.model.NewRegion;

import java.util.List;

public interface RegionDAO extends BaseDAO<NewRegion, String> {

    List<NewRegion> findAll(Pagination pagination);

    Long findAllCount();

}
