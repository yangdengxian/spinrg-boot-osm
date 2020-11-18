package com.ydx.spinrgbootosm.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IslandsService {
    List<Map<String,Object>> findAllIslands() throws Exception;
}
