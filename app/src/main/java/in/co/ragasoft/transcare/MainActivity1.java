package in.co.ragasoft.transcare;

import android.graphics.Color;
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

import com.jackandphantom.circularprogressbar.CircleProgressbar;

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
    CircularMusicProgressBar circleProfileImage;
    String spinnerG;
    List<String> arrayList;
    @BindView(R.id.editProfile_circleImage)
    CircleImageView editProfile_circleImage;
    @BindView(R.id.profile_imageView)
    CircularMusicProgressBar imageView;
    @BindView(R.id.textView)
    TextView textView;

    EditText editText7;
    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;

    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView17)
    TextView textView17;
    @BindView(R.id.textView18)
    TextView textView18;
    @BindView(R.id.textView19)
    TextView textView19;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
        spinnerGender.setPrompt("sex");
        spinnerGender.setOnItemSelectedListener(this);
        circleProfileImage = findViewById(R.id.profile_imageView);
        // set progress to 40%
        circleProfileImage.setValue(0);
        circleProfileImage.setOnCircularBarChangeListener(new OnCircularSeekBarChangeListener() {
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
        circleProfileImage.setOnClickListener(new View.OnClickListener() {
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

        CircleProgressbar circleProgressbar = findViewById(R.id.yourCircularProgressbar);
        circleProgressbar.setForegroundProgressColor(Color.BLUE);
        //circleProgressbar.setBackgroundColor(Color.GREEN);
        circleProgressbar.setBackgroundColor(Color.TRANSPARENT);
        circleProgressbar.setBackgroundProgressWidth(10);
        circleProgressbar.setForegroundProgressWidth(10);
        circleProgressbar.setForegroundProgressWidth(10);
        circleProgressbar.enabledTouch(true);
        circleProgressbar.setRoundedCorner(true);
        circleProgressbar.setClockwise(true);
        int animationDuration = 2500; // 2500ms = 2,5s
        circleProgressbar.setProgressWithAnimation(65, animationDuration);
    }

    private void updateRandomly() {
        Random random = new Random();
        final float percent = random.nextFloat() * 100;
        circleProfileImage.setValue(percent);

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
