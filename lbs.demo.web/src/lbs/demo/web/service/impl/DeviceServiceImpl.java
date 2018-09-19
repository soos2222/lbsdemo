package lbs.demo.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

import lbs.demo.mongodb.dao.MongoDBDeviceDao;
import lbs.demo.mongodb.dao.MongoDBLocationDao;
import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;
import lbs.demo.web.service.iface.DeviceServiceInterface;

@Service
public class DeviceServiceImpl implements DeviceServiceInterface{

	@Override
	public int addDevcie(HttpServletRequest request, DeviceBean deviceBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
							.getAttribute("MONGO_CLIENT");
		MongoDBDeviceDao deviceDao = new MongoDBDeviceDao(mongo);

		deviceDao.createDevice(deviceBean);

		System.out.println("Device Added Successfully with id="+deviceBean.getId());

		return 0;
	}

	@Override
	public List<DeviceBean> listDevice(HttpServletRequest request) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDeviceDao deviceDao = new MongoDBDeviceDao(mongo);

		List<DeviceBean> devices = deviceDao.readAllDevice();

		return devices;
	}

	@Override
	public List<LocationBean> listLocation(HttpServletRequest request, DeviceBean deviceBean, LocationBean locationBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
/*		MongoDBDeviceDao deviceDao = new MongoDBDeviceDao(mongo);


		MongoDBLocationDao locationDao = new MongoDBLocationDao(mongo, deviceBean.getDeviceName(), );

		List<LocationBean> locations =*/

		return null;
	}

	@Override
	public int addLocation(HttpServletRequest request, DeviceBean deviceBean, LocationBean locationBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");

		MongoDBLocationDao locationDao = new MongoDBLocationDao(mongo, deviceBean.getDeviceName(), locationBean.getLocationDate());

		locationDao.createLocation(locationBean);

		System.out.println(locationBean.getId());

		return 0;
	}

	@Override
	public DeviceBean getDevice(HttpServletRequest request, DeviceBean deviceBean) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBDeviceDao deviceDao = new MongoDBDeviceDao(mongo);

		DeviceBean device = deviceDao.readDevice(deviceBean);

		return device;
	}

}
