package trainboook.hack.com.thetrainbook.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import trainboook.hack.com.thetrainbook.Adapter.CommunityAdapter;
import trainboook.hack.com.thetrainbook.Activity.CreateGroupActivity;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.R;

public class CommunityFragment extends Fragment {

    Context context;
    RecyclerView rvCommunity;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Community> communities;
    FloatingActionButton fabAdd;
    AlertDialog alertDialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_community, container, false);
        context = getActivity();
        init(view);
        return view;
    }

    private void init(View view) {
        rvCommunity = (RecyclerView)view.findViewById(R.id.rvCommunity);
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvCommunity.setLayoutManager(layoutManager);
        communities = new ArrayList<>();
        fillCommunities(communities);
        CommunityAdapter communityAdapter= new CommunityAdapter(context,communities,rvCommunity);
        rvCommunity.setAdapter(communityAdapter);

        fabAdd = (FloatingActionButton)view.findViewById(R.id.fab);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogue();
            }
        });

    }

    private void showDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Please enter the group name you want to create");
        builder.setView(getDialogueView());
        alertDialog = builder.create();
        alertDialog.show();

    }

    private View getDialogueView() {
        final EditText etGroupName;
        Button dialogueFab;
        TextInputLayout input_layout_password;
        View view = LayoutInflater.from(context).inflate(R.layout.dialogue,null,false);

        etGroupName = (EditText)view.findViewById(R.id.etGroupName);
        dialogueFab = (Button) view.findViewById(R.id.dialoguefab);
        dialogueFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etGroupName.getText().toString().isEmpty()){
                    etGroupName.setError("Group name is mandatory");
                }else {
                    CreateGroupActivity.community = new Community();
                    CreateGroupActivity.community.setGroupName(etGroupName.getText().toString().trim());
                    startActivity(new Intent(getContext(),CreateGroupActivity.class));
                    if (alertDialog.isShowing()){
                        alertDialog.dismiss();
                    }
                }
            }
        });


        return view;
    }

    private void fillCommunities(ArrayList<Community> communities) {
        Community community = new Community();
        community.setGroupName("The Explorers");
        community.setLastMsg("Hello bro are you there");
        community.setMsgCount("+7");
        community.setLastMsgTime("7:50");
        community.setImgSrc(R.drawable.group_image);
        community.setLastMsgSrc(R.drawable.sid);
        communities.add(community);

        Community community4 = new Community();
        community4.setGroupName("Goregaonkars");
        community4.setLastMsg("Any delays in train??");
        community4.setMsgCount("+3");
        community4.setLastMsgTime("9:12");
        community4.setLastMsgSrc(R.drawable.lochana);
        community4.setImgSrc(R.drawable.group1);

        communities.add(community4);


        Community community5 = new Community();
        community5.setGroupName("Last Benchers");
        community5.setLastMsg("Howz it going?");
        community5.setMsgCount("+1");
        community5.setLastMsgTime("3:15");
        community5.setLastMsgSrc(R.drawable.nitin);
        community5.setImgSrc(R.drawable.group2);

        communities.add(community5);

        Community community2 = new Community();
        community2.setGroupName("Fire Blade");
        community2.setLastMsg("Guys tommorow there is match");
        community2.setMsgCount("");
//        community5.setLastMsg("Howz it going?");
        community2.setLastMsgSrc(R.drawable.manish);
        community2.setLastMsgTime("1:59");
        community2.setImgSrc(R.drawable.group3);

        communities.add(community2);

        Community community3 = new Community();
        community3.setGroupName("Rockers");
        community3.setLastMsg("I'm Reaching there by 8 AM");
        community3.setMsgCount("");
        community3.setLastMsgTime("00:50");
        community3.setLastMsgSrc(R.drawable.namrata);
        community3.setImgSrc(R.drawable.one);
        communities.add(community3);




        Community community6 = new Community();
        community6.setGroupName("Unstopables");
        community6.setLastMsg("All Well?");
        community6.setMsgCount("");
        community6.setLastMsgTime("11:14");
        community6.setLastMsgSrc(R.drawable.deepika);
        community6.setImgSrc(R.drawable.two);

        communities.add(community6);

    }


}
