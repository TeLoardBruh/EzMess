package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private TextView txtSender;
    private TextView txtText;
    private TextView txtBody;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Message message){
        txtSender.setText(message.getSender());
        txtText.setText(message.getText());
        txtBody.setText(message.getBody());
    }
}
