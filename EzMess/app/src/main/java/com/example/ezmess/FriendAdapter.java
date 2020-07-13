package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendAdapter extends RecyclerView.Adapter<FriendViewHolder>{
    //    Schema
    private Friend[] friends;

    public FriendAdapter(Friend[] friends) {
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = layoutInflater.inflate(R.layout.view_holder_friend,viewGroup,false);


        return new FriendViewHolder(itemView);


    }



    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder friendViewHolder, int i) {

        Friend friend = friends[i];
        friendViewHolder.bind(friend);
    }

    @Override
    public int getItemCount() {
        return friends.length;
    }
}
