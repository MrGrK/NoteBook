package com.example.notebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesFragment extends Fragment {

    private List<Note> fNotes = new ArrayList<Note>();
    private boolean fIsLandscapeOrientation;
    private final String SAVE_STATE_KEY = "save_state_key";
    private int stateValue = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNoteArray();
    }

    private void initNoteArray() {
        fNotes.add(new Note("Математика", "Задача 12, 13б, 14", "01.02.2021"));
        fNotes.add(new Note("Русский", "Упражнение 122, 123a, 124", "01.02.2021"));
        fNotes.add(new Note("Английский", "Стр 30 Текст 2, упр.2а, 2б", "01.02.2021"));
        fNotes.add(new Note("Физика", "Параграф  44, 13б, 14", "01.02.2021"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            return inflater.inflate(R.layout.fragment_notes, container, false);
        } catch (Exception e) {
            Toast toast = Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
            return inflater.inflate(R.layout.fragment_notes, container, false);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fIsLandscapeOrientation = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        try {
            if (savedInstanceState == null) {
                initArrayTV(view);
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void initArrayTV(View pView) {
        LinearLayout xLayout = (LinearLayout) pView;
        int xPadding = getResources().getDimensionPixelSize(R.dimen.note_margin);
        for (int i = 0; i < fNotes.size(); i++) {
            String xNoteTitle = fNotes.get(i).getfTitle();
            TextView tv = new TextView(xLayout.getContext());
            tv.setText(xNoteTitle);
            tv.setPadding(xPadding, xPadding, xPadding, xPadding);
            Note xCurrNote = fNotes.get(i);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNoteDescFrag(xCurrNote);
                }
            });
            tv.setTextSize(30);
            xLayout.addView(tv);
        }
    }

    private void openNoteDescFrag(Note pCurrNote) {
        try {
            NoteDescriptionFragment xFrag = NoteDescriptionFragment.newInstance(pCurrNote);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, xFrag)
                    .commit();
        } catch (Exception e) {
            Toast toast = Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_STATE_KEY, stateValue);
        super.onSaveInstanceState(outState);
    }


}