package App;

public class Configration {
    private String configPath = "./../config.json";

    protected String dataPath;
    protected String sessionTimeout;
    protected int cartSize;

    public Configration() {
        // Read config.json

        this.dataPath = "data";

    }

    public String getDataPath() {
        return dataPath;
    }

    public String getSessionTimeout() {
        return sessionTimeout;
    }

    public int getCartSize() {
        return cartSize;
    }
}
