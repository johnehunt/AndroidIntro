package com.jjh.samplecontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class FriendsContentProvider extends ContentProvider 
                                       implements DatabaseConstants {

	public static final String AUTHORITY = 
		               "com.jjh.android.provider.FriendsContentProvider";
	public static final Uri CONTENT_URI = 
		               Uri.parse("content://" + AUTHORITY + "/friends");
	public static final String CONTENT_TYPE = 
		               "vnd.android.cursor.dir/vnd.com.jjh.android.provider.friends";

	private DatabaseHelper dbHelper;
	private static final UriMatcher sUriMatcher;
	private static final int FRIENDS = 1;

	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(AUTHORITY, TABLE_NAME, FRIENDS);
	}

	public boolean onCreate() {
		dbHelper = new DatabaseHelper(getContext());
		return true;
	}
	
	public int delete(Uri uri, String where, String[] whereArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int count;
		switch (sUriMatcher.match(uri)) {
		case FRIENDS:
			count = db.delete(TABLE_NAME, where, whereArgs);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	@Override
	public String getType(Uri uri) {
		switch (sUriMatcher.match(uri)) {
		case FRIENDS:
			return CONTENT_TYPE;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}

	public Uri insert(Uri uri, ContentValues initialValues) {
		if (sUriMatcher.match(uri) != FRIENDS) {
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		ContentValues values;
		if (initialValues != null) {
			values = new ContentValues(initialValues);
		} else {
			values = new ContentValues();
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long rowId = db.insert(TABLE_NAME, "name", values);
		if (rowId > 0) {
			Uri noteUri = ContentUris.withAppendedId(
					CONTENT_URI, rowId);
			getContext().getContentResolver().notifyChange(noteUri, null);
			return noteUri;
		}

		throw new SQLException("Failed to insert row into " + uri);
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		switch (sUriMatcher.match(uri)) {
		case FRIENDS:
			qb.setTables(TABLE_NAME);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor c = qb.query(db, projection, selection, selectionArgs, null,
				null, sortOrder);

		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where,
			String[] whereArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int count;
		switch (sUriMatcher.match(uri)) {
		case FRIENDS:
			count = db.update(TABLE_NAME, values, where, whereArgs);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
