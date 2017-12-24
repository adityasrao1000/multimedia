package diagnostics;

import org.jhades.JHades;
/*import org.jhades.model.ClasspathEntry;
import org.jhades.model.ClasspathResource;
import org.jhades.model.ClasspathResourceVersion;
import org.jhades.model.ClazzLoader;
import org.jhades.model.JarPair;
import org.jhades.reports.DuplicatesReport;
import org.jhades.service.ClasspathScanner;*/
public class ClassConflictsJhades {
 
	public static void main(String srgs[]) {
		new JHades().multipleClassVersionsReport().overlappingJarsReport();
	}
}

 