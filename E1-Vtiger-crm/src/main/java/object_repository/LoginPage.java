package object_repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement un;

	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		LoginPage lp = new LoginPage(driver);
		WebElement un = lp.getUn();
		un.sendKeys("admin");

	}

}
