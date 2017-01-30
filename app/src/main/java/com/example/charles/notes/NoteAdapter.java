package com.example.charles.notes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Charles on 1/30/2017.
 */

public class NoteAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private List mNotes;

    public NoteAdapter(Context context, List<Note> notes) {
        mContext = context;
        mNotes = notes;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        if (mNotes == null) {
            return 0;
        }
        Log.d("listCount", "" + mNotes.size());
        return mNotes.size();
    }

    @Override
    public Object getItem(int position) {
        if (mNotes == null || mNotes.get(position) == null) {
            return null;
        }
        return mNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_item_note, parent, false);
        TextView title = (TextView) rowView.findViewById(com.example.charles.notes.R.id.title);
        TextView content = (TextView) rowView.findViewById(com.example.charles.notes.R.id.content);
        Note note = (Note)mNotes.get(position);


        Log.d("titleText:", ""+note.getTitle());
        title.setText(note.getTitle().toString());
        content.setText(note.getContent().toString());


        return rowView;
    }
}
