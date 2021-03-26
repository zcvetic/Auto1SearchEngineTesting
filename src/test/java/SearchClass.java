import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners

public class SearchClass extends BaseClass implements ITestListener {
    String url = "https://www.autohero.com/de/search/";
    WebDriverWait wait;
    By Reg_Button = By.id("yearFilter");
    By Reg_Start = By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/select[1]");
    By year = By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/select[1]/option[8]");
    By Price_Button = By.id("sortBy");
    By priceDesc = By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/select[1]/option[3]");
    By firstRegistrationFrom = By.xpath("//*[@class='button___50Uee']");
    By yearsOfRegistration = By.xpath("//*[@class='specItem___2gMHn'][1]");
    By pricesOfCars = By.xpath("//*[@class='title___uRijL price___1A8DG']");

    public void SearchClass(WebDriver driver) {
        BaseClass.driver = driver;
    }

        public void gotopage () {
            driver.get(url);
        }

        public void SelectYear (){
            driver.findElement(Reg_Button).click();
            driver.findElement(Reg_Start).click();
            driver.findElement(year).click();
            }

        public void SelectPrice (){
            driver.findElement(Price_Button).click();
            driver.findElement(priceDesc).click();
        }

        public void yearFilterAssertion () {
            String elementText = driver.findElement(firstRegistrationFrom).getText();
            Assert.assertTrue(elementText.contains("2015"), "filterNotOk");

            List<WebElement> firstRegistrationList = driver.findElements(yearsOfRegistration);
            for (WebElement element : firstRegistrationList) {
                Assert.assertTrue(Integer.parseInt(element.getText().trim()) >= 2015, "yearNotGreaterThan2015");
            }
        }

        public void priceFilterAssertion (){
            List<WebElement> priceList = driver.findElements(pricesOfCars);
            for (int i = 0; i<priceList.size() -1; i++) {
                double firstPrice = Double.parseDouble(priceList.get(i).getText().split(" ")[0].trim());
                double secondPrice = Double.parseDouble(priceList.get(i+1).getText().split(" ")[0].trim());
                Assert.assertTrue(firstPrice >= secondPrice, "pricesNotDesc : firstPrice = " + firstPrice + ", secondPrice = " + secondPrice);
            }
        }






}
