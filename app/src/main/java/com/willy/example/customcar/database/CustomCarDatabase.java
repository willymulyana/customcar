package com.willy.example.customcar.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.willy.example.customcar.classes.AutoPart;

import java.util.concurrent.Executors;

@Database(entities = {AutoPart.class}, version = 1, exportSchema = false)
public abstract class CustomCarDatabase extends RoomDatabase {

    private static CustomCarDatabase INSTANCE;

    public abstract DataDao dataDao();

    public synchronized static CustomCarDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }

        return INSTANCE;
    }

    private static CustomCarDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context, CustomCarDatabase.class, "customcar")
                .allowMainThreadQueries()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).dataDao().insertAll(AutoPart.populateData());
                            }
                        });
                    }
                })
                .build();
    }

}
