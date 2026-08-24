package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {

    public static Target ADD_TO_CART = Target.the("Add to cart button")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/ancestor::div[@data-test='inventory-item']" +
                            "//button[contains(@data-test,'add-to-cart')]"
            );
    public static Target ARTICLE_DESCRIPTION = Target.the("article description")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/ancestor::div[@data-test='inventory-item']" +
                            "//div[@data-test='inventory-item-desc']"
            );

    public static Target ARTICLE_PRICE = Target.the("article price")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/ancestor::div[@data-test='inventory-item']" +
                            "//div[@data-test='inventory-item-price']"
            );

    public static final Target CART_BTN = Target.the("Cart button")
            .located(By.id("shopping_cart_container"));

}
