package App;

import Infra.Data.ObjectPersistence;

import java.util.List;

public class EntityManager<T> {
    protected ObjectPersistence objectPersistence;

    public EntityManager(ObjectPersistence objectPersistence) {
        this.objectPersistence = objectPersistence;
    }

    public void write(Class<T> className, List<T> objects) {
        this.objectPersistence.write(className, objects);
    }

    public List<T> read(Class<T> className) {
        return this.objectPersistence.read(className);
    }

}
