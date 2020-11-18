package com.ydx.spinrgbootosm.service;

import com.ydx.spinrgbootosm.domain.POI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface POIService {
    List<POI> findAllPOI() throws Exception;
}
