package nl.inholland.endassignment.exam;

import nl.inholland.endassignment.util.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WelcomeMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private long Id;
    private String title;
    private String content;

    public WelcomeMessage(long id, String title, String content) {
        Id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String [] args) {
        WelcomeMessage e = new WelcomeMessage(123, "Hello", "Lina");
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(Utils.getSerializedFile().getAbsolutePath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + Utils.getSerializedFile().getAbsolutePath());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
