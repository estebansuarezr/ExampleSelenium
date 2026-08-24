package com.saucedemo.tasks;
import com.saucedemo.models.Users;
import com.saucedemo.utils.MapUsers;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.saucedemo.userinterfaces.LogInUI.*;

public class Authenticate implements Task {

    private static Users user;

    public Authenticate(Users user) {
        Authenticate.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getStrUserId()).into(USER_TXT)
                , Enter.theValue(user.getStrPassword()).into(PASSWORD_TXT)
                , Click.on(LOGIN_BTN)
        );
    }

    public static Authenticate withTheCredentials (){
        Users user = MapUsers.init("NA");
        return Tasks.instrumented(Authenticate.class, user);
    }

}
