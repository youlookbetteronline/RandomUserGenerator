package com.example.gav.randomusergenerator.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gav.randomusergenerator.R;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {
    private List<ResultsItem> users;
    private final UsersFragment.OnUserClickListener onUserClickListener;

    public UsersAdapter(List<ResultsItem> users, UsersFragment.OnUserClickListener onUserClickListener) {
        this.users = users;
        this.onUserClickListener = onUserClickListener;
    }

    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);
        final UsersViewHolder usersViewHolder = new UsersViewHolder(view);

        usersViewHolder.itemView.setOnClickListener(v -> {
            int position = usersViewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onUserClickListener.onUserClick(users.get(position));
            }
        });

        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setItems(List<ResultsItem> users) {
        this.users = users;
        notifyDataSetChanged();
    }
}
