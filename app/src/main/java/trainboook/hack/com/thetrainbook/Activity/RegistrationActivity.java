package trainboook.hack.com.thetrainbook.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.Util.AppConfig;
import trainboook.hack.com.thetrainbook.Util.Imageutils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

//import com.commercial.vams.viraat.Fragment.CreateAppointmentFragment;

public class RegistrationActivity extends AppCompatActivity implements Imageutils.ImageAttachmentListener  {

    android.support.v7.widget.Toolbar toolbar;
    public CircleImageView profile_image;
    public Imageutils imageutils;
    FloatingActionButton fabSend;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // In `OnCreate();`
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        profile_image = findViewById(R.id.profile_image);
        imageutils = new Imageutils(this);
        fabSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(RegistrationActivity.this,"Thank You For Registering With Us..!",Toast.LENGTH_LONG).show();
            }
        });
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageutils.imagepicker(AppConfig.CAMERA_PICK_REQ, profile_image.getTag() == null || profile_image.getTag().toString().isEmpty()
                        ? false : true);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onRegistrationClick(View view){

    }


    @Override
    public void image_attachment(int from, File fileloaction, String filename, Bitmap file, Uri uri) {

    }
}
