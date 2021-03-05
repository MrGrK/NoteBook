package com.example.notebook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notebook.Note;
import com.example.notebook.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private static final String TAG = "NotesAdapter";

    private final List<Note> notes = new ArrayList<>();

    private final NotesAdapterCallback callback;

    public void setItems(List<Note> items) {
        notes.clear();
        notes.addAll(items);
        notifyDataSetChanged();
    }

    public NotesAdapter(NotesAdapterCallback callback)
    {
        this.callback = callback;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //на этом месте вылетала ошибка из-за стиля приложения (требует Theme.MaterialComponents.DayNight)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.onBind(notes.get(position), position);
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView tview;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            tview = itemView.findViewById(R.id.tv_note_title);
        }

        public void onBind(Note model, int position) {

            tview.setText(model.getfTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=RecyclerView.NO_POSITION)
                        callback.onOnItemClick(model);
                }
            });
        }
    }
}
