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

	    String[] s = t1.extract("[\"hg\",\" jh\"]");
	    String[] result = {"hg","jh"};
	   
	    Assert.assertArrayEquals( s, result );
	    
	    s = t1.extract("[\"\"]");
	    String[] result1 = {};
	    
	    Assert.assertArrayEquals( s, result1 );
	   
	    s = t1.extract("[\" \"]");
	    String[] result2 = {};
	    
	    Assert.assertArrayEquals( s, result2 );
	    
	    s = t1.extract("[\" \",\" abc\",\" b54\", \"\"]");
	    String[] result3 = {"abc","b54"};
	    
	    Assert.assertArrayEquals( s, result3 );
	}

}
