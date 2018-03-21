package in.co.ragasoft.transcare;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String spinnerG;
    List<String> arrayList;

    EditText editText7;
    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        spinnerGender.setPrompt("sex");
        spinnerGender.setBackgroundColor(Color.TRANSPARENT);
        spinnerGender.setOnItemSelectedListener(this);

        arrayList = new ArrayList<String>();
        arrayList.add("Gender");
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Other");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_textview, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerGender.setAdapter(arrayAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        Spinner spinner = (Spinner) adapterView;

        if (spinner.getId() == R.id.spinnerGender)

        {
            spinnerG = adapterView.getItemAtPosition(i).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
