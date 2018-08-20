package lbs.demo.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import lbs.demo.web.bean.PersonBean;

public class MongoDBPersonDao {
	private DBCollection col;

	public MongoDBPersonDao(MongoClient mongo) {
		this.col = mongo.getDB("journaldev").getCollection("Persons");
	}

	public PersonBean createPerson(PersonBean p) {
		DBObject doc = toDBObject(p);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		p.setId(id.toString());
		return p;
	}

	public void updatePerson(PersonBean p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		this.col.update(query, toDBObject(p));
	}

	public List<PersonBean> readAllPerson() {
		List<PersonBean> data = new ArrayList<PersonBean>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			PersonBean p = toPerson(doc);
			data.add(p);
		}
		return data;
	}

	public void deletePerson(PersonBean p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		this.col.remove(query);
	}
/*
	public PersonBean readPerson(PersonBean p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		DBObject data = this.col.findOne(query);
		return PersonConverter.toPerson(data);
	}*/


	public static DBObject toDBObject(PersonBean p) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", p.getName()).append("country", p.getCountry());
		if (p.getId() != null)
			builder = builder.append("_id", new ObjectId(p.getId()));
		return builder.get();
	}

	// convert DBObject Object to Person
	// take special note of converting ObjectId to String
	public static PersonBean toPerson(DBObject doc) {
		PersonBean p = new PersonBean();
		p.setName((String) doc.get("name"));
		p.setCountry((String) doc.get("country"));
		ObjectId id = (ObjectId) doc.get("_id");
		p.setId(id.toString());
		return p;

	}
}
