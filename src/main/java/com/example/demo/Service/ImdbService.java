package com.example.demo.Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Service
public class ImdbService {

    public String imdbPuanÇek(String filmAdi) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("user-agent=Mozilla/5.0");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String rating = "";

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // 1. IMDb'de film araması yap
            String searchUrl = "https://www.imdb.com/find?q=" + URLEncoder.encode(filmAdi, StandardCharsets.UTF_8);
            driver.get(searchUrl);

            // 2. İlk film sonucunun linkini al
            // 2. Yeni IMDb arayüzüne göre ilk film sonucunu bul
            WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a.ipc-metadata-list-summary-item__t[href^='/title/tt']")
            ));
            String href = firstResult.getAttribute("href");
            System.out.println(href);
            // IMDb ID çek (örneğin: tt0111161)
            String imdbID = href.split("/")[4];
            System.out.println("IMDb ID: " + imdbID);

            // 3. Film detay sayfasına git
            driver.get("https://www.imdb.com/title/" + imdbID);

            // 4. Puan elementini bul ve yazdır
            WebElement ratingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("span.sc-d541859f-1")
            ));

            rating = ratingElement.getText();
            driver.quit();

        } catch (Exception e) {
            String hata = "Hata: " + e.getMessage();
            System.out.println(hata);
        } finally {
            driver.quit();
            return rating;
        }
    }
}