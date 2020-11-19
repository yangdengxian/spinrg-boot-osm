package com.ydx.spinrgbootosm.domain;

import com.ydx.spinrgbootosm.util.PolygonConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

import javax.persistence.*;
import java.util.List;

@Table(name="islands")
@Getter
@Setter
@Entity
@ApiModel("岛屿信息表")
//@Converter(name="polygonConverter", converterClass = PolygonConverter.class)
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
	@ApiModelProperty(value = "空间信息",hidden = true)
//    @Convert("polygonConverter")
	private String geom;
}
