package Runners;


import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin = { "html:target//cucumber-reports.html" }
)
//@Listeners({ExtentITestListenerClassAdapter.class})
public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) // bazı java versiyon hataları için, BROWSER bulamadım hatası verdiğinde msg: Optional olarak ekle
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        GWD.threadBrowserName.set(browser);
        //GWD.Bekle(2);
       //burada browser set edilecek
        // bu threade browsername set edildi.
    }

//    @AfterClass(alwaysRun = true) // bazı java versiyon hatalırı için, alternatif browser kapatma
//    public void afterClass() {
//        GWD.quitDriver();
//    }
//        @AfterClass
//        public static void writeExtentReport() {
//            ExtentService.getInstance().setSystemInfo("User Name", "İsmet Temur");
//            ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
//            ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
//            ExtentService.getInstance().setSystemInfo("Department", "QA");
//            ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
//        }
}
