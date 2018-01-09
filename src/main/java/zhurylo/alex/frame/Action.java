package zhurylo.alex.frame;

import zhurylo.alex.serializator.Serializator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
The Action class is created to
implement the "Browse" button.
*/
public class Action extends JPanel
        implements ActionListener {
    JButton go;

    static JFileChooser chooser;
    String choosertitle;
    static String path = "";

    public Action() {
        go = new JButton("Browse");
        go.addActionListener(this);
        add(go);
    }

    /*
    This method actionPerformed determines the exact
     directory that the user selected and sends it
     for serialization in the method
     */
    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = String.valueOf(chooser.getSelectedFile());
            try {
                Serializator.serializationFiles(path + "\\", null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            new Action();
        }
    }
}
