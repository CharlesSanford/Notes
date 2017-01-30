package com.example.charles.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private RealmConfiguration realmConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realmConfiguration = new RealmConfiguration.Builder()
                .name("default")
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();

        realm = Realm.getInstance(realmConfiguration);

        RealmResults<Note> notes = realm.where(Note.class).findAllSorted("date", Sort.DESCENDING);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteEdit.class);
                startActivity(intent);
            }
        });

        ListView noteListView = (ListView) findViewById(R.id.note_listview);
        NoteAdapter noteAdapter = new NoteAdapter(this, notes);
        noteListView.setAdapter(noteAdapter);
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
        /*
        realm.deleteRealm(realmConfiguration);
        Log.d("realm destroyed", "onDestroy: ");
        */
}
}
