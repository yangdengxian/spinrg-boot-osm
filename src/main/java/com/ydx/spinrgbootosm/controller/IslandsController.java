package com.ydx.spinrgbootosm.controller;

import com.ydx.spinrgbootosm.service.IslandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

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
    public Object findAllIslands() throws Exception{
        List<Map<String, Object>> islands = islandsService.findAllIslands();
        return islands;
    }
}