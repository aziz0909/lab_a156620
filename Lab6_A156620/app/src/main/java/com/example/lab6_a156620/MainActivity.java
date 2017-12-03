package com.example.lab6_a156620;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.lab6_a156620.SuperMarketContract.CustomerEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btt_save, btt_load, btt_delete, btt_update;
    EditText et_cust_name, et_cust_city;
    ListView lv_cust_info;

    private String[] allColumns = {CustomerEntry._ID, CustomerEntry.COLUMN_NAME, CustomerEntry.COLUMN_CITY};
    ArrayList<String> customer_info;

    String cust_name, cust_city;

    SuperMarketDBHelper mSuperMarketDBHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btt_save = (Button) findViewById(R.id.main_btn_save);
        btt_load = (Button) findViewById(R.id.main_btn_load);
        btt_delete = (Button) findViewById(R.id.main_btn_delete);
        btt_update = (Button) findViewById(R.id.main_btn_update);

        et_cust_name = (EditText) findViewById(R.id.main_et_cust_name);
        et_cust_city = (EditText) findViewById(R.id.main_et_city);
        lv_cust_info = (ListView) findViewById(R.id.main_lv_cust_info);

        //To access your db, instantiate your subclass of
        // SQLiteOpenHelper;

        mSuperMarketDBHelper = new SuperMarketDBHelper(this);

        // Get the data repository in write mode
        db = mSuperMarketDBHelper.getWritableDatabase();

        btt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                cust_name = et_cust_name.getText().toString();
                cust_city = et_cust_city.getText().toString();

                ContentValues values = new ContentValues();
                values.put(CustomerEntry.COLUMN_NAME, cust_name);
                values.put(CustomerEntry.COLUMN_CITY, cust_city);

                // Create data insert values function
                insertData(db, values);

            }
        });

        btt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                customer_info = new ArrayList<String>();
                Cursor cursor = db.query(CustomerEntry.TABLE_NAME,
                        allColumns,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    customer_info.add(cursor.getString(0) + ": " +
                    cursor.getString(1) + " From: " + cursor.getString(2));
                    cursor.moveToNext();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getApplicationContext(), android.R.layout.simple_list_item_1, customer_info);

                lv_cust_info.setAdapter(adapter);
                cursor.close();

            }

        });

        btt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Define 'where' part of query
                String selection_delete_where = CustomerEntry.COLUMN_NAME + " LIKE ?";

                // Specify arguments in placeholder order
                String[] selectionArgs_delete_where = new String[] {
                        et_cust_name.getText().toString()};

                db.delete(CustomerEntry.TABLE_NAME, selection_delete_where,
                        selectionArgs_delete_where);

                Message.message(getApplicationContext(), "Record Deleted!");

            }
        });

        btt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ContentValues values = new ContentValues();
                values.put(CustomerEntry.COLUMN_CITY, et_cust_city.getText().toString());
                String selectionUpdate = CustomerEntry.COLUMN_NAME + " LIKE ?";
                String[] selectionArgs_update = new String[] {
                        et_cust_name.getText().toString()
                };

                int count = db.update(CustomerEntry.TABLE_NAME, values, selectionUpdate,
                        selectionArgs_update);

                Message.message(getApplicationContext(), count + ": Record Updated!");
            }
        });

    }

    private void insertData(SQLiteDatabase db, ContentValues values) {
        long newRowId;
        newRowId = db.insert(CustomerEntry.TABLE_NAME, null, values);

        // If data is inserted then toast a message
        if (newRowId != -1) {
            Message.message(this, "New Data Inserted!");
        }

    }
}
