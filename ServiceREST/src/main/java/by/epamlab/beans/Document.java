package by.epamlab.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Document")
public class Document {

    private int id;

    private String name;

    private Chapters chapters;

    public Document() {
        super();
    }

    public Document(final int id, final String name, final Chapters chapters) {
        super();
        this.id = id;
        this.name = name;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Chapters getChapters() {
        return chapters;
    }

    public void setChapters(final Chapters chapter) {
        this.chapters = chapter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Document [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", chapter=");
        builder.append(chapters);
        builder.append("]");
        return builder.toString();
    }

}
