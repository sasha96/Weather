package zhurylo.alex.frame;

import zhurylo.alex.usb.DetectedDrive;
import zhurylo.alex.weather.Weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class Window implements Serializable, ActionListener {
    private String space = "                      ";
    static private String first;
    static private String second;
    static JButton j = new JButton("Browse");
    static String textAboutDriver = searchDriver(j);

    private String method() {
        if (textAboutDriver.contains("'")) {
            first = textAboutDriver.substring(0, textAboutDriver.lastIndexOf("'") + 1);
            second = textAboutDriver.substring(textAboutDriver.lastIndexOf("'") + 1, textAboutDriver.length());
        } else {
            first = textAboutDriver;
            second = null;
        }
        return textAboutDriver;
    }

    public Window() throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame.setDefaultLookAndFeelDecorated(true);
        Weather weather = new Weather();
        float[] array = weather.test();

        JPanel jPanel = new JPanel();


        textAboutDriver = method();


        j.setPreferredSize(new Dimension(80, 30));
        j.setBackground(Color.gray);
        jPanel.add(j);

        JLabel jLabelTextDriver;
        jLabelTextDriver = new JLabel(first);
        JLabel jLabelTextDriver2 = new JLabel(second);

        jPanel.add(jLabelTextDriver);
        jPanel.add(jLabelTextDriver2);

        JPanel jPanel2 = new JPanel();
        GridLayout g = new GridLayout(4, 2);
        jPanel2.setLayout(g);

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

    private static String searchDriver(JButton jbuttonBrowse) {
        String textAboutDriver = DetectedDrive.USBDetect();
        if (textAboutDriver.equals("")) {
            textAboutDriver = "USB Drive not found.Please click 'Browse' to choose folder where data must be saved ";
            actionListner(jbuttonBrowse);
        } else {
            textAboutDriver = "USB Drive found. The data was saved to " + textAboutDriver;
        }

        return textAboutDriver;
    }

    private static String actionListner(JButton jbuttonBrowse) {

        ActionListener actionListener = new Action();
        jbuttonBrowse.addActionListener(actionListener);
        textAboutDriver = "sdafs";
        return textAboutDriver;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
