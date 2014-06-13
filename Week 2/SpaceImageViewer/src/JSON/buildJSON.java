package JSON;

//Ariana Antonio
//Java 1, Week 1, Full Sail University, MDVBS
//06/10/2014

import imageDetail.ImageDetail;
import imageType.ImageType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class buildJSON {

	public static JSONObject buildsJSONImages() {
		//initial object
		JSONObject imagesObject = new JSONObject();
		
		//for exceptions
		try {
		//array to hold objects
		JSONArray imagesArray = new JSONArray();
		//loop through objects
		for (ImageDetail images : ImageDetail.values()) {
			
			JSONObject imageObject = new JSONObject();
			//set enums to JSON
			imageObject.put("Title", images.getImageTitle());
			imageObject.put("URL", images.getImageURL());
			imageObject.put("User", images.getImageUser());
			imageObject.put("Telescope", images.getImageTelescope());
				
			imagesArray.put(imageObject);
		}
		//set array in object
		imagesObject.put("images", imagesArray);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagesObject;
	}
	public static JSONObject buildsJSONTypes() {
		//initial object
		JSONObject typesObject = new JSONObject();
		//exceptions
		try {
			//array to hold objects
			JSONArray typesArray = new JSONArray();
			
			for (ImageType type : ImageType.values()) {
				JSONObject typeObject = new JSONObject();
				//set enum values
				typeObject.put("Type", type.getTypeTitle());
				typeObject.put("ID", type.getTypeID());
				
				typesArray.put(typeObject);
			}
			//add values to object
			typesObject.put("types", typesArray);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typesObject;
	}
}
