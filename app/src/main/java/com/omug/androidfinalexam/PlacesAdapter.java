package com.omug.androidfinalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlacesAdapter extends BaseAdapter {
    private List<Places> places;
    private LayoutInflater inflater;

    public PlacesAdapter(Context context, List<Places> places) {
        this.places = places;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.list_row,null);
            holder=new ViewHolder();
            holder.txtPOI=convertView.findViewById(R.id.txtPOI);
            holder.txtPrice=convertView.findViewById(R.id.txtPrice);
            holder.imgPOI=convertView.findViewById(R.id.imgPOI);
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        holder.txtPOI.setText(places.get(position).getPlace());
        holder.txtPrice.setText(String.valueOf(places.get(position).getAmount()));
        holder.imgPOI.setImageResource(places.get(position).getImagePlace());

        return convertView;
    }

    static class ViewHolder{
        //create attributes that match the components of list_row.xml
        private TextView txtPOI,txtPrice;
        private ImageView imgPOI;

    }
}