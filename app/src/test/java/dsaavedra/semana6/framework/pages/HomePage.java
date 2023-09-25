package dsaavedra.semana6.framework.pages;

import dsaavedra.semana6.framework.utils.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {

    //Definir los localizadores
    By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar las acciones
    public void irARegistrarse(){
        //click(locatorBtnRegistrarte);
        click(esperarPorElementoLocalizado(locatorBtnRegistrarte));
    }
}
