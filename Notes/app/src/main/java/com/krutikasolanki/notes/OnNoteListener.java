package com.krutikasolanki.notes;

import com.krutikasolanki.notes.repository.room.Note;

public interface OnNoteListener {
    void onNoteAdd(Note note);
    void onNoteUpdate(Note note);
    void onNoteDelete(Note note);
}
