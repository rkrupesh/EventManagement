package com.example.client;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FutureAdapter  extends ArrayAdapter<FutureModal> {
    public FutureAdapter(Context context) {
        super(context, R.layout.card_item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FutureModal model = getItem(position);

        holder.fdate.setText(model.getFdate());
        holder.ed_stime.setText(model.getEd_stime());
        holder.ed_etime.setText(model.getEd_etime());
        holder.tvSubtitle.setText(model.getSubtitleId());

        return convertView;
    }

    static class ViewHolder {
        TextView fdate;
        TextView ed_stime, ed_etime;
        TextView tvSubtitle;

        ViewHolder(View view) {
            fdate = (TextView) view.findViewById(R.id.fdate);
            ed_stime = (TextView) view.findViewById(R.id.ed_stime);
            ed_etime = (TextView) view.findViewById(R.id.ed_etime);
            tvSubtitle = (TextView) view.findViewById(R.id.text_subtitle);
        }
    }
}