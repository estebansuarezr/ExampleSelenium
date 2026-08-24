package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.userinterfaces.ArticleDetailUI.ARTICLE_DESCRIPTION_DETAIL_PAGE;
import static com.saucedemo.userinterfaces.ArticleDetailUI.ARTICLE_PRICE_DETAIL_PAGE;
import static com.saucedemo.userinterfaces.CartUI.ARTICLE_NAME;
import static com.saucedemo.userinterfaces.HomePageUI.ARTICLE_DESCRIPTION;
import static com.saucedemo.userinterfaces.HomePageUI.ARTICLE_PRICE;

public class GoToArticleDetail implements Task {


    private final String articleName;

    public GoToArticleDetail(String articleName) {
        this.articleName =articleName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember("articleDescriptionHomePage",
                Text.of(ARTICLE_DESCRIPTION.of(articleName))
                        .answeredBy(actor));

        actor.remember("articlePriceHomePage",
                Text.of(ARTICLE_PRICE.of(articleName))
                        .answeredBy(actor));

        actor.attemptsTo(
                Click.on(ARTICLE_NAME.of(articleName))
        );

        actor.remember("articleDescriptionDetail",
                Text.of(ARTICLE_DESCRIPTION_DETAIL_PAGE.of(articleName))
                        .answeredBy(actor));

        actor.remember("articlePriceDetail",
                Text.of(ARTICLE_PRICE_DETAIL_PAGE.of(articleName))
                        .answeredBy(actor));
    }

    public static GoToArticleDetail page(String articleName){
        return Tasks.instrumented(GoToArticleDetail.class, articleName);
    }
}
