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

    }
}
