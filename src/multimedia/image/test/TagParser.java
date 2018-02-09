package multimedia.image.test;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import multimedia.image.TagParse;
import org.junit.Assert;
import org.junit.Test;


public class TagParser {

	@Test
	public void test() throws IOException, ParseException {
		
	    TagParse t1 = new TagParse();
        
	    //white spaces before or after the string are trimmed
	    String[] s = t1.extract("[\"hg\",\" jh\"]");
	    String[] result = {"hg","jh"};	   
	    Assert.assertArrayEquals( s, result );
	    
	    //string of length 0 ignored
	    s = t1.extract("[\"\"]");
	    String[] result1 = {};    
	    Assert.assertArrayEquals( s, result1 );
	   
	    //empty spaces ignored
	    s = t1.extract("[\" \"]");
	    String[] result2 = {};	    
	    Assert.assertArrayEquals( s, result2 );
	    
	    //empty results ignored
	    s = t1.extract("[\" \",\" abc\",\" b54\", \"\"]");
	    String[] result3 = {"abc","b54"};	    
	    Assert.assertArrayEquals( s, result3 );
	    
	    //edge case test
	    s = t1.extract("[\" a\",\" b\",\" c\", \"d\",\" e\",\" f\", \"g\",\" h\",\" i\", \"j\"]");
	    String[] result4 = {"a","b","c","d","e","f","g","h","i","j"};	    
	    Assert.assertArrayEquals( s, result4 );
	    
	    //size automatically limited to 10 if its more
	    s = t1.extract("[\" a\",\" b\",\" c\", \"d\",\" e\",\" f\", \"g\",\" h\",\" i\", \"j\", \"k\"]");
	    String[] result5 = {"a","b","c","d","e","f","g","h","i","j"};    
	    Assert.assertArrayEquals( s, result5 );
	    
	    //duplicates ignored
	    s = t1.extract("[\" a\",\"a\"]");
	    String[] result6 = {"a"};    
	    Assert.assertArrayEquals( s, result6 );
	}

}
