package nl.inholland.endassignment.util;

import java.awt.*;

public class SystemProperties {
    static final int textBoxWidth = 300;
    static final int textBoxHeight = 40;
    static final int buttonWidth = 100;
    static final int buttonHeight = 40;

    public SystemProperties(){}

    public static int[] getScreenSize(){
        int[] widthHeight = new int[2];
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        widthHeight[0] = screenSize.width;
        widthHeight[1] = screenSize.height;
        return widthHeight;
    }

    public static int[] getTextBoxSize() {
        int[] widthHeight = new int[2];
        widthHeight[0] = textBoxWidth;
        widthHeight[1] = textBoxHeight;
        return widthHeight;
    }

    public static int[] getButtonSize() {
        int[] widthHeight = new int[2];
        widthHeight[0] = buttonWidth;
        widthHeight[1] = buttonHeight;
        return widthHeight;
    }
}
