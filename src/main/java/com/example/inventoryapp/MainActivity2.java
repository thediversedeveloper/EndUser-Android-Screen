package com.example.inventoryapp;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class MainActivity2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inventory.db";
    private static final int VERSION = 1;

    public MainActivity2(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

/*Parameters*/
    private static final class InventoryTable {
        private static final String TABLE = "inventory";
        private static final String COLUMN_ITEM = "item";
        private static final String COLUMN_STOCK = "stock";
        private static final String COLUMN_DATE = "data added";
    }

    /*Creating SQL Database and deleting if one exists*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + InventoryTable.TABLE + " (" +
                InventoryTable.COLUMN_STOCK + " integer primary key, " +
                InventoryTable.COLUMN_ITEM + " text, " +
                InventoryTable.COLUMN_DATE + " integer, " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + InventoryTable.TABLE);
        onCreate(db);

    }

    /*Create*/
    @Override
    public long addItem() {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryTable.COLUMN_STOCK, "2");
        values.put(InventoryTable.COLUMN_ITEM, "Books");
        values.put(InventoryTable.COLUMN_DATE, "06062023");

        long itemId = db.insert(InventoryTable.TABLE. null, values);
            return itemId;
    }


    /*Read*/
    public void getItemByDate(String rating) {
        SQLiteDatabase db = getWritableDatabase();

        String sql = "select * from " + InventoryTable.TABLE + " when was date added = ?";
        Cursor cursor = db.rawQuery(sql, new String[] { date });
        if (cursor.moveToFirst()) {
            do {
                long stock = cursor.getLong(0);
                String item = cursor.getString(1);
                String date = cursor.getString(2);
                Log.d(Item, "Inventory = " + ", " +  item + ", " + date + ", " + stock);
            } while (cursor.moveToNext());
    } cursor.close();
}

    /*Update*/
    public boolean updateItem(long item) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryTable.COLUMN_ITEM, item);

        int rowsUpdated = db.update(InventoryTable.TABLE, values, "item = ?",
                new String[] { Long.toString(item) });
        return rowsUpdated > 0;
    }

    /*Delete*/
    public boolean deleteItem(long item) {
        SQLiteDatabase db = getWritableDatabase();
        int rowsDeleted = db.delete(InventoryTable.TABLE, InventoryTable.COLUMN_ITEM + " = ?",
                new String[] { Long.toString(item) });
        return rowsDeleted > 0;
    }
}