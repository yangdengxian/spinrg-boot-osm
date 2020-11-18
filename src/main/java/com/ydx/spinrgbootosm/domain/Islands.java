package com.ydx.spinrgbootosm.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="islands")
@Getter
@Setter
@Entity
@ApiModel("圈闭管理信息表")
public class Islands {
	@Id
	@Column(name="id")
	@ApiModelProperty("岛屿id")
	private String id;

	@Column(name="islandCNName")
	@ApiModelProperty("岛屿中文名称")
	private String islandCNName;

	@Column(name="islandENName")
	@ApiModelProperty("岛屿英文名称")
	private String islandENName;

	@Column(name="elevation")
	@ApiModelProperty("岛屿高程")
	private Double elevation;

	@Column(name="geom")
	@ApiModelProperty("空间信息")
	private String geom;
}
