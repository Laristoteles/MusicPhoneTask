import static org.junit.Assert.*;

import org.junit.Test;


public class SystemSpikeTest {

	@Test
	public void shouldReturnWhereTheProjectIsLaunched() {
		assertEquals(System.getProperty("user.dir"), "dfucci");
	}

}
