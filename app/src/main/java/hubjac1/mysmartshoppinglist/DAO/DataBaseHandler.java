package hubjac1.mysmartshoppinglist.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String CADDY_KEY = "id";
    public static final String CADDY_PRODUCT = "product";
    public static final String CADDY_STATUS = "status";

    public static final String CADDY_TABLE_NAME = "Caddy";
    public static final String CADDY_TABLE_CREATE =
            "CREATE TABLE " + CADDY_TABLE_NAME + " (" +
                    CADDY_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CADDY_PRODUCT + " INTEGER, " +
                    CADDY_STATUS + " INTEGER);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CADDY_TABLE_CREATE);
    }

    public static final String CADDY_TABLE_DROP = "DROP TABLE IF EXISTS " + CADDY_TABLE_NAME + ";";
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CADDY_TABLE_DROP);
        onCreate(db);
    }
}
*/