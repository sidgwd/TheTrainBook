package trainboook.hack.com.thetrainbook.NavDrawer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.List;

import trainboook.hack.com.thetrainbook.Fragment.CommunityFragment;
import trainboook.hack.com.thetrainbook.Fragment.ComplainBox;
import trainboook.hack.com.thetrainbook.MainActivity;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.ProfileFragment;
import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.ReportFragment;


//import com.commercial.vams.viraat.Fragment.CreateAppointmentFragment;
//import com.commercial.vams.viraat.Fragment.ScheduleAppointmentFragment;


public class NavigationDrawerMenuFragment extends com.mxn.soul.flowingdrawer_core.MenuFragment {
    public static NavigationView vNavigation;
    public static Context context;
    static AppCompatActivity activity;

    static View view = null;
    static NavigationDrawerMenuFragment navigationDrawerMenuFragment;

    public static NavigationDrawerMenuFragment getInstance() {
        return navigationDrawerMenuFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu_nav, container,
                false);
        context = getActivity();
        activity = (AppCompatActivity) getActivity();
        navigationDrawerMenuFragment = this;
        RelativeLayout rl_main = (RelativeLayout) view.findViewById(R.id.rl_main);
        // Setting fonts to all views

        vNavigation = (NavigationView) view.findViewById(R.id.vNavigation);


        FrameLayout fm_main = (FrameLayout) vNavigation.getHeaderView(0);


        setupNavigation();
//        setNavigationBadges();
        disableNavigationViewScrollbars(vNavigation);
        return setupReveal(view);
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    //    private void setNavigationBadges() {
//        MenuItem element = vNavigation.getMenu().findItem(R.id.menuScheduleAppointmentTabs);
//
//        String before = element.getTitle().toString();
//
//        String counter = Integer.toString(5);
//        String s = before + "   " + counter + " ";
//        SpannableString sColored = new SpannableString(s);
//
//        sColored.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.white)), s.length() - 3, s.length(), 0);
//        sColored.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary)), s.length() - 3, s.length(), 0);
//
//
//        element.setTitle(sColored);
//    }
    /*public void setNavigationBadges(GetDashBoardCountForMobile getDashBoardCountForMobile) {
        //Gravity property aligns the text
        TextView pendingRequest = (TextView) MenuItemCompat.getActionView(vNavigation.getMenu().
                findItem(R.id.menuPendingAppointment));
        pendingRequest.setGravity(Gravity.CENTER_VERTICAL);
        pendingRequest.setTypeface(ApplicationMain.TYPEFACE_FONT_LIGHT, Typeface.NORMAL);
        pendingRequest.setTextColor(getResources().getColor(R.color.colorPrimary));
        pendingRequest.setText(getDashBoardCountForMobile.getPendingAppointmentCount() > 10 ? "10+" :
                String.valueOf(getDashBoardCountForMobile.getPendingAppointmentCount()));

        TextView appointmentTab = (TextView) MenuItemCompat.getActionView(vNavigation.getMenu().
                findItem(R.id.menuScheduleAppointmentTabs));
        appointmentTab.setGravity(Gravity.CENTER_VERTICAL);
        appointmentTab.setTypeface(ApplicationMain.TYPEFACE_FONT_LIGHT, Typeface.NORMAL);
        appointmentTab.setTextColor(getResources().getColor(R.color.colorPrimary));
        appointmentTab.setText(getDashBoardCountForMobile.getTotalAppointment() > 10 ? "10+" :
                String.valueOf(getDashBoardCountForMobile.getTotalAppointment()));
    }*/

    public void onOpenMenu() {
//        Toast.makeText(getActivity(), "onOpenMenu", Toast.LENGTH_SHORT).show();
    }

    public void onCloseMenu() {
//        Toast.makeText(getActivity(), "onCloseMenu", Toast.LENGTH_SHORT).show();
    }

    private static void setupNavigation() {
        try {
            //we are getting action bar bug as it is disable we need to re assign if
            MainActivity.toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
            MainActivity.toolbar.setNavigationIcon(R.drawable.menu);

            vNavigation.getMenu().getItem(0).setChecked(true);
//            NavigationDrawerMenuFragment.vNavigation.setCheckedItem(R.id);


            activity.setSupportActionBar(MainActivity.toolbar);
            vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(final MenuItem item) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String title = "";
                            MainActivity.fragmentClass = null;
                            MainActivity.fragment = null;
                            switch (item.getItemId()) {
//                                case R.id.menuCreateAppointment:
////                                    TabMainMenuActivity.fragmentClass = CreateAppointmentFragment.class;
//                                    title = context.getResources().getString(R.string.create_appointment);
//                                    break;

                                case R.id.menuCommunity:
                                    try {
                                        MainActivity.fragmentClass = CommunityFragment.class;
                                        title = context.getResources().getString(R.string.community);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;

                                case R.id.menuComplainBox:
                                    MainActivity.fragmentClass = ComplainBox.class;
                                    title = context.getResources().getString(R.string.complain_box);
                                    break;
                                case R.id.menuProfile:
                                    MainActivity.fragmentClass = ProfileFragment.class;
                                    title = context.getResources().getString(R.string.profile);
                                    break;
                                case R.id.menuReport:
                                    MainActivity.fragmentClass = ReportFragment.class;
                                    title = context.getResources().getString(R.string.report);
                                    break;

                                case R.id.menuLogout:
//

                                    break;


                            }


                            try {
                                //to speed up the operation

//                                    if( item.getItemId()){
                                try {
                                    if (MainActivity.fragmentClass != null) {
                                        MainActivity.fragment = (Fragment) MainActivity.fragmentClass.newInstance();
                                    }
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                                if (MainActivity.fragment != null) {
                                    Log.e("Current visible frag:", getVisibleFragment().getClass().getSimpleName());
                                    Log.e("Changed frag:", MainActivity.fragment.getClass().getSimpleName());
                                    if (!getVisibleFragment().getClass().getSimpleName().equals
                                            (MainActivity.fragment.getClass().getSimpleName())) {
                                        openFragment(context, MainActivity.fragment, item, title, true);
                                        NavigationDrawerMenuFragment.vNavigation.setCheckedItem(item.getItemId());
                                    }
                                }

                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        }
                    }, 50);


                    //navigate and close the drawer


                    MainActivity.mLeftDrawerLayout.closeDrawer();

                    return false;
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void openFragment(Context context, Fragment fragment,
                                    MenuItem menuItem,
                                    String toobarTitle, boolean needsToReplace) {
        try {
            if (fragment != null) {
                FragmentTransaction transaction = MainActivity.fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                if (needsToReplace) {
                    android.support.v4.app.FragmentManager fm = MainActivity.fragmentManager;
                    for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                        fm.popBackStack();
                    }
                    transaction.replace(R.id.flContent, fragment);
                    transaction.addToBackStack(null);
                } else {
                    transaction.add(R.id.flContent, fragment);
                    transaction.addToBackStack(fragment.getClass().getSimpleName());
                }
                if (toobarTitle.equals(context.getResources().getString(R.string.community))) {
                    try {

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                transaction.commit();
                if (!toobarTitle.isEmpty()) {
                    MainActivity.toolbar.setTitle(toobarTitle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Fragment getVisibleFragment() {
        List<Fragment> fragments = MainActivity.fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null && fragment.isVisible())
                    return fragment;
            }
        }
        return null;
    }


}
