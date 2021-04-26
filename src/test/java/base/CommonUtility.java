package base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class CommonUtility {
	
	/**
	 * Get field's value from config.json
	 * @param field : field name
	 * @return
	 * @throws IOException
	 */
	public static String getConfigInfo(String field){
		String jsonBody = null;
		try {
			jsonBody = new String(Files.readAllBytes(Paths.get("config.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JsonPath(jsonBody).get(field);
	}
}
