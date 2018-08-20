package lbs.demo.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import lbs.demo.web.bean.PersonBean;
import lbs.demo.web.service.iface.PersonServiceInterface;

@Controller
public class MainViewController {

	@Autowired private PersonServiceInterface service;

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
		ModelAndView view = new ModelAndView("/person");

		List<PersonBean> persons = service.listPerson(request);
		view.addObject("persons", persons);
		return view;

	}

	@RequestMapping(value = "addperson.html", method=RequestMethod.POST)
	public ModelAndView addPerson(HttpServletRequest request, HttpServletResponse response, PersonBean person){
		ModelAndView view = new ModelAndView("/person");

		service.addPerson(person, request);
		List<PersonBean> persons = service.listPerson(request);
		view.addObject("persons", persons);

		return view;

	}

	@RequestMapping(value = "deleteperson.html", method=RequestMethod.POST)
	public ModelAndView deletePerson(HttpServletRequest request, HttpServletResponse response, PersonBean person){
		ModelAndView view = new ModelAndView("/person");

		service.deletePerson(person, request);
		List<PersonBean> persons = service.listPerson(request);
		view.addObject("persons", persons);

		return view;

	}

	@RequestMapping(value = "editperson.html", method=RequestMethod.POST)
	public ModelAndView editPerson(HttpServletRequest request, HttpServletResponse response, PersonBean person){
		ModelAndView view = new ModelAndView("/person");

		service.updatePerson(person, request);
		List<PersonBean> persons = service.listPerson(request);
		view.addObject("persons", persons);

		return view;

	}


	@RequestMapping(value = "text.html", method=RequestMethod.GET)
	public ModelAndView textTest(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/test");

		return view;
	}
}
