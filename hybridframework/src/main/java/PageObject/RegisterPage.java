package PageObject;

import com.nopecommerce.demohybrid.LoadProp;
import com.nopecommerce.demohybrid.Utils;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends Utils

{
    LoadProp loadProp = new LoadProp ();

    private By _clickOnRegisterPage =  By.xpath("//a[@href='/register']");
    private By _verifyRegisterPage = By.xpath("//div[@class='page-title']");
    private By _firstname = By.xpath("//input[@id='FirstName']");
    private By _lastname = By.xpath("//input[@id='LastName']");
    private By _date = By.xpath ("//select[@name='DateOfBirthDay']");
    private By _month = By.xpath ("//select[@name='DateOfBirthMonth']");
    private By _year = By.xpath ("//select[@name='DateOfBirthYear']");
    private By _email = By.xpath ("//input[@id='Email']");
    private By _password = By.xpath ("//input[@id='Password']");
    private By _confirmpassword = By.xpath ("//input[@id='ConfirmPassword']");
    private By _register = By.xpath("//input[@class='button-1 register-next-step-button']");
    private By _registrationcomplication = By.xpath ("//div[@class='result']");



    public void registerPage()
    {
        clickelement (_clickOnRegisterPage);
        //assertUrl ("https://demo.nopcommerce.com/register");
        assertTextMessage ("Register",_verifyRegisterPage);
    }
    public void registerPersonalDetails()
    {
        String timestamp = new SimpleDateFormat ("dd.MM.yy.HH.mm.ss").format (new Date ());
        enterTextInInputField (_firstname,loadProp.getPropety ("firstname"));
        enterTextInInputField (_lastname,loadProp.getPropety ("lastname"));
        enterTextInInputField (_date,loadProp.getPropety ("date"));
        enterTextInInputField (_month,loadProp.getPropety ("month"));
        enterTextInInputField (_year,loadProp.getPropety ("year"));

        String first = loadProp.getPropety ("first");
        String seconde = loadProp.getPropety ("seconde");
        String fullemail = first + timestamp + seconde;
        enterTextInInputField (_email,fullemail);

        enterTextInInputField (_password,loadProp.getPropety ("password"));
        enterTextInInputField (_confirmpassword,loadProp.getPropety ("confirmpassword"));
        clickelement (_register);
        assertTextMessage ("Your registration completed",_registrationcomplication);




    }
}
