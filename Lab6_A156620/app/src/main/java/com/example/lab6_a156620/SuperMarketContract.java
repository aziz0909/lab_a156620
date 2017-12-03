package com.example.lab6_a156620;

import android.provider.BaseColumns;

/**
 * Created by User on 23/11/2017.
 */

public class SuperMarketContract {
    // To prevent someone from accidentially instantiating the contract class
    // Give it an empty constructor
    public SuperMarketContract() {
    }

    /* Inner class that defines the table contents */
    public static final class CustomerEntry implements BaseColumns {
        public static final String TABLE_NAME = "customer";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_IC = "ic";
    }
}
