/**  
 * @Title: JsonbConberter.java 
 * @Package com.cnpc.epai.research.label.util 
 * @Description: TODO 
 * @author cuijiaqi
 * @date 2018年10月25日 上午11:10:43 
 * {修改记录：cuijiaqi 2018年10月25日 上午11:10:43}
*/

package com.ydx.spinrgbootosm.util;


import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import org.postgis.Geometry;
import org.postgis.LinearRing;
import org.postgis.Point;
import org.postgis.Polygon;
import org.postgis.binary.BinaryParser;
import org.postgis.binary.BinaryWriter;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO 
 * @author cuijiaqi
 * @version 1.0.11 
 */
public class PolygonConverter implements Converter {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public Object convertObjectValueToDataValue(Object objectValue, Session session) {
		PGobject pgObject = null;
		try {
			List<String> strList = (List<String>)objectValue;
			if(!strList.get(0).equals(strList.get(strList.size()-1))) {
				strList.add(strList.get(0));
			}
			List<Point> pointList = strList.stream().map(str->{
				str = str.trim().replaceAll("[\\|,，、;；]", " ").trim().replaceAll("[\\s\\p{Zs}]+", " ").trim();
				String[] strXY = str.split(" ");
				Point p = new Point(); 
				p.setX(Double.parseDouble(strXY[0])); 
				p.setY(Double.parseDouble(strXY[1])); 
				return p;
			}).collect(Collectors.toList()); 
			LinearRing linearRing = new LinearRing(pointList.toArray(new Point[pointList.size()]));
			Polygon polygon = new Polygon(new LinearRing[] {linearRing});
			BinaryWriter bw = new BinaryWriter();
			pgObject = new PGobject();
			pgObject.setType("public.geometry");
			pgObject.setValue(bw.writeHexed(polygon));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pgObject;
	}

	@Override
	public Object convertDataValueToObjectValue(Object dataValue, Session session) {
		List<String> rtnList = null;
		try {
			if(dataValue != null) {
				PGobject pgObj = (PGobject)dataValue;
				Geometry geometry = null;

				BinaryParser bp = new BinaryParser();
				geometry = bp.parse(pgObj.getValue());
				LinearRing linearRing = ((Polygon)geometry).getRing(0);
				Point[] points = linearRing.getPoints();
				rtnList = Arrays.asList(points).stream().map(p->new BigDecimal(p.x+"").toString()+","+new BigDecimal(p.y+"").toString()).collect(Collectors.toList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnList;
	}

	@Override
	public void initialize(DatabaseMapping mapping, Session session) {
		mapping.getField().setSqlType(Types.OTHER);
	}

	@Override
	public boolean isMutable() {
		return false;
	}
}
