package com.saucedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ArticleDetailUI {

    public static Target ARTICLE_PRICE_DETAIL_PAGE = Target.the("article price")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/following-sibling::div[@data-test='inventory-item-price']"
            );

    public static Target ARTICLE_DESCRIPTION_DETAIL_PAGE = Target.the("article description")
            .locatedBy(
                    "//div[@data-test='inventory-item-name' and normalize-space()='{0}']" +
                            "/following-sibling::div[@data-test='inventory-item-desc']"
            );

}
