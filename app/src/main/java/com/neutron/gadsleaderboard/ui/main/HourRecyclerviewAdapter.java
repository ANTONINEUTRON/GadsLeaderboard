package com.neutron.gadsleaderboard.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.neutron.gadsleaderboard.R;

import java.util.List;

public class HourRecyclerviewAdapter extends RecyclerView.Adapter<HourRecyclerviewAdapter.RecyclerViewHolder> {
    private Context context;
    private List<HourModel> data;

    public HourRecyclerviewAdapter(Context context, List<HourModel> list){
        this.context = context;
        this.data = list;
    }

    @NonNull
    @Override
    public HourRecyclerviewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HourRecyclerviewAdapter.RecyclerViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.hourNcountry.setText(data.get(position).getHour()+" learning hours, "+data.get(position).getCountry());
        holder.badge.setImageResource(R.drawable.top_learner);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name,hourNcountry;
        AppCompatImageView badge;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            hourNcountry = itemView.findViewById(R.id.score_and_country);
            badge = itemView.findViewById(R.id.badge);
        }
    }
}
