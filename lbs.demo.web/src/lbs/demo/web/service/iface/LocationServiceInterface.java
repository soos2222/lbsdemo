package lbs.demo.web.service.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;

public interface LocationServiceInterface {

	public LocationBean getLastLocation(HttpServletRequest request, DeviceBean deviceBean);
	public List<LocationBean> getListLocation(HttpServletRequest request, DeviceBean deviceBean);

}
