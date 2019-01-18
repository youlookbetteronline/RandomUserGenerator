package com.example.gav.randomusergenerator.users;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gav.randomusergenerator.R;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivPhoto;
    private TextView tvName;
    private TextView tvInfo;

    public UsersViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivPhoto = itemView.findViewById(R.id.ivPhoto);
        tvName = itemView.findViewById(R.id.tvName);
        tvInfo = itemView.findViewById(R.id.tvInfo);
    }

    public void bind(ResultsItem resultsItem) {
        fillPhoto(resultsItem);
        fillName(resultsItem);
        fillInfo(resultsItem);
    }

    private void fillPhoto(ResultsItem resultsItem) {
        String url = resultsItem.getPicture().getMedium();

        Glide.with(ivPhoto)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(ivPhoto);
    }

    private void fillName(ResultsItem resultsItem) {
        String firstName = resultsItem.getName().getFirst();
        String lastName = resultsItem.getName().getLast();
        String name = firstName.substring(0, 1).toUpperCase() + firstName.substring(1)
                + " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1) ;
        tvName.setText(name);
    }

    private void fillInfo(ResultsItem resultsItem) {
        String city = resultsItem.getLocation().getCity();
        String state = resultsItem.getLocation().getState();
        String info = city.substring(0, 1).toUpperCase() + city.substring(1)
                + ", " + state.substring(0, 1).toUpperCase() + state.substring(1) ;
        tvInfo.setText(info);
    }
}
