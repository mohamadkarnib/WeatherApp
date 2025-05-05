package com.aniketjain.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aniketjain.weatherapp.R;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> {

    private Context context;
    private List<String> daysList;

    public DaysAdapter(Context context, List<String> daysList) {
        this.context = context;
        this.daysList = daysList;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        String day = daysList.get(position);
        holder.dayText.setText(day);
    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder {
        TextView dayText;

        public DayViewHolder(View itemView) {
            super(itemView);
            dayText = itemView.findViewById(R.id.dayText);
        }
    }
}
