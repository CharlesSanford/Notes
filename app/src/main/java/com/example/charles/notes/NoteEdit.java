package com.example.charles.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Charles on 1/29/2017.
 */

public class NoteEdit extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);

        final EditText title = (EditText) findViewById(R.id.title);
        final EditText content = (EditText) findViewById(R.id.edit_content);
        Button submit = (Button) findViewById(R.id.submit);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("default")
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        final Realm realm = Realm.getInstance(realmConfiguration);
        final Intent intent = new Intent(NoteEdit.this, MainActivity.class);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Note newNote = realm.createObject(Note.class);
                        newNote.setTitle(title.getText().toString());
                        Log.d("newNoteTitle", "" +title.getText().toString());
                        newNote.setContent(content.getText().toString());
                        newNote.setDate(new Date());
                    }
                });
                startActivity(intent);
             }
        });
    }
}


