import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;


public class SystemSpikeTest {

	@Test
	public void shouldReturnWhereTheProjectIsLaunched() {
		String separator = System.getProperty("file.separator");
		String baseDir = System.getProperty("user.dir").concat(separator).concat("bin").concat(separator).concat("xmlData").concat(separator);
		assertEquals(baseDir, "C:\\Users\\dfucci\\Desktop\\GitHub\\MusicPhone\\bin\\xmlData\\");
	}
	
	@Test
	public void shouldParseADate() throws ParseException{
	    SimpleDateFormat simpleDate = new SimpleDateFormat("EEE, dd MMM YY", Locale.US);
	    Date d = simpleDate.parse("Mon, 30 Mar 2010");
	    System.out.println(d.toString());
	}

}
