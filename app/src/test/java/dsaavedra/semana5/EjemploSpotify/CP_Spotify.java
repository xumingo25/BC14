package dsaavedra.semana5.EjemploSpotify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class CP_Spotify {
    private WebDriver driver; //atributo

    @BeforeEach
    public void preCondiciones(){
        //Parametrizar la ruta del driver
        String rutaDriver =System.getProperty("user.dir")
                + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Enlazar el Webdriver de chrome al browser (Chrome)
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instaciar un objeto de tipo webdriver de google chrome
        driver = new ChromeDriver(); //Levantar el browser

        driver.get("https://open.spotify.com/"); //cargar url al browser
    }

    @AfterEach
    public void posCondiciones(){
        driver.quit();
    }

    @Test
    public void CP001_creacion_cta_spotify() throws InterruptedException {
        By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarte = driver.findElement(locatorBtnRegistrarte);

        btnRegistrarte.click();

        Thread.sleep(3000);

        driver.findElement(By.id("email")).sendKeys("maildeprueba135546363463432@gmail.com");

        driver.findElement(By.name("password")).sendKeys("ASD__234");

        driver.findElement(By.id("displayname")).sendKeys("Pobre Domingo");

        driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("28");

        Select selectorMes = new Select(driver.findElement(By.name("month")));

        selectorMes.selectByVisibleText("Febrero");

        driver.findElement(By.xpath("//input[@placeholder='AAAA']")).sendKeys("1991");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender_option')]"));

        js.executeScript("arguments[0].scrollIntoView();", generos.get(0));

        Thread.sleep(1000);
        generos.get(0).click();

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));

        js.executeScript("arguments[0].scrollIntoView();", checks.get(0));

        checks.get(0).click();
        checks.get(1).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    @Test
    public void CP002_Error_Creacion_Cta_Spotify_ctaExistente() throws InterruptedException {
        By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarte = driver.findElement(locatorBtnRegistrarte);

        btnRegistrarte.click();

        Thread.sleep(3000);

        driver.findElement(By.id("email")).sendKeys("domingo.saavedra.saavedra@gmail.com");

        driver.findElement(By.name("password")).sendKeys("ASD__234");

        driver.findElement(By.id("displayname")).sendKeys("Pobre Domingo");

        driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("28");

        Select selectorMes = new Select(driver.findElement(By.name("month")));

        selectorMes.selectByVisibleText("Febrero");

        driver.findElement(By.xpath("//input[@placeholder='AAAA']")).sendKeys("1991");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender_option')]"));

        js.executeScript("arguments[0].scrollIntoView();", generos.get(0));

        Thread.sleep(1000);
        generos.get(0).click();

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));

        js.executeScript("arguments[0].scrollIntoView();", checks.get(0));

        checks.get(0).click();
        checks.get(1).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String resultadoEsperado = corregirEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

        WebElement textoMensaje = driver.findElement(By.xpath("//span[contains(text(), 'Este correo')]"));

        String resultadoObtenido = textoMensaje.getText();

        Assertions.assertEquals(resultadoEsperado,resultadoObtenido);
    }

    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }

}
