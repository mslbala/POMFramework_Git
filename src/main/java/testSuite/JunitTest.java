package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestHomePage.class,
        TestContactUsPage.class,

})

public class JunitTest {
    // This class remains empty, it is used only as a holder for the above annotations.
}