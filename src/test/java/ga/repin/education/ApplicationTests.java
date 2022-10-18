package ga.repin.education;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ga.repin.education.course02.topic12.hw.calculator.*;

@SpringBootTest
class ApplicationTests {

	@Test
	void testSuite01() {
		CalculatorServiceImplV2Test calcTests = new CalculatorServiceImplV2Test();
		calcTests.operationWelcomeContainCriticalInfo();
	}

	@Test
	void contextLoads() {
	}


}
