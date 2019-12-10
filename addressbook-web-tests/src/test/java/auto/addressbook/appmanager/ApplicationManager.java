package auto.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public Map<String, Object> vars;
  Object js;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
      if (browser == BrowserType.FIREFOX) {
      driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (browser == BrowserType.CHROME) {
      driver = new ChromeDriver();
    } else if (browser == BrowserType.IE) {
      driver = new InternetExplorerDriver();
    }
    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    js = (Object) driver;
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    driver.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void gotoGroupPage() { navigationHelper.gotoGroupPage(); }

  //public void deleteSelectedGroup() {    driver.findElement(By.name("delete")).click();  }
}
