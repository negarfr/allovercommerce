package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public HomePage(){

        // Constructor
        PageFactory.initElements(Driver.getDriver(), this);

    }



}
