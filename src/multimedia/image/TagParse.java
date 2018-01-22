package multimedia.image;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TagParse{
	
	String[] extract(String tags) throws IOException, ParseException {
		
		String s = "";
		JSONParser parser = new JSONParser();
		Reader reader = new StringReader(tags);
		Object jsonObj = parser.parse(reader);
		JSONArray tagarr = (JSONArray) jsonObj; 
		
		@SuppressWarnings("unchecked")
		Iterator<String> it = tagarr.iterator();
		System.out.println("tag:");
		while (it.hasNext()) {
			s+=" "+it.next();		
		}
		s = s.trim();
		String[] arr = s.split(" ");
		if(arr.length<=10) {
		reader.close(); 
		return arr;
		}
		reader.close(); 
		return new String[0];
	}
}
