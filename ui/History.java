package com.nanlagger.ui;

import com.nanlagger.controllers.TCtrl;
import com.nanlagger.entities.Commands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History extends JFrame {
    private JTextArea textArea1;
    private JButton closeButton;
    private JButton clearButton;
    private JPanel mainPanel;

    private TCtrl control = TCtrl.getInstance();

    public History() {
        super();
        setTitle("История");
        setContentPane(mainPanel);
        setSize(240, 270);
        setVisible(true);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        textArea1.setText(control.doCommand(Commands.GET_HISTORY));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(control.doCommand(Commands.CLEAR_HISTORY));
            }
        });
    }
}
