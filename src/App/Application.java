package App;

import Domain.Entities.POS;
import Infra.Data.FileDatabase;

import java.util.*;

public class Application {

    public static Configration config = null;
    public static UserSession session = null;
    public static EntityManager entityManager = null;
    public static List poss = null;

    public static Configration config() {
        if(config == null) {
            config = new Configration();
        }

        return config;
    }

    public static UserSession session()
    {
        if(session == null) {
            session = new UserSession();
        }

        return session;
    }

    public static EntityManager entityManager()
    {
        if(entityManager == null) {
            entityManager = new EntityManager(
                new FileDatabase(config().getDataPath())
            );
        }

        return entityManager;
    }

    public static List<POS> posList(){
        if(poss == null){
            poss = new ArrayList();
        }

        return poss;
    }

}
