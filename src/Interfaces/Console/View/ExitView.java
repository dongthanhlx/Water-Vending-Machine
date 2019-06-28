package Interfaces.Console.View;

import App.Exceptions.AuthenticationRequiredException;
import App.UserSession;

public class ExitView extends AbstractView {

    public ExitView() {
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    protected void renderView() {
        UserSession userSession = new UserSession();
        userSession.unsetLoginData();
    }

}
