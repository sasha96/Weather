package zhurylo.alex.frame;

import zhurylo.alex.usb.DetectedDrive;
import zhurylo.alex.weather.Weather;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class Window implements Serializable {
    private String space = "                      ";
    static private String firstField;
    static private String secondField;
    static JButton jButton = new JButton("Browse");
    static String textAboutDriver = searchDriver(jButton);

    private String method() {
        if (textAboutDriver.contains("'")) {
            firstField = textAboutDriver.substring(0, textAboutDriver.lastIndexOf("'") + 1);
            secondField = textAboutDriver.substring(textAboutDriver.lastIndexOf("'") + 1, textAboutDriver.length());
        } else {
            firstField = textAboutDriver;
            secondField = null;
        }
        return textAboutDriver;
    }

    public Window()  {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        Weather weather = new Weather();
        float[] array = new float[0];
        try {
            array = weather.test();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel jPanel = new JPanel();

        textAboutDriver = method();

        jButton.setPreferredSize(new DimensionUIResource(80, 30));
        jButton.setBackground(Color.gray);
        jPanel.add(jButton);

        JLabel jLabelTextDriver;
        jLabelTextDriver = new JLabel(firstField);
        JLabel jLabelTextDriver2 = new JLabel(secondField);

        jPanel.add(jLabelTextDriver);
        jPanel.add(jLabelTextDriver2);

        JPanel jPanel2 = new JPanel();
        GridLayout gridLayout = new GridLayout(4, 2);
        jPanel2.setLayout(gridLayout);

        JLabel jLabelTemperature = new JLabel(space + "Temperature :");
        JLabel jLabelWind = new JLabel(space + "Wind :");
        JLabel jLabelHumidity = new JLabel(space + "Humidity :");
        JLabel jLabelPressure = new JLabel(space + "Pressure :");

        JLabel Temperature = new JLabel(array[0] + " F");
        JLabel Wind = new JLabel(array[1] + " wind speed");
        JLabel Humidity = new JLabel(array[2] + " %");
        JLabel Pressure = new JLabel(array[3] + " mm.");

        jPanel2.add(jLabelTemperature);
        jPanel2.add(Temperature);
        jPanel2.add(jLabelWind);
        jPanel2.add(Wind);
        jPanel2.add(jLabelHumidity);
        jPanel2.add(Humidity);
        jPanel2.add(jLabelPressure);
        jPanel2.add(Pressure);


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
        frame.setSize(290, 270);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String searchDriver(JButton jButton) {
        String textAboutDriver = DetectedDrive.USBDetect();
        if (textAboutDriver.equals("")) {
            textAboutDriver = "USB Drive not found.Please click 'Browse' to choose folder where data must be saved ";
            actionListner(jButton);
        } else {
            textAboutDriver = "USB Drive found. The data was saved to " + textAboutDriver;
        }
        return textAboutDriver;
    }

    private static void actionListner(JButton jbuttonBrowse) {
        ActionListener actionListener = new Action();
        jbuttonBrowse.addActionListener(actionListener);

    }
}
