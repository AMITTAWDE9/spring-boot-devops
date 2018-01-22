package functionaltest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ftat {
	
	public HtmlUnitDriver driver;
	//public WebDriver driver;
	public WebDriverWait wait;
	public String homePage = "http://13.229.109.27:8080/DigitalELearn/";
	 
	@Test(priority = 0)
	public void indextest() {
		driver = new HtmlUnitDriver();
		//driver= new FirefoxDriver();
		//driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get(homePage);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Home Page content check
		driver.findElement(By.xpath("//a[@href='/DigitalELearn/product/1']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='/DigitalELearn/product/1']")));
		product.isDisplayed();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            clickLinkByHref("href", 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void clickLinkByHref(String href, int position) throws IOException {
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();

		int j = 0;
		while(i.hasNext()) {
			WebElement anchor = i.next();

			if(anchor.getAttribute("href").contains(href)) {
				j++;
			}

			if(anchor.getAttribute("href").contains(href)
					&& j == position) {
				anchor.click();
				break;
			}
		}

		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){
			url = it.next().getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			if(!url.startsWith(homePage)){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
