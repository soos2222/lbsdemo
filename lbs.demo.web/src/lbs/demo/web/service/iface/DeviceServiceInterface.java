package lbs.demo.web.service.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;

public interface DeviceServiceInterface {

	public List<DeviceBean> listDevice(HttpServletRequest request);
	public int addDevcie(HttpServletRequest request, DeviceBean deviceBean);
	public DeviceBean getDevice(HttpServletRequest request, DeviceBean deviceBean);

	public List<LocationBean> listLocation(HttpServletRequest request, DeviceBean deviceBean, LocationBean locationBean);
	public int addLocation(HttpServletRequest request, DeviceBean deviceBean, LocationBean locationBean);


}
