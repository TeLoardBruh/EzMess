package com.example.ezmess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {


//    Schema
    private Message[] messages;
    private RecyclerViewClickListener listener;
    public MessageAdapter(Message[] messages, RecyclerViewClickListener listener) {
        this.messages = messages;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = layoutInflater.inflate(R.layout.view_holder_message,viewGroup,false);


        return new MessageViewHolder(itemView);


    }
    public class MessageViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        private TextView txtSender;
        private TextView txtText;
        private SimpleDraweeView imgSender;
        public MessageViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtSender = itemView.findViewById(R.id.txt_sender);
            txtText = itemView.findViewById(R.id.txt_text);
            imgSender = itemView.findViewById(R.id.img_sender);
//        senderProfile = itemView.findViewById(R.id.img_sender);
            itemView.setOnClickListener(this);

//        txtBody = itemView.findViewById(R.id.txt_body);
        }

        public void bind(Message message){
            txtSender.setText(message.getSender());
            txtText.setText(message.getText());
            imgSender.setImageURI(message.getSenderProfile());

        }


        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final MessageViewHolder messageViewHolder, int i) {

        final Message message = messages[i];

        messageViewHolder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.length;
    }

    public interface RecyclerViewClickListener{
        void onClick (View v, int i);
    }


}
