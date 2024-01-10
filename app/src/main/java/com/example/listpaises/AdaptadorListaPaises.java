package com.example.listpaises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorListaPaises extends ArrayAdapter<Nombress> {
    public AdaptadorListaPaises(Context context, ArrayList<Nombress> datos) {
        super(context, R.layout.litems, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.litems, null);

        TextView lblnombre = (TextView) item.findViewById(R.id.lblnombre);
        lblnombre.setText(getItem(position).getNombre());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgLogo);
        Glide.with(this.getContext()).load(getItem(position).getUrlLogo())
                .into(imageView);
        return (item);
    }
}