package lili.tesla.leongardtest.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import lili.tesla.leongardtest.data.Question;

/**
 * Created by Лилия on 12.11.2017.
 */

public class DataBaseAccess {

    private static DataBaseAccess instance;

    public static DataBaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseAccess(context);
        }
        return instance;
    }

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    public DataBaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
    }

    private void open() {
        this.database = openHelper.getWritableDatabase();
    }

    private void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<Question> getQuestions() {
        open();
        List<Question> questionsList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT id, question FROM Leongard_Test_Questions ORDER BY id", new String[0]);

        cursor.moveToFirst();
        Question question = new Question(cursor.getInt(0), cursor.getString(1));
        questionsList.add(question);

        while (cursor.moveToNext()) {
            question = new Question(cursor.getInt(0), cursor.getString(1));
            questionsList.add(question);
        }

        cursor.close();
        close();
        return questionsList;
    }




}