package auto.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
  private WebDriver driver;

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm'/input[3]"));
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

}
