package com.jjh.samplecontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "friends";

	DatabaseHelper(Context context) {
		super(context, "friendsDB", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table friends ("
				+ " _id integer PRIMARY KEY autoincrement, " 
		        + " name  text, " 
		        + " age integer );  ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}
}
