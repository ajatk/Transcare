package in.co.ragasoft.transcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    Button signin, createAccont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signin = findViewById(R.id.quick_sign_in);
        createAccont = findViewById(R.id.createAccount);
        createAccont.setOnClickListener(this);
        signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.quick_sign_in:
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.createAccount:
                Intent cA = new Intent(SignInActivity.this, CreateAccount.class);
                startActivity(cA);
                break;


        }


    }
}
