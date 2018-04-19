package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import in.co.ragasoft.transcare.R;

public class EditProfile extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";
    Context context;

    String spinnerG;
    List<String> arrayList;
    @BindView(R.id.editProfile_circleImage)
    CircleImageView editProfileCircleImage;

    @BindView(R.id.edit_Name)
    EditText editName;
    @BindView(R.id.edit_address)
    EditText editAddress;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_phoneNo)
    EditText editPhoneNo;
    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;
    @BindView(R.id.editProfile)
    TextView editProfile;
    @BindView(R.id.tv_dateOfBirth)
    TextView tvDateOfBirth;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.tv_height)
    EditText tvHeight;
    @BindView(R.id.weight)
    EditText weight;
    @BindView(R.id.button_submit)
    Button buttonSubmit;
    Toolbar toolbar;
    ConstraintLayout srchlocationLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        context = getActivity();
        ButterKnife.bind(getActivity());
        // srchlocationLayout =(ConstraintLayout)getActivity().findViewById(R.id.srch_toolbar_layout);
        // srchlocationLayout.setVisibility(View.GONE);
        //locationT = view.findViewById(R.id.location_text);
//        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        //  toolbar.setTitle("EDIT PROFILE");
        spinnerGender = view.findViewById(R.id.spinnerGender);
        //  spinnerGender.setPrompt("sex");
        spinnerGender.setOnItemSelectedListener(this);


        arrayList = new ArrayList<String>();
        arrayList.add("Gender");
        arrayList.add("Male");
        arrayList.add("Female");
        arrayList.add("Other");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_textview, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_textview);
        spinnerGender.setAdapter(arrayAdapter);


        return view;
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
    public void onDestroyView() {
        super.onDestroyView();

    }

}
