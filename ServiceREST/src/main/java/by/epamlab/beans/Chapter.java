package by.epamlab.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Chapter")
public class Chapter {

    private int id;

    private int chapterNumber;

    private int numberOfPage;

    public Chapter() {
        super();
    }

    public Chapter(final int id, final int chapterNumber, final int numberOfPage) {
        super();
        this.id = id;
        this.chapterNumber = chapterNumber;
        this.numberOfPage = numberOfPage;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(final int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(final int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Chapter [id=");
        builder.append(id);
        builder.append(", chapterNumber=");
        builder.append(chapterNumber);
        builder.append(", numberOfPage=");
        builder.append(numberOfPage);
        builder.append("]");
        return builder.toString();
    }

}
