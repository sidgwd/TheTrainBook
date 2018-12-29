package trainboook.hack.com.thetrainbook.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import trainboook.hack.com.thetrainbook.Adapter.CommunityAdapter;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.R;

public class CommunityFragment extends Fragment {

    Context context;
    RecyclerView rvCommunity;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Community> communities;
    FloatingActionButton fabAdd;


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
        CommunityAdapter communityAdapter= new CommunityAdapter(context,communities);
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

    }

    private void fillCommunities(ArrayList<Community> communities) {
        Community community = new Community();
        community.setGroupName("Friends");
        community.setLastMsg("Hello bro are you there");
        community.setMsgCount("+3");
        community.setLastMsgTime("5:50");
        community.setImgSrc(R.drawable.one);

        communities.add(community);

        Community community2 = new Community();
        community2.setGroupName("Fire Blade");
        community2.setLastMsg("Guys tommorow there is match");
        community2.setMsgCount("+2");
        community2.setLastMsgTime("5:59");
        community2.setImgSrc(R.drawable.two);

        communities.add(community2);

        Community community3 = new Community();
        community3.setGroupName("Rockers");
        community3.setLastMsg("Hello bro are you there");
        community3.setMsgCount("+3");
        community3.setLastMsgTime("5:50");
        community3.setImgSrc(R.drawable.two);

        communities.add(community3);

        Community community4 = new Community();
        community4.setGroupName("Friends");
        community4.setLastMsg("Hello bro are you there");
        community4.setMsgCount("+3");
        community4.setLastMsgTime("5:50");
        community4.setImgSrc(R.drawable.two);

        communities.add(community4);

        Community community5 = new Community();
        community5.setGroupName("Friends");
        community5.setLastMsg("Hello bro are you there");
        community5.setMsgCount("+3");
        community5.setLastMsgTime("5:50");
        community5.setImgSrc(R.drawable.two);

        communities.add(community5);

        Community community6 = new Community();
        community6.setGroupName("Friends");
        community6.setLastMsg("Hello bro are you there");
        community6.setMsgCount("+3");
        community6.setLastMsgTime("5:50");
        community6.setImgSrc(R.drawable.two);

        communities.add(community6);



    }


}
