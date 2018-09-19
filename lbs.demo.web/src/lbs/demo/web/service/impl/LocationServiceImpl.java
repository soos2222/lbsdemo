package lbs.demo.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

import lbs.demo.mongodb.dao.MongoDBLocationDao;
import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;
import lbs.demo.web.service.iface.LocationServiceInterface;

@Service
public class LocationServiceImpl implements LocationServiceInterface{

	@Override
	public LocationBean getLastLocation(HttpServletRequest request, DeviceBean deviceBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String lastUpdatedDate = transFormat.format(deviceBean.getLastUpdatedTime());

		MongoDBLocationDao locationDao = new MongoDBLocationDao(mongo, deviceBean.getDeviceNumber(), lastUpdatedDate);
		LocationBean location = locationDao.readLastLocation();

		return location;
	}

	@Override
	public List<LocationBean> getListLocation(HttpServletRequest request, DeviceBean deviceBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String lastUpdatedDate = transFormat.format(deviceBean.getLastUpdatedTime());

		MongoDBLocationDao locationDao = new MongoDBLocationDao(mongo, deviceBean.getDeviceNumber(), lastUpdatedDate);

		List<LocationBean> locations = locationDao.readAllLocation();

		return locations;
	}

}
