package in.co.ragasoft.transcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Splash extends AppCompatActivity implements View.OnClickListener {
    ImageView logo_spalsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        logo_spalsh = findViewById(R.id.logo);
        logo_spalsh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == logo_spalsh) {
            Intent intent = new Intent(Splash.this, Intro_SliderActivity.class);
            startActivity(intent);
        }

    }
}
