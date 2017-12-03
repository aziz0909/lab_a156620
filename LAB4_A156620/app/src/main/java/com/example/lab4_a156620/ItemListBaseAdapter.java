package com.example.lab4_a156620;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aziza on 18/11/2017.
 */

public class ItemListBaseAdapter extends BaseAdapter {
    // for string thw ItemDetails data Later
    private static ArrayList<ItemDetails> itemDetailsArrayList;
    private Integer[] imgIdIntegers = { R.drawable.bb1, R.drawable.bb2, R.drawable.bb4, R.drawable.bb5,
    R.drawable.bb6, R.drawable.p1, R.drawable.p2};

    // for the itemListbaseadapter know where the ui come from
    private LayoutInflater l_Inflater;

    public ItemListBaseAdapter(Context context, ArrayList<ItemDetails> data) {
        itemDetailsArrayList = data;
        l_Inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return itemDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    // if haven't save the holder
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = l_Inflater.inflate(R.layout.row_view, null);
            holder = new ViewHolder();

            holder.tv_itemDescription = (TextView) convertView.findViewById(R.id.row_view_tv_disc);
            holder.tv_itemName = (TextView) convertView.findViewById(R.id.row_view_tv_food_name);
            holder.tv_itemPrice = (TextView) convertView.findViewById(R.id.row_view_tv_price);
            holder.img_ItemImage = (ImageView) convertView.findViewById(R.id.row_img_view);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_itemName.setText(itemDetailsArrayList.get(position).getName());
        holder.tv_itemDescription.setText(itemDetailsArrayList.get(position).getItemDescription());
        holder.tv_itemPrice.setText(itemDetailsArrayList.get(position).getPrice());
        holder.img_ItemImage.setImageResource(imgIdIntegers[itemDetailsArrayList.get(position)
                .getImageNumber()-1]);

        return convertView;
    }

    static class ViewHolder{
        TextView tv_itemName, tv_itemDescription, tv_itemPrice;
        ImageView img_ItemImage;
    }
}
