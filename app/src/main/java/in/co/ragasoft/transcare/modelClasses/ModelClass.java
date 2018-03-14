package in.co.ragasoft.transcare.modelClasses;

/**
 * Created by Rajat on 3/13/2018.
 */

public class ModelClass {

    String name;
    String discriptions;

    public ModelClass(String name, String discriptions) {
        this.name = name;
        this.discriptions = discriptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscriptions() {
        return discriptions;
    }

    public void setDiscriptions(String discriptions) {
        this.discriptions = discriptions;

    }

    @Override
    public String toString() {
        return name;
    }
}
