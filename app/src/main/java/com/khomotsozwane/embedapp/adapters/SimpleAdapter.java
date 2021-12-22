package com.khomotsozwane.embedapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khomotsozwane.embedapp.R;
import com.khomotsozwane.simple_service_library.models.Post;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleAdapterViewHolder> {

    private Context mContext;
    private List<Post> mPosts;

    public SimpleAdapter(Context context, List<Post> posts){
        this.mContext = context;
        this.mPosts = posts;
    }

    @NonNull
    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleAdapterViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.simple_adapter_view, null));
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleAdapterViewHolder holder, int position) {
        holder.textView.setText(mPosts.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public SimpleAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);

        }
    }


}
