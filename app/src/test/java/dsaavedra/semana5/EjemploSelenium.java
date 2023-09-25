package dsaavedra.semana5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploSelenium {
    public static void main(String[] args) {
        String rutaDriver = "C:\\Users\\domingo.saavedra\\Desktop\\BC14\\app\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Enlazar el driver (manejador)
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar un objeto de tipo WebDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
    }
}
