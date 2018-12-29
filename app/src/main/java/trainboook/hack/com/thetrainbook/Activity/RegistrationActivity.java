package trainboook.hack.com.thetrainbook.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toolbar;

import trainboook.hack.com.thetrainbook.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//import com.commercial.vams.viraat.Fragment.CreateAppointmentFragment;

public class RegistrationActivity extends AppCompatActivity  {

    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
//        getSupportActionBar().setTitle("Register");
    }



}
