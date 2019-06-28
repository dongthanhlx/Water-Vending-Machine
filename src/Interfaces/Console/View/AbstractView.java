package Interfaces.Console.View;

import App.Application;
import App.Exceptions.AuthenticationRequiredException;

public abstract class AbstractView {
    protected boolean authRequired = false;

    protected void checkAuthorization() throws AuthenticationRequiredException {
        if(!Application.session().isLoggedIn()) {
            throw new AuthenticationRequiredException();
        }
    }

    public void show() throws AuthenticationRequiredException {
        if(this.authRequired) {
            checkAuthorization();
        }

        renderView();
    }

    protected abstract void renderView();
}
