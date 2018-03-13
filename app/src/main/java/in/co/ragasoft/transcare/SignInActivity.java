package in.co.ragasoft.transcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signin = findViewById(R.id.sign_in);
        signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == signin) {
            Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
            startActivity(intent);
        }

    }
}
