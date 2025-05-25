package org.vivaplus;

import org.vivaplus.view.LoginScreen;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }
}