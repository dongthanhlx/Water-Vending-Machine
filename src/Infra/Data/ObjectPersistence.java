package Infra.Data;

import java.util.List;

abstract public class ObjectPersistence<T> {

    public abstract void write(Class<T> className, List<T> object);
    public abstract List<T> read(Class<T> className);

}
