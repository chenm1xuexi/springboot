package com.bibi.springboot.service;

import com.bibi.springboot.common.util.Pagination;
import com.bibi.springboot.model.NewRegion;

import java.util.List;

public interface RegionService {

    List<NewRegion> findAll(Pagination pagination);

    Long findAllCount();

    NewRegion create(NewRegion newRegion);

}
