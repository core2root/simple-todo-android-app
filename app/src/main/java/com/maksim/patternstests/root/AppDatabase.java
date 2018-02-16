package com.maksim.patternstests.root;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.maksim.patternstests.data.model.Task;
import com.maksim.patternstests.data.model.TaskDao;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    protected AppDatabase(){}
    private static AppDatabase instance;

    public abstract TaskDao taskDao();

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"task-database").
                    allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
