package seleniumScript;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPathException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestLogin {
	ChromeDriver driver;
	String url = "http://127.0.0.1:8000";
	@Test(priority = -100)
	public void invocarNavegador() {
		//Cambiar esta ruta por la ruta donde tienes el chromedriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gueva\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//instancia
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test(priority = 1)
	public void verificarLoginAseisNew() {
		WebElement userEmail = driver.findElement(By.name("email"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		//Credenciales administrador
		userEmail.sendKeys("cm18064@ues.edu.sv");
		userPassword.sendKeys("Minerva.23");
		//Credenciales docente
		//userEmail.sendKeys("docente2@ues.edu.sv");
		//userPassword.sendKeys("Minerva.23");
		loginButton.click();
	}
	
	
//	@Test(priority = 2)
//	public void eliminar() {
//        try {
//            // Espera explícita para el botón de Noticias
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            WebElement btnNoticias = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/AdministrarNoticias/indexNoticias']")));
//            btnNoticias.click();
//            
//            // Espera explícita para el botón Editar
//            String dataIdNoticia = "74";
//            String xpathExpression = "//button[@data-id-noticia='" + dataIdNoticia + "']";
//            WebElement btnEditar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
//            hacerClickConJavaScript(btnEditar);
//            
//            TimeUnit.SECONDS.sleep(10);
//            // Espera explícita para el botón Eliminar
//            WebElement btnEliminar = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnEliminarNoticia")));
//            hacerClickConJavaScript(btnEliminar);
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
	
	public void hacerClickConJavaScript(WebElement elemento) {
        try {
            if (elemento.isEnabled() && elemento.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
            } else {
                System.out.println("El elemento no es interactuable");
            }
        } catch (Exception e) {
            System.out.println("Error al hacer clic con JavaScript: " + e.getMessage());
        }
    }
	
	
	
	@Test(priority = 2)
	public void testNoticiasPublicadasInfo() throws InterruptedException {
		String dataIdNoticia = "14";
		String xpathExpression = "//button[@data-id-noticia='" + dataIdNoticia + "']";

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		TimeUnit.SECONDS.sleep(40);
		WebElement btnNoticas = driver.findElement(By.id("noticiasPublicadas"));
		btnNoticas.click();
		TimeUnit.SECONDS.sleep(10);
		WebElement btnMostrarInfo = driver.findElement(By.xpath(xpathExpression));
		btnMostrarInfo.click();
		TimeUnit.SECONDS.sleep(10);
		WebElement btnEditar = driver.findElement(By.id("btnEditarNoticia"));
		btnEditar.click();
		TimeUnit.SECONDS.sleep(10);
		WebElement btnInput = driver.findElement(By.id("botonSubir"));
		btnInput.click();
	}

//	
//	@Test(priority = 2)
//	public void addCustomer() {
//		WebElement addCustomerLink = driver.findElement(By.linkText("New Customer"));
//		addCustomerLink.click();
//		
//		driver.findElement(By.xpath("//input[@value='m']")).click();
//		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("Avenida inclusion");
//		driver.findElement(By.name("name")).sendKeys("Danys");
//		driver.findElement(By.name("city")).sendKeys("San francisco gotera");
//		driver.findElement(By.name("dob")).sendKeys("00112987");
//		driver.findElement(By.name("state")).sendKeys("San carlos");
//		
//		driver.findElement(By.name("pinno")).sendKeys("123456");
//		driver.findElement(By.name("telephoneno")).sendKeys("77918927");
//		driver.findElement(By.name("emailid")).sendKeys("magiye1491@rdluxe.com");
//		driver.findElement(By.name("password")).sendKeys("elcun");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}
}
