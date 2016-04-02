/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.main;

import javax.swing.JScrollPane;

/**
 *
 * @author Electronics
 */
public class ImageScroll extends JScrollPane {

    private int defaultWidth = 640;
    private int defaultHeight = 480;

    public void setScrollSize(int width, int height) {
        int w, h;
        if (width > defaultWidth) {
            w = defaultWidth;
        } else {
            w = width;
        }

        if (height > defaultHeight) {
            h = defaultHeight;
        } else {
            h = height;
        }
        setSize(w, h);
    }

    public void setDefaultWidth(int width) {
        defaultWidth = width;
    }

    public void setDefaultHeight(int height) {
        defaultHeight = height;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }
}
