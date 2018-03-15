package in.co.ragasoft.transcare.modelClasses;

/**
 * Created by Rajat on 3/13/2018.
 */

public class SpinnerModelClass {


    String male;


    public SpinnerModelClass(String male) {
        this.male = male;

    }

    public String getmale() {
        return male;
    }

    public void setmale(String male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return male;
    }
}
