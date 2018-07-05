package lbs.demo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainViewController {

	@RequestMapping(value = "navermap.html", method=RequestMethod.GET)
	public ModelAndView viewNaverMapMain(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/navermap");

		return view;

	}

	@RequestMapping(value = "olmap.html", method=RequestMethod.GET)
	public ModelAndView viewolMapMain(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/olmap");

		return view;

	}

	@RequestMapping(value = "test.html", method=RequestMethod.GET)
	public ModelAndView testMain(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/index2");

		return view;

	}
}
