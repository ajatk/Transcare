package in.co.ragasoft.transcare;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    String spinnerG;
    List<String> arrayList;
    int mYear,mMonth,mDay;
    EditText editText7,dOB;
    TextView continu;
    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;
    int selectedItem = -1;
    private ImageView profileImage;
    String userChoosenTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        spinnerGender.setPrompt("sex");
        spinnerGender.setBackgroundColor(Color.TRANSPARENT);  spinnerGender.setOnItemSelectedListener(this);
        profileImage = findViewById(R.id.profile_imageView); profileImage.setOnClickListener(this);
        dOB = findViewById(R.id.tv_dateOfBirth); dOB.setOnClickListener(this);
        continu = findViewById(R.id.continue1); continu.setOnClickListener(this);

        arrayList = new ArrayList<String>();
        arrayList.add("Gender");
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Other");

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_textview, arrayList){
            @SuppressLint("ResourceAsColor")
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View v = null;
                v = super.getDropDownView(position, null, parent);
                // If this is the selected item position
                if (position == selectedItem) {
                    v.setBackgroundColor(Color.BLUE);
                }
                else {
                    // for other views
                    v.setBackgroundColor(R.color.blue_base_app_color1);

                }
                return v;
            }

        };
        arrayAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerGender.setAdapter(arrayAdapter); spinnerGender.setDrawingCacheBackgroundColor(Color.BLACK);

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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_dateOfBirth:
                convertToDate();
                break;
            case R.id.profile_imageView:
                selectImageResource();
                break;
            case R.id.continue1:
                Intent intent = new Intent(CreateAccount.this, HomeActivity.class);
                startActivity(intent);
                break;

        }
    }
    private void convertToDate() {
        final Calendar cTo = Calendar.getInstance();
        mYear = cTo.get(Calendar.YEAR);
        mMonth = cTo.get(Calendar.MONTH);
        mDay = cTo.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String day = String.valueOf(dayOfMonth);
                        String month = String.valueOf(monthOfYear+1);
                        if(day.length()==1)
                        {
                            day ="0"+day;
                        }
                        if(month.length()==1)
                        {
                            month ="0"+ month;
                        }
                        dOB.setText(day + "/" + month + "/" + year);

                       // todateString = toDate.getText().toString().trim();

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.setCanceledOnTouchOutside(false);
        datePickerDialog.show();
    }
    private void selectImageResource()
    {
        /*Example = http://www.theappguruz.com/blog/android-take-photo-camera-gallery-code-sample*/
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccount.this);
        builder.setTitle("Add Photo!");
      //  View view=getLayoutInflater().inflate(R.layout.dailog_title,null);builder.setCustomTitle(view);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                boolean result=Utility.checkPermission(CreateAccount.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask="Take Photo";

                    if(result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                 userChoosenTask="Choose from Library";
                    if(result)
                       galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public static class Utility {
        public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        public static boolean checkPermission(final Context context)
        {
            int currentAPIVersion = Build.VERSION.SDK_INT;
            if(currentAPIVersion>=android.os.Build.VERSION_CODES.M)
            {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Permission necessary");
                        alertBuilder.setMessage("External storage permission is necessary");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    } else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    }
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
    }
    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }



    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),12);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 12)
                onSelectFromGalleryResult(data);
            else if (requestCode == 1)
                onCaptureImageResult(data);
        }
    }
    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profileImage.setImageBitmap(bm);
    }
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profileImage.setImageBitmap(thumbnail);
    }
}
