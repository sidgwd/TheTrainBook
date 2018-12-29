package trainboook.hack.com.thetrainbook.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import trainboook.hack.com.thetrainbook.Application.ApplicationMain;
import trainboook.hack.com.thetrainbook.MainActivity;
import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.Util.AppConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Login.class.getSimpleName();
    Button btnLogin;
    LinearLayout ll_otp, llTopLogo;
    public EditText etUserName, etPassword;
    ImageView iv_logo;
    TextView tvVAMS, tvForgot,tvSignup;
    static Login loginActivity;
    View viewUserName, viewPassword;
    CheckBox chkPassword;
    Spinner spnLanguages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    public void init() {
        btnLogin = findViewById(R.id.btnLogin);
        //tvVAMS = findViewById(R.id.tvVAMS);
        spnLanguages = findViewById(R.id.spnLanguages);
        chkPassword = findViewById(R.id.chkPassword);
        tvForgot = findViewById(R.id.tvForgot);
        loginActivity = Login.this;
        ll_otp = findViewById(R.id.ll_otp);
        iv_logo = findViewById(R.id.iv_logo);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        viewUserName = findViewById(R.id.viewUserName);
        viewPassword = findViewById(R.id.viewPassword);
        tvSignup = (TextView)findViewById(R.id.tvSignUp);
        tvSignup.setOnClickListener(this);

        //tvVAMS.setTypeface(ApplicationMain.TYPEFACE_FONT_REGULAR);
        btnLogin.setTypeface(ApplicationMain.TYPEFACE_FONT_REGULAR);
        spnLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        etUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                viewUserName.setBackgroundColor(getResources().getColor(hasFocus ? R.color.colorPrimary : R.color.border_color));
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                viewPassword.setBackgroundColor(getResources().getColor(hasFocus ? R.color.colorPrimary : R.color.border_color));
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                showPasswordToggle(!charSequence.toString().isEmpty() ? true : false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        chkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                etPassword.setInputType(b ? InputType.TYPE_CLASS_TEXT
                        : InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD);
                etPassword.setTypeface(ApplicationMain.TYPEFACE_FONT_LIGHT);
            }
        });
        showPasswordToggle(false);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void showPasswordToggle(boolean isShow) {
        chkPassword.setVisibility(isShow ? View.VISIBLE : View.GONE);
        tvForgot.setVisibility(isShow ? View.GONE : View.VISIBLE);

    }

    public void onLoginVerifyClick(View view) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(Login.this,RegistrationActivity.class));
    }
}
