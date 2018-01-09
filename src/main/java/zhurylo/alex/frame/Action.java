package zhurylo.alex.frame;

import zhurylo.alex.serializator.Serializator;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Action extends JPanel
        implements ActionListener {
    JButton go;

    static JFileChooser chooser;
    String choosertitle;
    static String path = "";

    public Action() {
        go = new JButton("Do it");
        go.addActionListener(this);
        add(go);
    }

    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = String.valueOf(chooser.getSelectedFile());

            try {
               Serializator.test(create(path),null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            new Action();
        }
    }

    private static String create(String path) throws IOException {
        return path + "\\";
    }

}
