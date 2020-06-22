package com.example.ezmess;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.facebook.drawee.view.SimpleDraweeView;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private TextView txtSender;
    private TextView txtText;
    private ImageView senderProfile;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSender = itemView.findViewById(R.id.txt_sender);
        txtText = itemView.findViewById(R.id.txt_text);
        senderProfile = itemView.findViewById(R.id.img_sender);

//        txtBody = itemView.findViewById(R.id.txt_body);
//        imgSender = itemView.findViewById(R.id.img_sender);
    }

    public void bind(Message message){
        txtSender.setText(message.getSender());
        txtText.setText(message.getText());
        senderProfile.setImageDrawable(Drawable.createFromPath((message.getSenderProfile())));
//        txtBody.setText(message.getBody());
    }
}
