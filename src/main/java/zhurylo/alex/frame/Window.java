package zhurylo.alex.frame;

import zhurylo.alex.usb.DetectedDrive;
import zhurylo.alex.weather.Weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class Window implements Serializable {
    String textAboutDriver = "";

    {
        textAboutDriver = DetectedDrive.USBDetect();
        if (textAboutDriver == "") {
            textAboutDriver = "USB Drive not found.Please click 'Browse' to choose folder where data must be saved ";
        } else {
            textAboutDriver = "USB Drive found. The data was saved to " + textAboutDriver;
        }
    }

    public Window() throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Weather weather = new Weather();
        float[] array = weather.test();

        JPanel jPanel = new JPanel();

        JButton jbuttonBrowse = new JButton("Browse");
        jbuttonBrowse.setPreferredSize(new Dimension(100, 50));
        jPanel.setBackground(Color.lightGray);
        jPanel.add(jbuttonBrowse);
        if (textAboutDriver.contains("Browse")) {
            ActionListener actionListener = new Action();
            jbuttonBrowse.addActionListener(actionListener);
        }

        JLabel jLabelTextDriver = new JLabel(textAboutDriver);
        jPanel.add(jLabelTextDriver);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.lightGray);

        JLabel jLabelTemperature = new JLabel("Temperature   =   " + array[0] + "  F");
        JLabel jLabelWind = new JLabel("Wind   =   " + array[1] + "  wind speed");
        JLabel jLabelHumidity = new JLabel("Humidity   =   " + array[2] + "   %");
        JLabel jLabelPressure = new JLabel("Pressure   =   " + array[3] + "   mm.");
        jPanel2.add(jLabelTemperature);
        jPanel2.add(jLabelWind);
        jPanel2.add(jLabelHumidity);
        jPanel2.add(jLabelPressure);

        GridLayout gridLayout = new GridLayout(4, 1);
        jPanel2.setLayout(gridLayout);

        JFrame frame = new JFrame("Weather in Kiev");
        JPanel jPanel3 = new JPanel();
        GridLayout gridLayout1 = new GridLayout(2, 1);
        jPanel3.setLayout(gridLayout1);
        jPanel3.add(jPanel);
        jPanel3.add(jPanel2);
        frame.setContentPane(jPanel3);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
