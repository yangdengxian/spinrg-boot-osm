package com.ydx.spinrgbootosm.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="POI")
@Getter
@Setter
@Entity
@ApiModel("poi信息表")
public class POI {
    @Id
    @Column(name="uid")
    @ApiModelProperty("poi id")
    private String Id;

    @Column(name="name")
    @ApiModelProperty("中文名称")
    private String Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}
