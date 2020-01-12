package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	public String firstname, lastname, mail, password;
	
	public void JsonDataReader() throws  IOException, ParseException
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/TestData.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
		
		
		for (Object jsonObj: jarray)
		{
			JSONObject person = (JSONObject) jsonObj ;
			firstname = (String) person.get("firstname");	
			lastname = (String) person.get("lastname");
			mail = (String) person.get("email");
			password = (String) person.get("password");
			
			
			
		}
	
	}

}
 