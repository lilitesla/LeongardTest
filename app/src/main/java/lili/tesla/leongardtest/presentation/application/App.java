package lili.tesla.leongardtest.presentation.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

import lili.tesla.leongardtest.BuildConfig;
import lili.tesla.leongardtest.data.Question;
import lili.tesla.leongardtest.data.database.DataBaseAccess;

/**
 * Created by Лилия on 12.11.2017.
 */

public class App extends Application {

    private static App instance;
    public static DataBaseAccess dataBaseAccess;
    public static List<Question> questions;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        dataBaseAccess = new DataBaseAccess(this);
        questions = new ArrayList<>();

    }

    public static App getInstance() {
        return instance;
    }

    //процедура для просмотра базы с компа
    private void stethoInit() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }
}
