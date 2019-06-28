package Infra.Data;



import java.io.*;
import java.util.List;

public class FileDatabase<T> extends ObjectPersistence<T> {

    private String dataPath;

    public FileDatabase(String dataPath) {
        this.dataPath = dataPath;
    }

    private String makeDir(String className) {
        return this.dataPath + '/' + className.toLowerCase() + ".dat";
    }

    @Override
    public void write(Class<T> className, List<T> objects) {
        String absoluteDirectory = this.makeDir(className.getSimpleName());
        try {
            FileOutputStream fos = new FileOutputStream(absoluteDirectory);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objects);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Fail write file");
            e.printStackTrace();
        }
    }

    @Override
    public List<T> read(Class<T> className) {
        String absoluteDirectory = this.makeDir(className.getSimpleName());
        List<T> objects = null;
        try {
            FileInputStream fis = new FileInputStream(absoluteDirectory);
            if(fis.available() <= 0) return null;
            ObjectInputStream ois = new ObjectInputStream(fis);
            objects = (List<T>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Fail read file");
            e.printStackTrace();
        }
        return objects;
    }

}
