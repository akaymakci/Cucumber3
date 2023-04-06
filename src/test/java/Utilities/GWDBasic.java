package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.output.NullOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWDBasic {

    private static WebDriver driver;
    public static WebDriverWait wait;
    public static WebDriver getDriver() {

        if (driver == null) { //Sistemde sadece bir defa driver calissin diye

            // extend report türkçe bilg çalışmaması sebebiyle kondu
            Locale.setDefault(new Locale("EN"));
            System.setProperty("user.language", "EN");

            // Run ciktisindaki yazilarin temizlenmesi icin asagidaki kod yazildi
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            //Logger.getLogger("io.github.bonigarcia").setLevel(Level.SEVERE);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
            ChromeDriverService chromeDriverService = serviceBuilder.build();
            chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

            //chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeDriverService);


//            //firefox
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();

        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        return driver;
    }

    public static void quitDriver(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver != null){ //driver varsa
            driver.quit();
            driver=null;
        }
    }

}
