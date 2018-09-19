package lbs.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;
import lbs.demo.web.service.iface.DeviceServiceInterface;

@Controller
public class DemoAdminController {


	@Autowired private DeviceServiceInterface service;

	@RequestMapping(value = "demoadmin/device.html", method=RequestMethod.GET)
	public ModelAndView adminDevice(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/admin/device");

		List<DeviceBean> devices = service.listDevice(request);

		view.addObject("devices", devices);

		return view;

	}

	@RequestMapping(value = "demoadmin/deviceadd.html", method=RequestMethod.POST)
	public ModelAndView deviceAdd(HttpServletRequest request, HttpServletResponse response, DeviceBean deviceBean){
		ModelAndView view = new ModelAndView("/admin/device");

		service.addDevcie(request, deviceBean);

		return view;

	}

	@RequestMapping(value = "demoadmin/location.html", method=RequestMethod.GET)
	public ModelAndView deviceLocations(HttpServletRequest request, HttpServletResponse response, DeviceBean deviceBean){
		ModelAndView view = new ModelAndView("/admin/location");

		List<DeviceBean> devices = service.listDevice(request);

		view.addObject("devices", devices);

		return view;

	}

	@RequestMapping(value = "demoadmin/history.html", method=RequestMethod.GET)
	public ModelAndView deviceHistory(HttpServletRequest request, HttpServletResponse response, DeviceBean deviceBean){
		ModelAndView view = new ModelAndView("/admin/location");

/*		List<LocationBean> locations = null;

		view.addObject("locations", locations);
*/
		return view;

	}

	@RequestMapping(value = "demoadmin/history.html", method=RequestMethod.POST)
	public ModelAndView getDeviceHistory(HttpServletRequest request, HttpServletResponse response, DeviceBean deviceBean, LocationBean locationBean){
		ModelAndView view = new ModelAndView("/admin/location");

		List<LocationBean> locations = service.listLocation(request, deviceBean, locationBean);

		view.addObject("locations", locations);

		return view;

	}

	@RequestMapping(value = "demoadmin/addloc.html", method=RequestMethod.POST)
	public ModelAndView addLocation(HttpServletRequest request, HttpServletResponse response, DeviceBean deviceBean, LocationBean locationBean){
		ModelAndView view = new ModelAndView("redirect:/" + "demoadmin/history.html");

		int t = service.addLocation(request, deviceBean, locationBean);

		/*view.addObject("locations", locations);*/


		return view;

	}

}
