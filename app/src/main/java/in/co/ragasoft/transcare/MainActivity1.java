package in.co.ragasoft.transcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import info.abdolahi.CircularMusicProgressBar;
import info.abdolahi.OnCircularSeekBarChangeListener;

public class MainActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "MainActivity";
    CircularMusicProgressBar progressBar;
    String spinnerG;
    List<String> arrayList;
    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.imageView)
    CircularMusicProgressBar imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.editText5)
    EditText editText5;
    @BindView(R.id.editText6)
    EditText editText6;
    @BindView(R.id.editText7)
    EditText editText7;
    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.textView14)
    TextView textView14;
    @BindView(R.id.editText)
    TextView editText;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView17)
    TextView textView17;
    @BindView(R.id.textView18)
    TextView textView18;
    @BindView(R.id.textView19)
    TextView textView19;
    @BindView(R.id.editText3)
    EditText editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
        spinnerGender.setPrompt("sex");
        spinnerGender.setOnItemSelectedListener(this);
        progressBar = findViewById(R.id.imageView);
        // set progress to 40%
        progressBar.setValue(40);
        progressBar.setOnCircularBarChangeListener(new OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularMusicProgressBar circularBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged: progress: " + progress + " / from user? " + fromUser);
            }

            @Override
            public void onClick(CircularMusicProgressBar circularBar) {
                Log.d(TAG, "onClick");
                updateRandomly();
            }

            @Override
            public void onLongPress(CircularMusicProgressBar circularBar) {
                Log.d(TAG, "onLongPress");
            }

        });
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRandomly();
            }
        });

        arrayList = new ArrayList<String>();
        arrayList.add("Gender");
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Other");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_textview, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerGender.setAdapter(arrayAdapter);
    }

    private void updateRandomly() {
        Random random = new Random();
        final float percent = random.nextFloat() * 100;
        progressBar.setValue(percent);

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
