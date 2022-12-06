import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authroizationpopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse\\java-2022-06\\WebDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Java Script web authorization pop up handles in below step
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
