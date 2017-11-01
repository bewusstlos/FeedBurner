package net.bewusstlos.feedburner.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by bewusstlos on 11/1/2017.
 * Just container for list of entries/posts/articles
 */
@Root(strict = false)
public class Feed {
    @ElementList(inline = true, required =  false)
    private List<Entry> entry;

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
