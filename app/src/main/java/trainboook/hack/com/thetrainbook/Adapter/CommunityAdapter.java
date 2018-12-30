package trainboook.hack.com.thetrainbook.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import trainboook.hack.com.thetrainbook.Activity.GroupActivity;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.R;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.MyViewHolder> {

    Context context;
    ArrayList<Community> communityArrayList;
    int lastSwipedPosition = -1;
    RecyclerView recyclerView;

    public CommunityAdapter(Context context, ArrayList<Community> communities, RecyclerView recyclerView) {
        this.context = context;
        this.communityArrayList = communities;
        this.recyclerView = recyclerView;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.community_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,final int position) {
        Community community = communityArrayList.get(position);
//        holder.swMain.addDrag(SwipeLayout.DragEdge.Left, holder.itemView.findViewById(R.id.bottom_wrapper));
//        holder.swMain.addDrag(SwipeLayout.DragEdge.Right, holder.itemView.findViewById(R.id.bottom_wrapper));
        holder.tvName.setText(community.getGroupName());
        holder.tvLastMsg.setText(community.getLastMsg());
        holder.tvMsgCount.setText(community.getMsgCount());
        holder.tvLastMsgTime.setText(community.getLastMsgTime());

//        holder.tvLastMsgTime.setVisibility(community.getMsgCount().isEmpty()?View.GONE:View.VISIBLE);
//        holder.cimvProfile.setVisibility(community.getMsgCount().isEmpty()?View.GONE:View.VISIBLE);
        holder.tvMsgCount.setVisibility(community.getMsgCount().isEmpty()?View.GONE:View.VISIBLE);
//        if(community.getLastMsgSrc()!=0){
            Picasso.with(context).load(community.getLastMsgSrc()).into(holder.cimvProfile);
//        }
//        holder.swMain.getSurfaceView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                context.startActivity(new Intent(context, GroupActivity.class) );
//
//                holder.swMain.close(true);
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, GroupActivity.class) );
            }
        });
        Picasso.with(context).load(community.getImgSrc()).into(holder.profilePic);

//        holder.swMain.addSwipeListener(new SwipeLayout.SwipeListener() {
//            @Override
//            public void onStartOpen(SwipeLayout layout) {
//                if (lastSwipedPosition != -1 && lastSwipedPosition != position) {
//                    SwipeLayout swipeLayout = (SwipeLayout) recyclerView.findViewHolderForAdapterPosition(lastSwipedPosition).itemView.findViewById(R.id.swMain);
//                    swipeLayout.close(true);
//                }
//                lastSwipedPosition = position;
//            }
//
//            @Override
//            public void onOpen(SwipeLayout layout) {
//
//            }
//
//            @Override
//            public void onStartClose(SwipeLayout layout) {
//
//            }
//
//            @Override
//            public void onClose(SwipeLayout layout) {
//
//            }
//
//            @Override
//            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
//
//            }
//
//            @Override
//            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return communityArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvLastMsg, tvLastMsgTime, tvMsgCount;
        CircleImageView profilePic,cimvProfile;
//        public SwipeLayout swMain;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvLastMsg = (TextView) itemView.findViewById(R.id.tvLastMsg);
            tvLastMsgTime = (TextView) itemView.findViewById(R.id.tvLastMsgTime);
            tvMsgCount = (TextView) itemView.findViewById(R.id.tvMsgCount);
            profilePic = (CircleImageView) itemView.findViewById(R.id.community_profile_image);
            cimvProfile= (CircleImageView) itemView.findViewById(R.id.cimvProfile);
//            swMain = itemView.findViewById(R.id.swMain);


        }
    }
}
