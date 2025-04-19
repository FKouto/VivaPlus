package com.viva.vivaplus;

import view.LoginForm;

public class Vivaplus {

    public static void main(String[] args) {
        // Executa no thread de UI (AWT/Swing)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
