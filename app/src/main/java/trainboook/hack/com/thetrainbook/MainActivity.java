package trainboook.hack.com.thetrainbook;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mxn.soul.flowingdrawer_core.FlowingView;
import com.mxn.soul.flowingdrawer_core.LeftDrawerLayout;

import java.util.ArrayList;

import trainboook.hack.com.thetrainbook.Fragment.CommunityFragment;
import trainboook.hack.com.thetrainbook.NavDrawer.NavigationDrawerMenuFragment;
import trainboook.hack.com.thetrainbook.Util.AppConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class MainActivity extends AppCompatActivity {

    final String TAG = MainActivity.class.getSimpleName().toString();
    RelativeLayout rl_main;
    static Context context;
    public static LeftDrawerLayout mLeftDrawerLayout;
    public static Toolbar toolbar;
    public static AppBarLayout appBarLayout;
    String permissionarray[];
    /////////////////////////init fragments
    public static Fragment fragment = null;
    public static Class fragmentClass = null;
    public static FragmentManager fragmentManager;
    CoordinatorLayout coordinatorLayout;
    TextView tvVersion;

    static MainActivity mainActivity;
    FlowingView mFlowingView;
    NavigationDrawerMenuFragment mMenuFragment;

    public static MainActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        context = MainActivity.this;
        fragmentManager = getSupportFragmentManager();
        // Setting fonts to all views
        rl_main = (RelativeLayout) findViewById(R.id.rl_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.content);

        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.MainActivity));

        toolbar.setNavigationIcon(R.drawable.menu);
        setSupportActionBar(toolbar);

        /////////////////////////////////////////////////////////////////////

        mLeftDrawerLayout = (LeftDrawerLayout) findViewById(R.id.id_drawerlayout);
        tvVersion = (TextView) findViewById(R.id.tvVersion);
        //tvVersion.setText("v  "+Utility.getAppVersion(this));

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        mMenuFragment = (NavigationDrawerMenuFragment) fm.findFragmentById(R.id.frame_container_menu);
        mFlowingView = (FlowingView) findViewById(R.id.navigationFlowView);

        if (mMenuFragment == null) {
            fm.beginTransaction().add(R.id.frame_container_menu, mMenuFragment = new NavigationDrawerMenuFragment()).commit();
        }
        mLeftDrawerLayout.setFluidView(mFlowingView);
        mLeftDrawerLayout.setMenuFragment(mMenuFragment);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        openHomeFragment();
        setPermissions();
        showTabPreview();
    }

    private void showTabPreview() {

        Handler mHandler;
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final MaterialTapTargetPrompt.Builder tapTargetPromptBuilder = new MaterialTapTargetPrompt.Builder(MainActivity.this)
                        .setPrimaryText("Navigation Menu")
                        .setSecondaryText("You can view the menus here")
                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                        .setMaxTextWidth(R.dimen.tap_target_menu_max_width).setCaptureTouchEventOnFocal(true)
                        .setCaptureTouchEventOutsidePrompt(false)
                        .setBackgroundColour(getResources().getColor(R.color.black))
                        .setFocalColour(getResources().getColor(R.color.focul_color1))
                        .setCaptureTouchEventOutsidePrompt(false)
                        .setTarget(toolbar.getChildAt(1));

                tapTargetPromptBuilder.setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                    @Override
                    public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                        //Do something such as storing a value so that this prompt is never shown again
                        Handler mHandler;
                        mHandler = new Handler();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                final MaterialTapTargetPrompt.Builder tapTargetPromptBuilder = new MaterialTapTargetPrompt.Builder(MainActivity.this)
                                        .setPrimaryText("Search your content")
                                        .setSecondaryText("You can Search Community and Commuters here..")
                                        .setAnimationInterpolator(new FastOutSlowInInterpolator())
                                        .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                                        .setBackgroundColour(getResources().getColor(R.color.tab_preview_background1))
                                        .setFocalColour(getResources().getColor(R.color.focul_color1))
                                        .setTarget(R.id.menuCommunity);

                                tapTargetPromptBuilder.setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                                    @Override
                                    public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                        //Do something such as storing a value so that this prompt is never shown again
//                                        Utility.writePreferencesForShowFirstTimeShow(context);

//                                        if (AppConfig.loggedInUserDetails.getAdmin()) {
                                            //Do something such as storing a value so that this prompt is never shown again
                                            Handler mHandler;
                                            mHandler = new Handler();
                                            mHandler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {

                                                    final MaterialTapTargetPrompt.Builder tapTargetPromptBuilder = new MaterialTapTargetPrompt.Builder(MainActivity.this)
                                                            .setPrimaryText("Create Group")
                                                            .setSecondaryText("You can create group here..")
                                                            .setAnimationInterpolator(new FastOutSlowInInterpolator())
                                                            .setMaxTextWidth(R.dimen.tap_target_menu_max_width)
                                                            .setCaptureTouchEventOnFocal(true)
                                                            .setBackgroundColour(getResources().getColor(R.color.gray))
                                                            .setFocalColour(getResources().getColor(R.color.focul_color1))
                                                            .setCaptureTouchEventOutsidePrompt(false)
                                                            .setTarget(R.id.fab);

                                                    tapTargetPromptBuilder.setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener() {
                                                        @Override
                                                        public void onHidePrompt(MotionEvent event, boolean tappedTarget) {
                                                            //Do something such as storing a value so that this prompt is never shown again
//                                                            Utility.writePreferencesForShowFirstTimeShow(context);


//                                                            appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
//                                                            toolbar = (Toolbar) findViewById(R.id.toolbar);
//                                                            toolbar.setTitle(getResources().getString(R.string.generate_alert));
//                                                            toolbar.setNavigationIcon(R.mipmap.ic_menu);
//                                                            setSupportActionBar(toolbar);
                                                        }

                                                        @Override
                                                        public void onHidePromptComplete() {

                                                        }
                                                    });
                                                    tapTargetPromptBuilder.show();
                                                }
                                            }, 800);
//                                        }


                                    }

                                    @Override
                                    public void onHidePromptComplete() {

                                    }
                                });

                                tapTargetPromptBuilder.show();


                            }
                        }, 800);
                    }

                    @Override
                    public void onHidePromptComplete() {

                    }
                });
                tapTargetPromptBuilder.show();
            }
        }, 3000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            mLeftDrawerLayout.openDrawer();
        }
        return super.onOptionsItemSelected(menuItem);
    }


    private void openHomeFragment() {
        MainActivity.fragmentClass = CommunityFragment.class;
        String title = context.getResources().getString(R.string.community);
        try {
            MainActivity.fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        NavigationDrawerMenuFragment.openFragment(this, MainActivity.fragment, null, title, false);
//        NavigationDrawerMenuFragment.vNavigation.getMenu().getItem(1).setChecked(true);
    }


    public void setPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            // check if GPS enabled
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

                ArrayList<String> perlist = new ArrayList<String>();
                String msg = getResources().getString(R.string.permssionmsg);
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    perlist.add(Manifest.permission.CAMERA);
                    if (!msg.isEmpty()) msg += "\n";
                    msg += getResources().getString(R.string.bullet) + " CAMERA";
                }

                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    perlist.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (!msg.isEmpty()) msg += "\n";
                    msg += getResources().getString(R.string.bullet) + " WRITE_EXTERNAL_STORAGE";
                }
                //To Get Sim information


                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {
                    perlist.add(Manifest.permission.READ_CONTACTS);
                    if (!msg.isEmpty()) msg += "\n";
                    msg += getResources().getString(R.string.bullet) + " READ_CONTACTS";
                }

                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    perlist.add(Manifest.permission.READ_PHONE_STATE);
                    if (!msg.isEmpty()) msg += "\n";
                    msg += getResources().getString(R.string.bullet) + " READ_PHONE_STATE";
                }


                permissionarray = new String[perlist.size()];
                permissionarray = perlist.toArray(permissionarray);
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {
                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setTitle("");
                    alertDialogBuilder
                            .setMessage(msg)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    ActivityCompat.requestPermissions(MainActivity.this,
                                            permissionarray,
                                            AppConfig.ALL_PERMISSION_CHECK);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } else {

                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            permissionarray,
                            AppConfig.ALL_PERMISSION_CHECK);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int  The callback method gets the
                    // result of the request.
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        try {
            if (mLeftDrawerLayout.isShownMenu()) {
                mLeftDrawerLayout.closeDrawer();
            } else if (toolbar.getTitle().toString().equals(getResources().getString(R.string.community))) {
                exitConfirm();
            } else {
                MainActivity.fragmentClass = CommunityFragment.class;
                String title = context.getResources().getString(R.string.community);
                MainActivity.fragment = (Fragment) MainActivity.fragmentClass.newInstance();
                NavigationDrawerMenuFragment.openFragment(context, MainActivity.fragment, null, title, true);
                NavigationDrawerMenuFragment.vNavigation.getMenu().getItem(1).setChecked(true);
//                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void exitConfirm() {
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        try {
//                            SPbean sPbean = new SPbean(context);
//                            sPbean.setPreference(sPbean.LOGIN_DATA, "");
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        String msg = "Do you want to exit?";

        String yesmsg = "Yes";

        String nomsg = "No";
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage((msg))
                .setPositiveButton((yesmsg), dialogClickListener)
                .setNegativeButton((nomsg), dialogClickListener).show();
    }

}
