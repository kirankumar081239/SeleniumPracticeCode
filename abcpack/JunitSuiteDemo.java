package abcpack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlertDemo.class, ConfirmationDemo.class,
		ExplicitWaitDemo.class, SyncDemo.class, TabsDemo.class })
public class JunitSuiteDemo {

}
