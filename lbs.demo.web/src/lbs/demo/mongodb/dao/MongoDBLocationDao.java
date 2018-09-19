package lbs.demo.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import lbs.demo.web.bean.LocationBean;
import lbs.demo.web.bean.PersonBean;

public class MongoDBLocationDao {

	private DBCollection col;

	public MongoDBLocationDao(MongoClient mongo, String deviceName, String selectDate) {
		this.col = mongo.getDB("journaldev").getCollection(deviceName + selectDate);
	}

	public LocationBean createLocation(LocationBean lb) {
		DBObject doc = toDBObject(lb);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		lb.setId(id.toString());
		return lb;
	}

	public List<LocationBean> readAllLocation() {
		List<LocationBean> data = new ArrayList<LocationBean>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			LocationBean b = toLocation(doc);
			data.add(b);
		}
		return data;
	}

	public LocationBean readLastLocation() {

		DBCursor cursor = col.find().skip((int)this.col.getCount() - 1);
		if(cursor.hasNext()){
			DBObject doc = cursor.next();
			LocationBean b = toLocation(doc);
			return b;
		}
		else{
			//더미?
			return null;
		}
	}

	private static LocationBean toLocation(DBObject doc) {
		LocationBean d = new LocationBean();

		d.setLatitude((double) doc.get("latitude"));
		d.setLongitude((double) doc.get("longitude"));

		ObjectId id = (ObjectId) doc.get("_id");
		d.setId(id.toString());
		return d;

	}

	public static DBObject toDBObject(LocationBean lb) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("timeStamp", lb.getLocationTime())
				.append("latitude", lb.getLatitude())
				.append("longitude", lb.getLongitude()
				);
		if (lb.getId() != null)
			builder = builder.append("_id", new ObjectId(lb.getId()));
		return builder.get();
	}

}
