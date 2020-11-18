package com.ydx.spinrgbootosm.service;

import com.ydx.spinrgbootosm.domain.Islands;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IslandsService {
    List<Islands> findAllIslands() throws Exception;
}
