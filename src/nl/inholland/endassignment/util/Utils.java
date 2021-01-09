package nl.inholland.endassignment.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Utils {
    public Utils(){}

    public static File getSerializedFile(){
        URL url = Utils.class.getClassLoader().getResource("nl/inholland/endassignment/resources/messages.dat");
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }finally {
            return file;
        }
    }
}
