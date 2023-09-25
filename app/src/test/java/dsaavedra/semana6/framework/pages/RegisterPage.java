package dsaavedra.semana6.framework.pages;

import dsaavedra.semana6.framework.utils.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends SeleniumBase {

    //Definir localizadores
    By locatorEmail = By.id("email");
    By locatorPassword = By.name("password");
    By locatorUsername = By.id("displayname");
    By locatorDiaNac = By.xpath("//input[@placeholder='DD']");
    By locatorMesNac = By.name("month");
    By locatorAnnioNac = By.xpath("//input[@placeholder='AAAA']");
    By locatorGeneros = By.xpath("//label[contains(@for,'gender_option')]");
    By locatorCheks = By.xpath("//label[contains(@for,'checkbox')]");
    By locatorIngresar = By.xpath("//button[@type='submit']");
    By locatorErrorCorreoExistente = By.xpath("//span[contains(text(), 'Este correo')]");
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar Acciones
    public void ingresarUsername(){
        escribirTexto(esperarPorElementoLocalizado(locatorUsername),"Domingo");
    }

    public void completarFormularioRegistro(String correo,String password, String username, String dia, String mes,String annio,int genero){

        escribirTexto(esperarPorElementoLocalizado(locatorEmail),correo);
        //esperarXSegundos(1000);
        escribirTexto(esperarPorElementoLocalizado(locatorPassword),password);
        //esperarXSegundos(1000);
        escribirTexto(esperarPorElementoLocalizado(locatorUsername),username);
        //esperarXSegundos(1000);
        escribirTexto(esperarPorElementoLocalizado(locatorDiaNac),dia);
        //esperarXSegundos(1000);
        seleccionarComboboxPorTextoVisible(locatorMesNac,mes);
        //esperarXSegundos(1000);
        escribirTexto(esperarPorElementoLocalizado(locatorAnnioNac),annio);
        //esperarXSegundos(1000);
        click(buscarElementosWeb(locatorGeneros).get(0));
        //esperarXSegundos(1000);
        scrollByLocator(locatorCheks);
        //esperarXSegundos(1000);
        click(buscarElementosWeb(locatorCheks).get(0));
        click(buscarElementosWeb(locatorCheks).get(1));
        //esperarXSegundos(1000);
        click(esperarPorElementoLocalizado(locatorIngresar));
    }
}
