package trainboook.hack.com.thetrainbook.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import trainboook.hack.com.thetrainbook.Model.Community;
import trainboook.hack.com.thetrainbook.R;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.MyViewHolder>{

    Context context;
    ArrayList<Community> communityArrayList;

    public CommunityAdapter(Context context, ArrayList<Community> communities) {
        this.context = context;
        this.communityArrayList = communities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.community_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Community community  = communityArrayList.get(position);
        holder.tvName.setText(community.getGroupName());
        holder.tvLastMsg.setText(community.getLastMsg());
        holder.tvMsgCount.setText(community.getMsgCount());
        holder.tvLastMsgTime.setText(community.getLastMsgTime());

        Picasso.with(context).load(community.getImgSrc()).into(holder.profilePic);

    }

    @Override
    public int getItemCount() {
        return communityArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvLastMsg,tvLastMsgTime,tvMsgCount;
        CircleImageView profilePic;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvLastMsg = (TextView)itemView.findViewById(R.id.tvLastMsg);
            tvLastMsgTime = (TextView)itemView.findViewById(R.id.tvLastMsgTime);
            tvMsgCount = (TextView)itemView.findViewById(R.id.tvMsgCount);
            profilePic = (CircleImageView)itemView.findViewById(R.id.community_profile_image);



        }
    }
}
