package com.letz.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FlagsDAO
{
    // 임의의 10개 질문 get → arraylist에 저장
    public ArrayList<FlagsModel> getRandomTenQuestion(FlagsDatabase fd) {
        ArrayList<FlagsModel> modelArrayList = new ArrayList<>();
        SQLiteDatabase liteDatabase = fd.getWritableDatabase();
        Cursor cursor = liteDatabase.rawQuery("SELECT * FROM flagquizgametable ORDER BY RANDOM() LIMIT 10", null);
        //now you can read data line by line thanks to the Cursor object.

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagNameIndex = cursor.getColumnIndex("flag_name");
        int flagImageIndex = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext())
        {
            FlagsModel model = new FlagsModel(
                    cursor.getInt(flagIdIndex)
                    , cursor.getString(flagNameIndex)
                    , cursor.getString(flagImageIndex)
            );

            modelArrayList.add(model);
        }

        return modelArrayList;
    }

    public ArrayList<FlagsModel> getRandomThreeOptions(FlagsDatabase fd, int flag_id) {
        ArrayList<FlagsModel> modelArrayList = new ArrayList<>();
        SQLiteDatabase liteDatabase = fd.getWritableDatabase();
        Cursor cursor = liteDatabase.rawQuery("SELECT * FROM flagquizgametable WHERE flag_id !="+flag_id+" ORDER BY RANDOM() LIMIT 3", null);
        //now you can read data line by line thanks to the Cursor object.

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagNameIndex = cursor.getColumnIndex("flag_name");
        int flagImageIndex = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext())
        {
            FlagsModel model = new FlagsModel(
                    cursor.getInt(flagIdIndex)
                    , cursor.getString(flagNameIndex)
                    , cursor.getString(flagImageIndex)
            );

            modelArrayList.add(model);
        }

        return modelArrayList;
    }

}
