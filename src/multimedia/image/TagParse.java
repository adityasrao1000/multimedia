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
		
		String[] s = new String[10];
		int i=0;
		JSONParser parser = new JSONParser();
		Reader reader = new StringReader(tags);
		Object jsonObj = parser.parse(reader);
		JSONArray tagarr = (JSONArray) jsonObj; 
		
		@SuppressWarnings("unchecked")
		Iterator<String> it = tagarr.iterator();
		System.out.println("tag:");
		while (it.hasNext()) {
			s[i]=it.next();
			i++;
		}
		reader.close(); 
		return s;
	}
}
