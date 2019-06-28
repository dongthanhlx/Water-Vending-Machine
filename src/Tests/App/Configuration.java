package Tests.App;

import App.Configration;

public class Configuration {

    public void testCreate() {
        Configration config = new Configration();
        String path = config.getDataPath();

//        return Assert.equal(path, "./../data");
    }

}
