package trainboook.hack.com.thetrainbook.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

import trainboook.hack.com.thetrainbook.MainActivity;
import trainboook.hack.com.thetrainbook.NavDrawer.NavigationDrawerMenuFragment;
import trainboook.hack.com.thetrainbook.R;
import trainboook.hack.com.thetrainbook.Util.AppConfig;
import trainboook.hack.com.thetrainbook.Util.Imageutils;


public class ComplainBox extends Fragment {

    Context context;
    LinearLayout ll_attach;
    EditText etSubject,etDescription;
    FloatingActionButton fabSend;
    public Imageutils imageutils;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complain_box, container, false);
        context = getActivity();
        init(view);
        return view;
    }

    private void init(View view) {
        ll_attach =(LinearLayout)view.findViewById(R.id.ll_attach);
        ll_attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageutils.imagepicker(AppConfig.CAMERA_PICK_REQ,false);
            }
        });
        etSubject =(EditText)view.findViewById(R.id.etSubject);
        etDescription=(EditText)view.findViewById(R.id.etDescription);
        fabSend = (FloatingActionButton)view.findViewById(R.id.fabSend);
        imageutils = new Imageutils(getActivity());
        fabSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Your complain has been registered successfully...", Toast.LENGTH_SHORT).show();
                openHomeFragment();
            }
        });

    }


    public void openHomeFragment() {

        FragmentManager fm = getActivity().getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        MainActivity.fragmentClass = CommunityFragment.class;
        String title = context.getResources().getString(R.string.community);
        try {
            MainActivity.fragment = (Fragment) MainActivity.fragmentClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        NavigationDrawerMenuFragment.openFragment(context, MainActivity.fragment, null, title, false);
//        NavigationDrawerMenuFragment.vNavigation.getMenu().getItem(1).setChecked(true);
    }



}
