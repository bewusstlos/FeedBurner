package net.bewusstlos.feedburner.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.bewusstlos.feedburner.R;
import net.bewusstlos.feedburner.models.Entry;

import java.util.ArrayList;

/**
 * Created by bewusstlos on 11/1/2017.
 */

public class FeedAdapter extends BaseAdapter {

    ArrayList<Entry> entries;
    Context context;
    LayoutInflater lInflater;

    public FeedAdapter(Context context, ArrayList<Entry> entries) {
        this.context = context;
        this.entries = entries;
        lInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int i) {
        return entries.get(i);
    }

    public Entry getEntry(int i){
        return ((Entry) getItem(i));
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View entryView = view;
        if (entryView == null) {
            entryView = lInflater.inflate(R.layout.entry_item, viewGroup, false);
        }
        ((TextView)entryView.findViewById(R.id.title)).setText(getEntry(i).getTitle());
        return entryView;
    }
}
