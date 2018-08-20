package lbs.demo.web.service.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lbs.demo.web.bean.PersonBean;

public interface PersonServiceInterface {

	public int addPerson(PersonBean personbean, HttpServletRequest request);
	public int deletePerson(PersonBean personbean, HttpServletRequest request);
	public List<PersonBean> listPerson(HttpServletRequest request);
	public int updatePerson(PersonBean personbean, HttpServletRequest request);

}
