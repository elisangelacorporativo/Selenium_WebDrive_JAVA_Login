// Meu Primeiro Script de Teste #1: WebDriver com Java
// https://www.youtube.com/watch?v=lELENTQ-PWc

package tests;

import static org.junit.Assert.*;
import static org.openqa.selenium.By.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SingTest {
    @Test

    public void testFazerLoginNoTaskid() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Faz o sistema esperar 5 segundos
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Abre navegador
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Acessa pagina para fazer login
        navegador.findElement(By.linkText("Sign in")).click();

        // Insere usuário e senha
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("testeautomacao");
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");

        // Clica no SIGN IN "Entrar"
        navegador.findElement(By.linkText("SIGN IN")).click();

        // Identifica o link "Hi, Julio"

        String saudacao = navegador.findElement(By.className("me")).getText();
        assertEquals( "Hi, Teste", saudacao);

        // Fecha navegador
        navegador.quit();

    }
}
