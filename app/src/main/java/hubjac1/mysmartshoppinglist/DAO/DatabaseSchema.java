package hubjac1.mysmartshoppinglist.DAO;

/**
 * Class to describe data base schema
 */
public class DatabaseSchema {
    static public class Caddy {
        public static final String KEY = "id";
        public static final String PRODUCT = "product";
        public static final String STATUS = "status";

        public static final String TABLE_NAME = "Caddy";
        public static final String TABLE_CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PRODUCT + " INTEGER, " +
                        STATUS + " INTEGER);";

        public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }

}
