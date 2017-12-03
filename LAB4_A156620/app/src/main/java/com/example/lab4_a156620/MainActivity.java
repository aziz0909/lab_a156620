package com.example.lab4_a156620;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ItemDetails> list_item_details = AssignItemData();
        lv_food = (ListView) findViewById(R.id.main_lv_food);

        lv_food.setAdapter(new ItemListBaseAdapter(getApplicationContext(), list_item_details));
        lv_food.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object o = lv_food.getItemAtPosition(position);
                ItemDetails object_itemDetails = (ItemDetails) o;

                Toast.makeText(MainActivity.this, "You have chosen : " + " " +
                                object_itemDetails.getItemDescription(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private ArrayList<ItemDetails> AssignItemData(){
        ArrayList<ItemDetails> list_of_data = new ArrayList<ItemDetails>();

        ItemDetails item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Beef Burger");
        item_details.setPrice("RM 20.00");
        item_details.setImageNumber(1);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Triple Beef Burger");
        item_details.setPrice("RM 35.00");
        item_details.setImageNumber(2);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Beef Burger");
        item_details.setPrice("RM 15.00");
        item_details.setImageNumber(3);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Chicken with Cheese Burger");
        item_details.setPrice("RM 20.00");
        item_details.setImageNumber(4);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Chicken Burger");
        item_details.setPrice("RM 12.00");
        item_details.setImageNumber(5);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Fish Burger");
        item_details.setPrice("RM 14.00");
        item_details.setImageNumber(6);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Pizza");
        item_details.setItemDescription("Spicy Chicken Pizza");
        item_details.setPrice("RM 26.00");
        item_details.setImageNumber(7);

        list_of_data.add(item_details);

        item_details = new ItemDetails();
        item_details.setName("Pizza");
        item_details.setItemDescription("Spicy Beef Pizza");
        item_details.setPrice("RM 26.00");
        item_details.setImageNumber(8);

        list_of_data.add(item_details);

        return list_of_data;
    }
}
