package zhurylo.alex.frame;

import zhurylo.alex.filechoosers.FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        FileChooser.test();

    }
}
