package com.example.myapplication.adpters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ItemContainerRecentConversionBinding;
import com.example.myapplication.listeners.ConversionListener;
import com.example.myapplication.models.ChatMessage;
import com.example.myapplication.models.User;

import java.util.List;

public class RecentCoversationAdapter extends RecyclerView.Adapter<RecentCoversationAdapter.ConversionViewHolder>{

    private  final List<ChatMessage> chatMessages;
    private final ConversionListener conversionListener;

    public RecentCoversationAdapter(List<ChatMessage> chatMessages,ConversionListener conversionListener) {
        this.chatMessages = chatMessages;
        this.conversionListener = conversionListener;
    }

    @NonNull
    @Override
    public ConversionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConversionViewHolder(
                ItemContainerRecentConversionBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionViewHolder holder, int position) {
        holder.setData(chatMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    class ConversionViewHolder extends RecyclerView.ViewHolder{
        ItemContainerRecentConversionBinding binding;

        ConversionViewHolder(ItemContainerRecentConversionBinding itemContainerRecentConversionBinding){
            super(itemContainerRecentConversionBinding.getRoot());
            binding = itemContainerRecentConversionBinding;
        }

        void setData(ChatMessage chatMessage){
            binding.imageProfile.setImageBitmap(getCoversionImage(chatMessage.coversionImage));
            binding.textName.setText(chatMessage.coversionName);
            binding.textRecentMessage.setText(chatMessage.message);
            binding.getRoot().setOnClickListener(v->{
                User user = new User();
                user.id = chatMessage.coversionId;
                user.name = chatMessage.coversionName;
                user.image = chatMessage.coversionImage;
                conversionListener.onConversionClicked(user);
            });

        }
    }
    private Bitmap getCoversionImage(String encodedImage){
        byte[] bytes = Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0, bytes.length);
    }
}
