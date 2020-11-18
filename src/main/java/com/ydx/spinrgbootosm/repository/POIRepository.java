package com.ydx.spinrgbootosm.repository;

import com.ydx.spinrgbootosm.domain.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIRepository extends JpaRepository<POI,String>, JpaSpecificationExecutor<POI> {

    /**
     * 查询所有岛屿
     * @author ydx
     * @data 2020-11-12 22:29
     */
    @Query(value = "select * from poi ",nativeQuery = true)
    List<POI> findAllPOI();

}
