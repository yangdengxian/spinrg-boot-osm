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
	@Column(name="islandNo")
	@ApiModelProperty("岛屿id")
	private String islandNo;

	@Column(name="islandCNName")
	@ApiModelProperty("岛屿中文名称")
	private String islandCNName;
	private static final long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getIslandNo() {
		return islandNo;
	}

	public void setIslandNo(String islandNo) {
		this.islandNo = islandNo;
	}

	public String getIslandCNName() {
		return islandCNName;
	}

	public void setIslandCNName(String islandCNName) {
		this.islandCNName = islandCNName;
	}



}
