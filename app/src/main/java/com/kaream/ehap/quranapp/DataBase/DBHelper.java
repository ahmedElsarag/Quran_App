package com.kaream.ehap.quranapp.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kaream.ehap.quranapp.Model.FavoriteModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Favorite";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not EXISTS favoriates (" +
                "fav_serverName TEXT not null," +
                "fav_realName TEXT not null," +
                "fav_StateName TEXT not null," +
                "fav_ImgUrl TEXT not null," +
                "fav_imgDrawable INTEGER not null," +
                "fav_RecitesName TEXT not null," +
                "fav_RecitesAYA TEXT not null," +
                "fav_RealNameForReader TEXT not null)");
    }

    public Boolean addFavoriate(FavoriteModel favoriteModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fav_serverName", favoriteModel.serverName);
        values.put("fav_realName", favoriteModel.realName);
        values.put("fav_StateName", favoriteModel.StateName);
        values.put("fav_ImgUrl", favoriteModel.ImgUrl);
        values.put("fav_imgDrawable", favoriteModel.imgDrawable);
        values.put("fav_RecitesName", favoriteModel.RecitesName);
        values.put("fav_RecitesAYA", favoriteModel.RecitesAYA);
        values.put("fav_RealNameForReader", favoriteModel.RealNameForReader);
        try {
            db.insert("favoriates", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return true;
    }

    public ArrayList<FavoriteModel> getAllFavoriate() {

        ArrayList<FavoriteModel> favoriteModelList = new ArrayList<>();
        SQLiteDatabase mDb = this.getReadableDatabase();
        Cursor cursor = mDb.rawQuery("select * from favoriates", null);

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            FavoriteModel favoriteModel = new FavoriteModel();
            favoriteModel.serverName = cursor.getString(cursor.getColumnIndex("fav_serverName"));
            favoriteModel.realName = cursor.getString(cursor.getColumnIndex("fav_realName"));
            favoriteModel.StateName = cursor.getString(cursor.getColumnIndex("fav_StateName"));
            favoriteModel.ImgUrl = cursor.getString(cursor.getColumnIndex("fav_ImgUrl"));
            favoriteModel.imgDrawable = Integer.parseInt(cursor.getString(cursor.getColumnIndex("fav_imgDrawable")));
            favoriteModel.RecitesName = cursor.getString(cursor.getColumnIndex("fav_RecitesName"));
            favoriteModel.RecitesAYA = cursor.getString(cursor.getColumnIndex("fav_RecitesAYA"));
            favoriteModel.RealNameForReader = cursor.getString(cursor.getColumnIndex("fav_RealNameForReader"));
            favoriteModelList.add(favoriteModel);
            cursor.moveToNext();
        }
        cursor.close();
        mDb.close();
        return favoriteModelList;
    }

    public String getRecitesName(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_RecitesName from favoriates where fav_realName" + "= '" + realName + "'";

        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_RecitesName"));
            cursor.moveToNext();

        }
        cursor.close();
        return result;
    }

    public String getRecitesAya(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_RecitesAYA from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_RecitesAYA"));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public Integer getImgDrawable(String realName) {
        Integer result = 0;
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_imgDrawable from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = Integer.parseInt(cursor.getString(cursor.getColumnIndex("fav_imgDrawable")));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public String getReaderName(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_RealNameForReader from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_RealNameForReader"));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public String getServerName(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_serverName from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_serverName"));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }


    public String getStateName(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_StateName from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_StateName"));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public String getImgUrl(String realName) {
        String result = "";
        SQLiteDatabase mDb = this.getReadableDatabase();
        String selectQuery = "select fav_ImgUrl from favoriates where fav_realName" + "= '" + realName + "'";
        Cursor cursor = mDb.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            result = cursor.getString(cursor.getColumnIndex("fav_ImgUrl"));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public void delete(String realName) {
        SQLiteDatabase mDb = this.getWritableDatabase();
        mDb.delete("favoriates", "fav_realName" + "= '" + realName + "'", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE favoriate");
    }
}
