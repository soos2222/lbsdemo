package lbs.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import lbs.demo.web.bean.DeviceBean;
import lbs.demo.web.bean.LocationBean;
import lbs.demo.web.service.iface.DeviceServiceInterface;
import lbs.demo.web.service.iface.LocationServiceInterface;

@Controller
public class DemoServiceIntroController {

	@Autowired private DeviceServiceInterface deviceService;
	@Autowired private LocationServiceInterface locationService;

	@RequestMapping(value = "serviceintro.html", method=RequestMethod.GET)
	public ModelAndView viewServiceIntroPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/serviceintro");

		List<DeviceBean> devices = deviceService.listDevice(request);

		view.addObject("deviceList", devices);

		return view;
	}

	@RequestMapping(value = "deviceproperties.html", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> ajaxTest(HttpServletRequest request, HttpServletResponse response, DeviceBean requestDevice){

		Gson gson = new Gson();

		DeviceBean responseDevice  = deviceService.getDevice(request, requestDevice);
		LocationBean lastLocation = locationService.getLastLocation(request, responseDevice);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		response.setHeader("Content-Type", "application/json");
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		return new ResponseEntity<String>(gson.toJson(lastLocation), responseHeaders, HttpStatus.CREATED);
	}

}
