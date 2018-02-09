package multimedia.image;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TagParse{
	
	@SuppressWarnings("unchecked")
	public String[] extract(String tags) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Reader reader = new StringReader(tags);
		Object jsonObj = parser.parse(reader);
		JSONArray tagarr = (JSONArray) jsonObj;
		ArrayList<String> n = tagarr;
	
		String[] result = n.stream()
				.filter(tag ->tag.trim().length()> 0)				
				.map(s ->s.trim()).limit(10)
				.distinct()
				.toArray(String[]::new);
				
		reader.close(); 
		return result;
	}
}
