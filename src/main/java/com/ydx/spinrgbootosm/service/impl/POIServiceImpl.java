package com.ydx.spinrgbootosm.service.impl;

import com.ydx.spinrgbootosm.domain.POI;
import com.ydx.spinrgbootosm.repository.IslandsRepository;
import com.ydx.spinrgbootosm.repository.POIRepository;
import com.ydx.spinrgbootosm.service.IslandsService;
import com.ydx.spinrgbootosm.service.POIService;
import com.ydx.spinrgbootosm.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class POIServiceImpl implements POIService {
    @Autowired
    POIRepository poiRepository;
    @Override
    public List<POI> findAllPOI() throws Exception {
        ThreadContext.putContext("currentSchema", "china");
        List<POI> pois = poiRepository.findAllPOI();
        return pois;
    }
}
