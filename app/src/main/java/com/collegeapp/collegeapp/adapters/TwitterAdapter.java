package com.collegeapp.collegeapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.collegeapp.collegeapp.R;
import com.collegeapp.collegeapp.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.ViewHolder> {
    Context context;
    List<User> userList;

    public TwitterAdapter(Context context, List<User> user) {
        this.context = context;
        this.userList = user;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardfornews, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        holder.postimg.setVisibility(View.GONE);

        User user=userList.get(i);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.date.setText(user.getPosttime());
        Glide.with(context.getApplicationContext()).load(user.getProfileimage()).into(holder.profileimg);
        if(!(user.getPostimage().equals("0"))){
            holder.postimg.setVisibility(View.VISIBLE);
            Glide.with(context.getApplicationContext()).load(user.getPostimage()).into(holder.postimg);
        }
        holder.description.setText(user.getPostdata());



    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profileimg)
        CircleImageView profileimg;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.lin)
        LinearLayout lin;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.postimg)
        ImageView postimg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

