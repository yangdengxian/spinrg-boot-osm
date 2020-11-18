package com.ydx.spinrgbootosm.controller;

import com.ydx.spinrgbootosm.domain.POI;
import com.ydx.spinrgbootosm.service.POIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* 类注解 */
@Api(value = "desc of class")
@RequestMapping("/pois")
@RestController
public class POIController {
    @Autowired
    private POIService poiService;
    /* 方法注解 */
    @RequestMapping(value = "/findAllPOI", method = RequestMethod.GET)
    @ApiOperation(value = "查询poi", tags={"poi信息分组"}, notes = "200", code = 200, produces = "application/json")
    @ResponseBody
    public List<POI> findAllPOI() throws Exception{
        List<POI> islands = poiService.findAllPOI();
        return islands;
    }
}