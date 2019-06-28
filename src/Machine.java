
import App.Exceptions.AuthenticationRequiredException;
import Domain.Entities.POS;
import Domain.Services.POSService;
import Interfaces.Console.View.*;


public class Machine {

    private static POS pos;

    public static void main(String []args) {
        POSService posService = new POSService();
        posService.load();
        pos = posService.getPOS().get(0);
        mainScreen();
    }

    public static void mainScreen() {
        HomeView homeView = new HomeView(pos);
        try {
            homeView.show();
        } catch (AuthenticationRequiredException e){
            System.out.println("Authentication required");
        }
    }
}
