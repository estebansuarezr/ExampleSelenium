package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutUI {

    public static final Target FIRST_NAME_TXT = Target.the("First name Field")
            .located(By.id("first-name"));

    public static final Target LAST_NAME_TXT = Target.the("Last name Field")
            .located(By.id("last-name"));

    public static final Target ZIP_CODE_TXT = Target.the("Zip code field")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BTN = Target.the("Continue button")
            .located(By.id("continue"));

    public static final Target FINISH_BTN = Target.the("Finish button")
            .located(By.id("finish"));

    public static final Target CONFIRMATION_MSG = Target.the("Confirmation message")
            .located(By.xpath("//h2[normalize-space()='Thank you for your order!']"));
}
