package seleniumScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {
	//Selenium contiene una clase para trabajar con Chrome, a�adimos nombre al objeto. Chrome Driver contiene el c�digo para interactuar con Chrome
	ChromeDriver driver;
	String url = "http://demo.guru99.com/v4/";
	
	//m�todo para invocar al navegador Chrome
	public void invocarNavegador() {
		//ruta donde se encuentra el ejecutable de chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gueva\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver(); //inicializando el objeto 
		driver.manage().window().maximize(); //maximizando la ventana
		driver.get(url); 
	}
	//m�todo para obtener el title de la p�gina e imprimirlo 
	public void getTitle() {
		String titleOfThePage = driver.getTitle();
		
		System.out.println("El titulo de la pagina es: - "+ titleOfThePage);
	}
	//para cerrar el navegador
	public void closeBrowser() {
		//quit cierra todas las pesta�as y close cierra unicamente la pesta�a activa
		//driver.quit();
	}
	
	//para ejecutar todo creamos la case principal, escribir main ctrl + space bar para generarla
	public static void main(String[] args) {
		WorkingWithChrome wc = new WorkingWithChrome();
		//llamar a los m�todos
		wc.invocarNavegador();
		wc.getTitle();
		wc.closeBrowser();		
	}
	
	@Test(priority = 0)
	public void verifyTitleOfThePage() {
		String titleEsperado = "Guru99 Bank Home Page";
		String actualTitle = driver.getTitle();
		//comparamos ambas titles para pasar o no pasar el caso de prueba 
		Assert.assertEquals(actualTitle, titleEsperado);
		
		
	}
	//segundo caso de prueba para verificar el login
	@Test(priority = 1)
	public void verificarLoginDeGuru99Application() {
		//para identificar elementos como el id, Selenium provee una interfaz llamada WebElement
		WebElement userId = driver.findElement(By.name("uid")); //locator 
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.name("btnLogin"));
		//ejecuci�n con el m�todo sendKeys
		userId.sendKeys("mngr453318");
		userPassword.sendKeys("ApudabY");
		loginButton.click();
			
	}
	
}
