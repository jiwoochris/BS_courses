package juicyjung.gachon.practice10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
        insert("유저1", 18, "홍길동");
        insert("유저2", 28, "홍길동2");
        insert("유저3", 28, "홍길동3");
        update("유저1", 58);
        delete("유저2");

        select();
    }

    public void insert(String name, int age, String address) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void update (String name, int age) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", age);
        db.update("student", values, "name=?", new String[]{name});
    }

    public void delete (String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("db1", name + "정상적으로 삭제 되었습니다.");
    }

    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);
        /* query (String table, String[] columns, String selection, String[]
         * selectionArgs, String groupBy, String having, String orderBy)
         */

        while (c.moveToNext()) {
            int _id = c.getInt(c.getColumnIndex("_id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));
            Log.i("db1", "id: " + _id + ", name : " + name + ", age : " + age
                    + ", address : " + address);
        }
    }
}


