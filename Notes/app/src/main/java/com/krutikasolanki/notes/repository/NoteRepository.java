package com.krutikasolanki.notes.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.krutikasolanki.notes.repository.room.Note;
import com.krutikasolanki.notes.repository.room.NoteDAO;
import com.krutikasolanki.notes.repository.room.NoteDatabase;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDAO = noteDatabase.noteDAO();
        allNotes = noteDAO.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void insert(Note note) {
        InsertNoteAsyncTask insertNoteAsyncTask = new InsertNoteAsyncTask(noteDAO);
        insertNoteAsyncTask.execute(note);
    }

    public void update(Note note) {
        UpdateNoteAsyncTask updateNoteAsyncTask = new UpdateNoteAsyncTask(noteDAO);
        updateNoteAsyncTask.execute(note);
    }

    public void delete(Note note) {
        DeleteNoteAsyncTask deleteNoteAsyncTask = new DeleteNoteAsyncTask(noteDAO);
        deleteNoteAsyncTask.execute(note);
    }

    public void deleteAll() {
        DeleteAllNoteAsyncTask deleteAllNoteAsyncTask = new DeleteAllNoteAsyncTask(noteDAO);
        deleteAllNoteAsyncTask.execute();
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public InsertNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.addNote(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public UpdateNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.updateNote(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDAO noteDAO;

        public DeleteNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.deleteNote(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDAO noteDAO;

        public DeleteAllNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAll();
            return null;
        }
    }
}
