package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.apache.commons.io.output.NullOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static WebDriver driver;
    //Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
    // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
    // çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
    // demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
    //donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1 WebbDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...

    // threadDriver.get() -> ilgili tread deki driveri verecek
    // threadDriver.set(driver) -> ilgili thread e driver set ediliyor.

    public static WebDriverWait wait;
    public static WebDriver getDriver() {

        // extend report türkçe bilg çalışmaması sebebiyle kondu
//        Locale.setDefault(new Locale("EN"));
//        System.setProperty("user.language", "EN");

        // Run ciktisindaki yazilarin temizlenmesi icin asagidaki kod yazildi
        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
        //java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        if(threadBrowserName.get()==null) { // parallel calismayan yani XMLden parametreyle gelmeyenler calissin diye
            threadBrowserName.set("chrome");
        }



        if (threadDriver.get() == null) { //Sistemde sadece bir defa driver calissin diye

            // extend report türkçe bilg çalışmaması sebebiyle kondu
            Locale.setDefault(new Locale("EN"));
            System.setProperty("user.language", "EN");


//            // Run ciktisindaki yazilarin temizlenmesi icin asagidaki kod yazildi
//            Logger.getLogger("").setLevel(Level.SEVERE);
//            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            //Logger.getLogger("io.github.bonigarcia").setLevel(Level.SEVERE);
//            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
//            DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
//            ChromeDriverService chromeDriverService = serviceBuilder.build();
//            chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);
            String browserName = threadBrowserName.get(); // bu threaddeki browsernamei verdi.

            switch (browserName)
            {

                case"chrome":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
                    ChromeDriverService chromeDriverService = serviceBuilder.build();
                    chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);
                    WebDriverManager.chromedriver().setup();
                    //driver = new ChromeDriver(chromeDriverService);

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    threadDriver.set(new ChromeDriver(options));


//                    Bekle(2);
                    break;
                case"firefox":
                    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());  // bu thread e firefox istenmişşse ve yoksa bir tane ekleniyor
//                    Bekle(2);
                    break;
                case"safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());  // bu thread e firefox istenmişşse ve yoksa bir tane ekleniyor
//                    Bekle(2);
                    break;
                case"edge":
                    System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    DriverService.Builder<EdgeDriverService, EdgeDriverService.Builder> serviceBuilderEdge = new EdgeDriverService.Builder();
                    EdgeDriverService edgeDriverService = serviceBuilderEdge.build();
                    edgeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());  // bu thread e firefox istenmişşse ve yoksa bir tane ekleniyor
//                    Bekle(2);
                    break;
//                case"chromium":
//                    WebDriverManager.operadriver().setup();
//                    threadDriver.set(new Driver );  // bu thread e firefox istenmişşse ve yoksa bir tane ekleniyor
//
//                    break;

            }


            //chrome




//            //firefox
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();

        }
        //wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Bekle(2);

        return threadDriver.get();
    }

    public static void quitDriver(){

     Bekle(3);

        if(threadDriver.get() != null){ //driver varsa
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }

    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
