package com.example.baitap1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="hoadon";
    private static final String TABLE_NAME ="HOADON";
    private static final String ID ="ID";
    private static final String NAME ="NAME";
    private static final String SOPHONG ="SOPHONG";
    private static final String DONGIA ="DONGIA";
    private static final String NGAY ="NGAY";


    private Context context;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key  , "+
                NAME + " TEXT, "+
                SOPHONG + " integer, "+
                NGAY + " integer, "+
                DONGIA +" float)";

        String sqlQuery1 = "INSERT INTO " + TABLE_NAME + " VALUES ( 1, 'Vũ Trường An', 405,  3, 49000)";
        String sqlQuery2 = "INSERT INTO " + TABLE_NAME + " VALUES ( 2, 'Lê Hải Hà', 401,  3, 700000)";
        String sqlQuery3 = "INSERT INTO " + TABLE_NAME + " VALUES ( 3, 'Lê Huỳnh Đức', 915,  3, 66000)";
        String sqlQuery4 = "INSERT INTO " + TABLE_NAME + " VALUES ( 4, 'Lê Văn Đạt', 111,  6, 49000)";
        String sqlQuery5 = "INSERT INTO " + TABLE_NAME + " VALUES ( 5, 'Hà Thị Thu', 222,  4, 49000)";

        db.execSQL(sqlQuery);
        db.execSQL(sqlQuery1);
        db.execSQL(sqlQuery2);
        db.execSQL(sqlQuery3);
        db.execSQL(sqlQuery4);
        db.execSQL(sqlQuery5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addHoaDon(HoaDon hoadon){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, hoadon.getName());
        values.put(SOPHONG, hoadon.getSophong());
        values.put(DONGIA, hoadon.getDongia());
        values.put(NGAY, hoadon.getNgay());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void QueryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }


    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<HoaDon>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME  ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HoaDon hoadon = new HoaDon();
                hoadon.setId(cursor.getInt(0));
                hoadon.setName(cursor.getString(1));
                hoadon.setSophong(cursor.getInt(2));
                hoadon.setNgay(cursor.getInt(3));
                hoadon.setDongia(cursor.getFloat(4));
                list.add(hoadon);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public void updateHoaDon(int id, String name, int sophong, int ngay, float dongia) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME +
                " SET " + NAME + " = '" + name + "'" +
                " , " + SOPHONG + " = '" + sophong + "'" +
                " , " + NGAY + " = " + ngay +
                " , " + DONGIA + " = " + dongia +
                " WHERE " + ID + " = " + id;
        db.execSQL(sql);
    }
}
