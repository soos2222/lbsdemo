package lbs.demo.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

import lbs.demo.mongodb.dao.MongoDBPersonDao;
import lbs.demo.web.bean.PersonBean;
import lbs.demo.web.service.iface.PersonServiceInterface;

@Service
public class PersonServiceImpl implements PersonServiceInterface{

	@Override
	public int addPerson(PersonBean personbean, HttpServletRequest request) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");

		MongoDBPersonDao personDAO = new MongoDBPersonDao(mongo);
		personDAO.createPerson(personbean);

		System.out.println("Person Added Successfully with id="+personbean.getId());


		return 0;
	}

	@Override
	public List<PersonBean> listPerson(HttpServletRequest request) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBPersonDao personDAO = new MongoDBPersonDao(mongo);


		List<PersonBean> persons =  personDAO.readAllPerson();

		return persons;
	}

	@Override
	public int deletePerson(PersonBean personbean, HttpServletRequest request) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBPersonDao personDAO = new MongoDBPersonDao(mongo);

		personDAO.deletePerson(personbean);

		return 0;
	}

	@Override
	public int updatePerson(PersonBean personbean, HttpServletRequest request) {

		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBPersonDao personDAO = new MongoDBPersonDao(mongo);

		personDAO.updatePerson(personbean);

		return 0;
	}

}
