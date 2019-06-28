package Interfaces.Console.View;


import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.POS;

import java.util.HashMap;
import java.util.Map;

public class HomeView extends AbstractView {

    protected POS pos;

    public HomeView(POS pos) {
        this.pos = pos;
    }

    @Override
    public void show() throws AuthenticationRequiredException {
        super.show();
    }

    @Override
    public void renderView() {
        int selectedValue;
        Map<Integer, AbstractView> menuViews = new HashMap<>();
        menuViews.put(1, new POSView(this.pos));
        menuViews.put(2, new LoginView());
        menuViews.put(3, new RegisterView());
        menuViews.put(4, new ExitView());

        MenuView menuView = new MenuView();
        do {
            menuView.screenSelection();
            selectedValue = menuView.getSelect();
            try {
                menuViews.get(selectedValue).show();
            } catch (AuthenticationRequiredException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (selectedValue != menuViews.size());
    }
}
