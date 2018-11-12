package com.training.spring.routing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MyRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String keyDataSource = (String) request.getAttribute("keyDS");
		if (keyDataSource.equals(null)) {
			keyDataSource = "PUBLISHER_DS";
		}
		return keyDataSource;
	}

	public void initDataSource(DataSource dataSource1, DataSource dataSource2) {
		Map<Object, Object> dsMap = new HashMap<>();
		dsMap.put("PUBLISHER_DS", dataSource1);
		dsMap.put("ADVERTISER_DS", dataSource2);
		this.setTargetDataSources(dsMap);
	}
}
