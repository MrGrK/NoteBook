package com.example.notebook;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DescNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        if (savedInstanceState == null) {
            Bundle arguments = getIntent().getExtras();
            if(arguments!=null){
                    Note xNote = arguments.getParcelable(NoteDescriptionFragment.class.getSimpleName());
                    // Intent xIntent = new Intent();
                    // Note xNote = (Note) xIntent.getParcelableExtra(NoteDescriptionFragment.class.getSimpleName());
                    NoteDescriptionFragment xDescFrag = NoteDescriptionFragment.newInstance(xNote);
                    FragmentManager xFrManager = getSupportFragmentManager();
                    FragmentTransaction xFragTransaction = xFrManager.beginTransaction();
                    xFragTransaction.replace(R.id.frame_desc_container, xDescFrag);
                    xFragTransaction.commit();
                }
            }
    }
}
