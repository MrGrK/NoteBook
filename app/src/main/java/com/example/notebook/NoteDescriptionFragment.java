package com.example.notebook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NoteDescriptionFragment extends Fragment {

    public static final String ARG_INDEX = new String( "arg_index");
    private TextView fTV_Title;
    private TextView fTV_Description;
    private TextView fTV_Date;


    public static NoteDescriptionFragment newInstance(Note pNote)
    {
        NoteDescriptionFragment xNoteDescFrag = new NoteDescriptionFragment();
        Bundle xBundle= new Bundle();
        xBundle.putParcelable(ARG_INDEX, pNote);
        xNoteDescFrag.setArguments(xBundle);
        return xNoteDescFrag;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_desription, container, false);
    }

    @ Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fTV_Date = view.findViewById(R.id.tv_date);
        fTV_Description = view.findViewById(R.id.tv_desc);
        fTV_Title = view.findViewById(R.id.tv_Title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments()!=null) {
            Note xNote = (Note)getArguments().getParcelable(ARG_INDEX);
            if(xNote!=null) {
                fTV_Title.setText(xNote.getfTitle());
                fTV_Description.setText(xNote.getfText());
                fTV_Date.setText(xNote.getfDate());
            }
        }
    }
}