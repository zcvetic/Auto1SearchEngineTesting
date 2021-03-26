import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners
public class TestClass extends SearchClass implements ITestListener {

    @Test
    public void SearchResults () throws InterruptedException {
    gotopage();
    driver.manage().window().maximize();
    Wait();
    SelectYear();
    Wait();
    SelectPrice();
    Wait();
    yearFilterAssertion();
    Wait();
    priceFilterAssertion();
    }
}
