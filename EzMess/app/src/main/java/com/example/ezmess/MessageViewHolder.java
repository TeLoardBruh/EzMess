package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

//public class MessageViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
//
//    private TextView txtSender;
//    private TextView txtText;
//    private SimpleDraweeView imgSender;
//    public MessageViewHolder(@NonNull View itemView) {
//        super(itemView);
//        txtSender = itemView.findViewById(R.id.txt_sender);
//        txtText = itemView.findViewById(R.id.txt_text);
//        imgSender = itemView.findViewById(R.id.img_sender);
////        senderProfile = itemView.findViewById(R.id.img_sender);
//        itemView.setOnClickListener(this);
//
////        txtBody = itemView.findViewById(R.id.txt_body);
//    }
//
//    public void bind(Message message){
//        txtSender.setText(message.getSender());
//        txtText.setText(message.getText());
//        imgSender.setImageURI(message.getSenderProfile());
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        MessageAdapter.RecyclerViewClickListener(v, getAdapterPosition());
//    }
//}
