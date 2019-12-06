package auto.addressbook.tests;

import org.junit.Test;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.gotoGroupPage();
    app.getGroupHelper().selectGroup();
  }

}