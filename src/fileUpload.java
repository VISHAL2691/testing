import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sony\\eclipse\\java-2022-06\\Grid\\chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popus", 0);
		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_word");

		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\sony\\Documents\\fileUpload.exe");

		// Note:while using Autoit feature then dn't touch your mouse because the script
		// got confused

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.downloader__btn.active")));
		driver.findElement(By.cssSelector("a.downloader__btn.active")).click();

		Thread.sleep(5000);
		File f = new File(downloadPath + "/Health_Policy_2022_23.docx");
		if (f.exists()) {
			Assert.assertTrue(f.exists());
			if (f.delete())
				System.out.println("file is deleted");
		}
	}

}
