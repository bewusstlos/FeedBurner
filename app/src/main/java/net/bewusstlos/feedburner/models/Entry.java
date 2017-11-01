package net.bewusstlos.feedburner.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by bewusstlos on 11/1/2017.
 */
@Root(strict = false, name = "entry")
public class Entry
{
    @Path("title")
    @Text(required=false)
    private String title;

    @Path("feedburner:origLink")
    @Text(required = false)
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}


