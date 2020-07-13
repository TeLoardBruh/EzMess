package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendViewHolder  extends RecyclerView.ViewHolder {
    private TextView txtSender;
    private TextView txtText;
    private ImageView senderProfile;

    public FriendViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSender = itemView.findViewById(R.id.txt_sender);
        txtText = itemView.findViewById(R.id.txt_text);
//        senderProfile = itemView.findViewById(R.id.img_sender);

//        txtBody = itemView.findViewById(R.id.txt_body);
//        imgSender = itemView.findViewById(R.id.img_sender);
    }

    public void bind(Friend friend){
        txtSender.setText(friend.getSender());
        txtText.setText(friend.getText());
//        senderProfile.setImageDrawable(Drawable.createFromPath((message.getSenderProfile())));
//        txtBody.setText(message.getBody());
    }
}
