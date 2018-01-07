package frame;

import weather.Weather;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.Serializable;

public class Window implements Serializable {

    public Window() throws IOException {
        Weather weather = new Weather();
        float[] array = weather.test();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(Color.lightGray);

        JLabel jLabel1 = new JLabel("Temperature   =   " + array[0] + "  F");
        JLabel jLabel2 = new JLabel("Wind   =   " + array[1] + "  wind speed");
        JLabel jLabel3 = new JLabel("Humidity   =   " + array[2] + "   %");
        JLabel jLabel4 = new JLabel("Pressure   =   " + array[3] + "   mm.");

        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);

        GridLayout gridLayout = new GridLayout(4, 1);
        jPanel.setLayout(gridLayout);

        JFrame frame = new JFrame("Weather in Kiev");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 300);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(jPanel);
    }
}
