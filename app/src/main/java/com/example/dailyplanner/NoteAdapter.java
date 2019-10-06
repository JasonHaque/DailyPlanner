package com.example.dailyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private TextView nameNote,ContentNote;
    private Context context;
    private ArrayList<NewNote> notes;

    public NoteAdapter(Context context, ArrayList<NewNote> planets) {
            this.context = context;
            this.notes = planets;
        }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        NewNote note = notes.get(position);
        holder.setDetails(note);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder{
        public NoteHolder(View itemView){
            super(itemView);
            nameNote=itemView.findViewById(R.id.recycler_note_name);
            ContentNote=itemView.findViewById(R.id.recycler_note_content);
        }

        public void setDetails(NewNote note) {

            nameNote.setText(note.getName());
            ContentNote.setText(note.getContent());

        }
    }
}
