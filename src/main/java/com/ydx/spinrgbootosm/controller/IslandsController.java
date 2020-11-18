package com.ydx.spinrgbootosm.controller;

import com.ydx.spinrgbootosm.domain.Islands;
import com.ydx.spinrgbootosm.service.IslandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/* 类注解 */
@Api(value = "desc of class")
@RequestMapping("/islands")
@RestController
public class IslandsController {
    @Autowired
    IslandsService islandsService;
    /* 方法注解 */
    @RequestMapping(value = "/findAllIslands", method = RequestMethod.GET)
    @ApiOperation(value = "查询岛屿", tags={"岛屿信息分组"}, notes = "200", code = 200, produces = "application/json")
    @ResponseBody
    public List<Islands> findAllIslands() throws Exception{
        List<Islands> islands = islandsService.findAllIslands();
        return islands;
    }
}