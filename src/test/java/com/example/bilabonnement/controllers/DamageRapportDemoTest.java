package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.DamageReportRepository;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DamageRapportDemoTest {


    private static DamageReportRepository damageReportRepository;
    private static WebDriver driver;
    private static DamageReport testDamageReport;
    private static String testChassisNumber;
    private static String testRegistrationNumber;
    private static String baseUrl;


    @BeforeAll()
    public static void setupAndPing() {
        WebDriverManager.chromedriver().setup();

        damageReportRepository = new DamageReportRepository();

        testChassisNumber = "demo";
        testRegistrationNumber = "demo";


        baseUrl = "https://bil-abonnement-a.herokuapp.com/";

    }

    public static void login() {
        driver = new ChromeDriver();

        driver.get(baseUrl);


        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("skade");
        password.sendKeys("skade");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    @Order(1)
    public void createDamageReport() {
        login();

        driver.get(baseUrl + "show-damagereport/" + testChassisNumber + "/" + testRegistrationNumber);

        WebElement createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        WebElement damageReportDescription = driver.findElement(By.id("description"));

        damageReportDescription.sendKeys("Parkeringsskade");
        createDamageReportButton.click();


        createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys("Parkeringsskade1");
        createDamageReportButton.click();

        createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys("Parkeringsskade2");
        createDamageReportButton.click();

        createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys("Parkeringsskade3");
        createDamageReportButton.click();

        createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys("Parkeringsskade4");
        createDamageReportButton.click();

        createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));
        damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys("Parkeringsskade5");
        createDamageReportButton.click();

    }

    @AfterAll
    public static void cleanup() {
        driver.close();
        driver.quit();
    }

}
