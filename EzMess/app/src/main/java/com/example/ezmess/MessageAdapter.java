package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {


//    Schema
    private Message[] messages;

    public MessageAdapter(Message[] messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = layoutInflater.inflate(R.layout.view_holder_message,viewGroup,false);


        return new MessageViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {

        Message message = messages[i];
        messageViewHolder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.length;
    }
}
