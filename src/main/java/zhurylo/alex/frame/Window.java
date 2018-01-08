package zhurylo.alex.frame;

import zhurylo.alex.usb.DetectedDrive;
import zhurylo.alex.weather.Weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class Window implements Serializable {
    private String space = "                       ";
    private String first;
    private String second;

    public Window() throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        String textAboutDriver = searchDriver();
        Weather weather = new Weather();
        float[] array = weather.test();

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.lightGray);

        if (textAboutDriver.contains("'")) {
            first = textAboutDriver.substring(0, textAboutDriver.indexOf("'"));
            second = textAboutDriver.substring(textAboutDriver.indexOf("'"), textAboutDriver.length());
        } else {
            first = textAboutDriver;
            second = null;
        }

        JLabel jLabelTextDriver = new JLabel(first);
        JLabel jLabelTextDriver2 = new JLabel(second);
        jPanel.add(jLabelTextDriver);
        jPanel.add(jLabelTextDriver2);

        JButton jbuttonBrowse = new JButton("Browse");
        jbuttonBrowse.setPreferredSize(new Dimension(80, 30));
        jbuttonBrowse.setBackground(Color.gray);
        if (textAboutDriver.contains("Browse")) {
            ActionListener actionListener = new Action();
            jbuttonBrowse.addActionListener(actionListener);
        }
        jPanel.add(jbuttonBrowse);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.LIGHT_GRAY);

        JLabel jLabelTemperature = new JLabel(space + "Temperature   =   " + array[0] + "  F");
        JLabel jLabelWind = new JLabel(space + "Wind   =   " + array[1] + "  wind speed");
        JLabel jLabelHumidity = new JLabel(space + "Humidity   =   " + array[2] + "  %");
        JLabel jLabelPressure = new JLabel(space + "Pressure   =   " + array[3] + "  mm.");

        GridLayout gridLayout = new GridLayout(4, 1);
        jPanel2.setLayout(gridLayout);
        jPanel2.setAlignmentX(50);
        jPanel2.setAlignmentY(50);
        jPanel2.add(jLabelTemperature);
        jPanel2.add(jLabelWind);
        jPanel2.add(jLabelHumidity);
        jPanel2.add(jLabelPressure);

        JPanel jPanel3 = new JPanel();
        GridLayout gridLayout1 = new GridLayout(2, 1);
        jPanel3.setLayout(gridLayout1);

        JFrame frame = new JFrame("Weather in Kiev");
        jPanel3.add(jPanel2);
        jPanel3.add(jPanel);
        frame.setContentPane(jPanel3);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(320, 270);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String searchDriver() {
        String textAboutDriver = DetectedDrive.USBDetect();
        if (textAboutDriver.equals("")) {
            textAboutDriver = "USB Drive not found.Please click 'Browse' to choose folder where data must be saved ";
        } else {
            textAboutDriver = "USB Drive found. The data was saved to " + textAboutDriver;
        }
        return textAboutDriver;
    }
}
