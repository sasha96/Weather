package zhurylo.alex.filechoosers;

import zhurylo.alex.serializator.Serializator;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class FileChooser extends JPanel
        implements ActionListener {

    static private final String newline = "\n";
    JButton saveButton;
    JTextArea log;
    JFileChooser fc;

    public FileChooser() throws IOException {
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String s = String.valueOf(file);
                s = s.substring(0, s.lastIndexOf("\\") + 1);
                try {
                    createImageIcon(s);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                log.append("Saving: " + "zhurylo.alex.weather.properties" + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }


    protected static Icon createImageIcon(String path) throws IOException {
        Serializator.test(path);
        return null;
    }

    private static void createAndShowGUI() throws IOException {
        JFrame frame = new JFrame("FileChooser");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FileChooser());
        frame.pack();
        frame.setVisible(true);
    }

    public static void test() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                try {
                    createAndShowGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}