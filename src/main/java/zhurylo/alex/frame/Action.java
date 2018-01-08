package zhurylo.alex.frame;

import zhurylo.alex.serializator.Serializator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Action extends JPanel
        implements ActionListener {
    private JButton saveButton;
    private JTextArea log;
    private JFileChooser fc;

    public void actionPerformed(ActionEvent e) {
        int returnVal = fc.showSaveDialog(Action.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String s = String.valueOf(file);
            s = s.substring(0, s.lastIndexOf("\\") + 1);
            try {
                createImageIcon(s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }

    private static void createImageIcon(String path) throws IOException {
        Serializator.test(path);
    }

     Action() throws IOException {
        super(new BorderLayout());
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        fc = new JFileChooser();

        saveButton = new JButton("Save a File...");
        saveButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
}
