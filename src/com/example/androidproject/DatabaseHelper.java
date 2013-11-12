package com.example.androidproject;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Project.db";

	// Table Names
	private static final String TABLE_PAIR = "pair";

	// Pair column names
	private static final String COL_PAIR_ID = "pair_id";
	private static final String COL_STRING_ID = "string_id";
	private static final String COL_IMAGE_ID = "image_id";

	// Pair table create string
	private static final String CREATE_TABLE_PAIR = "CREATE TABLE "
			+ TABLE_PAIR + "(" + COL_PAIR_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_STRING_ID
			+ " INTEGER, " + COL_IMAGE_ID + " INTEGER," + ");";

	// constructor
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_PAIR);
	}

	// Upgrading Tables
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAIR);

		// create new tables
		onCreate(db);
	}

	// CRUD operations
	// Create pair in DB
	void addPair(Pair pair) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COL_STRING_ID, pair.getStringId());
		values.put(COL_IMAGE_ID, pair.getImageId());

		db.insert(TABLE_PAIR, null, values);
		db.close();
	}

	// Read specific pair from DB
	Pair getPair(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		String[] result_columns = new String[] { COL_PAIR_ID, COL_STRING_ID,
				COL_IMAGE_ID };
		String where = COL_PAIR_ID + "=?";
		String[] whereArgs = { String.valueOf(id) };
		String groupBy = null;
		String having = null;
		String order = null;

		Cursor cursor = db.query(TABLE_PAIR, result_columns, where, whereArgs,
				groupBy, having, order);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		Pair pair = new Pair(cursor.getInt(0), cursor.getInt(1),
				cursor.getInt(2));
		db.close();
		return pair;
	}

	// Read all pairs from DB
	public ArrayList<Pair> getAllPairs() {
		ArrayList<Pair> pairList = new ArrayList<Pair>();

		String selectQuery = "SELECT * FROM " + TABLE_PAIR;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Pair pair = new Pair();
				pair.setId(cursor.getInt(0));
				pair.setStringId(cursor.getInt(1));
				pair.setImageId(cursor.getInt(2));

				// add pair to the list
				pairList.add(pair);
			} while (cursor.moveToNext());
		}

		return pairList;
	}
}
