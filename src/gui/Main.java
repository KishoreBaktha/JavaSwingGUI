package gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //to run it in safe way
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}