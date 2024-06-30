package com.krutikasolanki.notes.repository.room;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.CalendarContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static final String DB_NAME = "note_database";
    private static NoteDatabase instance;

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, NoteDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    public abstract NoteDAO noteDAO();

    private static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            PopulateAsyncTask populateAsyncTask = new PopulateAsyncTask(instance);
            populateAsyncTask.execute();
        }
    };
    private static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDAO noteDao;

        public PopulateAsyncTask(NoteDatabase instance) {
            // onCreate() will be called after the database is created
            // therefore we can use NoteDatabase instance
            noteDao = instance.noteDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.addNote(new Note("Title1","Description1",1));
            noteDao.addNote(new Note("Title2","Descriptionre2",2));
            noteDao.addNote(new Note("Title3","Description3",3));
            return null;
        }
    }
}
