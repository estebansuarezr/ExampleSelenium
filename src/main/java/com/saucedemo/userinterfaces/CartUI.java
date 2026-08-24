package com.saucedemo.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUI {

    public static Target REMOVE_ARTICLE = Target.the("remove article button")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/ancestor::div[@class='cart_item_label']" +
                            "//button[contains(@data-test,'remove-')]"
            );

    public static Target ARTICLE_NAME = Target.the("Article: {0}")
            .locatedBy("//div[@data-test='inventory-item-name' and normalize-space()='{0}']");

    public static final Target CHECKOUT_BTN = Target.the("Checkout button")
            .located(By.id("checkout"));

}
