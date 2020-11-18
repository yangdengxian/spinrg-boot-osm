package com.ydx.spinrgbootosm.service.impl;

import com.ydx.spinrgbootosm.domain.Islands;
import com.ydx.spinrgbootosm.repository.IslandsRepository;
import com.ydx.spinrgbootosm.service.IslandsService;
import com.ydx.spinrgbootosm.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class IslandsServiceImpl implements IslandsService {
    @Autowired
    IslandsRepository islandsRepository;
    @Override
    public List<Islands> findAllIslands() throws Exception {
        ThreadContext.putContext("currentSchema", "china");
        List<Islands> islands = islandsRepository.findAllIslands();
        return islands;
    }
}
