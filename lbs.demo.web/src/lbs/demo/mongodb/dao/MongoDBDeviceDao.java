package lbs.demo.mongodb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import lbs.demo.web.bean.DeviceBean;


public class MongoDBDeviceDao {
	private DBCollection col;

	public MongoDBDeviceDao(MongoClient mongo) {
		this.col = mongo.getDB("journaldev").getCollection("Devices");
	}

	public DeviceBean createDevice(DeviceBean d) {
		DBObject doc = toDBObject(d);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		d.setId(id.toString());
		return d;
	}

	public List<DeviceBean> readAllDevice() {
		List<DeviceBean> data = new ArrayList<DeviceBean>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			DeviceBean b = toDevice(doc);
			data.add(b);
		}
		return data;
	}

	public DeviceBean readDevice(DeviceBean d){
		DBObject query = BasicDBObjectBuilder.start()
						.append("_id", new ObjectId(d.getId())).get();
		DBObject data = this.col.findOne(query);
		return toDevice(data);
	}

	private static DBObject toDBObject(DeviceBean d) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("deviceName", d.getDeviceName())
				.append("deviceAge", d.getDeviceAge())
				.append("deviceGender", d.getDeviceGender());
		if (d.getId() != null)
			builder = builder.append("_id", new ObjectId(d.getId()));
		return builder.get();
	}

	private static DeviceBean toDevice(DBObject doc) {
		DeviceBean d = new DeviceBean();

		d.setDeviceName((String)doc.get("deviceName"));
		d.setDeviceNumber((String)doc.get("deviceNumber"));
		d.setDeviceAge((int)doc.get("deviceAge"));
		d.setDeviceGender((String)doc.get("deviceGender"));
		d.setDeviceDescription((String)doc.get("deviceDescription"));
		d.setLastMotion((String)doc.get("lastMotion"));
		d.setLastUpdatedTime((Date)doc.get("lastUpdatedTime"));
		d.setLabelType((String)doc.get("labelType"));
		d.setProfileImg((String)doc.get("profileImg"));

		ObjectId id = (ObjectId) doc.get("_id");
		d.setId(id.toString());
		return d;

	}

}
