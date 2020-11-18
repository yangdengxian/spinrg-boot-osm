package com.ydx.spinrgbootosm.repository;

import com.ydx.spinrgbootosm.domain.Islands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IslandsRepository extends JpaRepository<Islands,String>, JpaSpecificationExecutor<Islands> {

    /**
     * 查询所有岛屿
     * @author ydx
     * @data 2020-11-12 22:29
     */
    @Query(value = "select \"id\",\"islandCNName\",\"islandENName\",\"elevation\",public.st_asgeojson(\"geom\") as geom from islands ",nativeQuery = true)
    List<Islands> findAllIslands();

}
