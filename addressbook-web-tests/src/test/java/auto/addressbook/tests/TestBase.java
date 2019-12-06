package auto.addressbook.tests;

import auto.addressbook.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @Before
  public void setUp() throws Exception {
    app.init();
  }

  @After
  public void tearDown() {
    app.stop();
  }

}
