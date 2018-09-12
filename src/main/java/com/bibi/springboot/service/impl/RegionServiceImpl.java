package com.bibi.springboot.service.impl;

import com.bibi.springboot.common.util.Pagination;
import com.bibi.springboot.dao.RegionDAO;
import com.bibi.springboot.model.NewRegion;
import com.bibi.springboot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "regionService")
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDAO regionDAO;

    @Override
    public List<NewRegion> findAll(Pagination pagination) {
        return regionDAO.findAll(pagination);
    }

    @Override
    public Long findAllCount() {
        return regionDAO.findAllCount();
    }

    @Override
    public NewRegion create(NewRegion newRegion) {
        return regionDAO.create(newRegion);
    }
}
