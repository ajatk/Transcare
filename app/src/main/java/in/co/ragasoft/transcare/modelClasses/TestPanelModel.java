package in.co.ragasoft.transcare.modelClasses;

/**
 * Created by Rajat on 3/21/2018.
 */

public class TestPanelModel {

    String rupee;
    String name;

    public TestPanelModel(String rupee, String name) {
        this.rupee = rupee;
        this.name = name;
    }

    public String getRupee() {
        return rupee;

    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }

    public String getName() {
        return name;
    }
}
