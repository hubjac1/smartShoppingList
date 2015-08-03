package hubjac1.mysmartshoppinglist.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAOBase {

    protected final static int VERSION = 1;

    // Database file name
    protected final static String NOM = "smartShoppingList.db";

    protected SQLiteDatabase mDb = null;

    protected DatabaseHandler mHandler = null;

    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() {
        // No need to close the previous database because getWritableDatabase take care
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}