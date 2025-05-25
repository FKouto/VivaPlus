package org.vivaplus.view;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;

public class BackgroundLoad extends JLabel {
    private FlatSVGIcon icon;

    public void setBackgroundPanel(String image, int width, int height) {
        icon = new FlatSVGIcon(image, width, height);
        setIcon(icon);
    }
}
