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

public class SkillRecyclerviewAdapter extends RecyclerView.Adapter<SkillRecyclerviewAdapter.RecyclerViewHolder>{
    private Context context;
    private List<SkillModel> data;

    public SkillRecyclerviewAdapter(Context context,List<SkillModel> skillList) {
        this.context = context;
        this.data = skillList;
    }

    @NonNull
    @Override
    public SkillRecyclerviewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillRecyclerviewAdapter.RecyclerViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.skillNcountry.setText(data.get(position).getScore()+" skill IQ score, "+data.get(position).getCountry());
        holder.badge.setImageResource(R.drawable.skill_iq);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name, skillNcountry;
        AppCompatImageView badge;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            skillNcountry =itemView.findViewById(R.id.score_and_country);
            badge = itemView.findViewById(R.id.badge);
        }
    }
}
