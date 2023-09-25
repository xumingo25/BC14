package dsaavedra.semana6.framework.tests;

import dsaavedra.semana6.framework.pages.HomePage;
import dsaavedra.semana6.framework.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestSpotify {
    //Atributos
    WebDriver driver;
    HomePage home;
    RegisterPage register;
    String rutaDriver = "C:\\Users\\domingo.saavedra\\Desktop\\BC14\\app\\src\\test\\resources\\drivers\\chromedriver.exe";
    String browser = "Chrome";
    String property = "webdriver.chrome.driver";

    @BeforeEach
    public void preTests(){
        home = new HomePage(driver);
        home.conexionDriver(browser,rutaDriver,property);
        register = new RegisterPage(home.getDriver());
        home.cargarPagina("https://open.spotify.com/");
    }

    @Test
    public void CP001_IngresoOK(){
        home.irARegistrarse();
        register.completarFormularioRegistro("domnasdffas@gmail.com","safd34534","User 0001","25","Septiembre","1991",0);
        Assertions.assertTrue(true);
    }

    @AfterEach
    public void afterTests(){
        home.cerrarBrowser();
    }
}
