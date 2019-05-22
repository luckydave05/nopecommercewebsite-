package PageObject;

import com.nopecommerce.demohybrid.LoadProp;
import com.nopecommerce.demohybrid.Utils;
import org.openqa.selenium.By;

public class HomePage extends Utils
{



    private By _Currency  = By.id ("customerCurrency");
    private By _doller = By.xpath ("//span[@class='price actual-price'][1]");

    public void presentDollarSignAndSeeFeatureProductInSelectedCurrency  ()

    {
    checkWebelementpresent (_Currency);
    verifyPriceIsAscendingOrDecendingOrder (_doller);
    Utils.assertUseingSubString ("$",_doller);

    }


}
