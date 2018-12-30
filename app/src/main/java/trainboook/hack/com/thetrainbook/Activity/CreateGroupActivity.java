package trainboook.hack.com.thetrainbook.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.R;

public class CreateGroupActivity extends AppCompatActivity {

    Context context;
    CircleImageView cvGrpProfile;
    TextView tvGroupName;
    public static Community community;
    FloatingActionButton addContactsFab;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Create Group");
        context = CreateGroupActivity.this;
        cvGrpProfile = (CircleImageView)findViewById(R.id.cvGrpProfile);
        tvGroupName = (TextView)findViewById(R.id.tvGrpName);

        tvGroupName.setText(community.getGroupName());
        addContactsFab = (FloatingActionButton)findViewById(R.id.createGrpfab);
        addContactsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContactDialogue();
            }
        });

    }

    private void showContactDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add Members");
        builder.setView(getContextView());
        alertDialog = builder.create();
        alertDialog.show();

    }

    private View getContextView() {
        Button btnCreateGrp;
        View view = LayoutInflater.from(context).inflate(R.layout.contacts_dialogue,null,false);
        btnCreateGrp = (Button)view.findViewById(R.id.btnCreategroup);
        btnCreateGrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertDialog.isShowing()){
                    alertDialog.dismiss();
                    Toast.makeText(CreateGroupActivity.this, "Your Group has been created successfully...", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
