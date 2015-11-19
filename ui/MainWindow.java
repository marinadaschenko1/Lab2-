package com.nanlagger.ui;

import com.nanlagger.controllers.TCtrl;
import com.nanlagger.entities.Commands;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;






public class MainWindow extends JFrame {

    private JPanel mainPanel;

    private JTextField inTextField;
    private JTextField outTextField;

    private JSpinner inSpinner;
    private JSpinner outSpinner;

    private ArrayList<JButton> numButtons = new ArrayList<JButton>();

    /*Control Buttons*/
    private JButton clButton;
    private JButton bsButton;
    private JButton dotButton;
    private JButton pmButton;
    private JButton convertButton;

    /*Number Buttons*/
    private JButton aButton;
    private JButton a5Button;
    private JButton a0Button;
    private JButton bButton;
    private JButton cButton;
    private JButton eButton;
    private JButton fButton;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton dButton;

    private JMenuBar topMenu = new JMenuBar();

    private TCtrl control = TCtrl.getInstance();

    private ActionListener speedButtonClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int command = Integer.valueOf(actionEvent.getActionCommand());
            //System.out.println(actionEvent.getActionCommand()+" | "+command);
            doCommand(command);
        }
    };

    private KeyListener formKeyDown = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            int kCode = keyEvent.getKeyChar();

            System.out.println("KeyEvent " + keyEvent.getKeyCode() + " " + kCode);
            if(kCode >= KeyEvent.VK_0 && kCode <= KeyEvent.VK_9) {
                doCommand(kCode-KeyEvent.VK_0);
                return;
            }
            if(kCode >= 97 && kCode <= 102) {
                doCommand(kCode-97+10);
                return;
            }
            if(kCode == 43 || kCode == 45) {
                doCommand(Commands.CZ);
                return;
            }
            if(kCode == 46) {
                doCommand(Commands.DEL);
                return;
            }
            if(kCode == KeyEvent.VK_BACK_SPACE) {
                doCommand(Commands.BS);
                return;
            }
            if(kCode == KeyEvent.VK_ENTER) {
                doCommand(Commands.CONVERT);
                return;
            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

    private ChangeListener inPTrackBarChange = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if((Integer) inSpinner.getValue() <= 2) {
                inSpinner.setValue(2);
            }
            if((Integer) inSpinner.getValue() >= 16) {
                inSpinner.setValue(16);
            }
            control.setInP((Integer) inSpinner.getValue());
            updateKey();
        }
    };

    private ChangeListener outPTrackBarChange = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if((Integer) outSpinner.getValue() <= 2) {
                outSpinner.setValue(2);
            }
            if((Integer) outSpinner.getValue() >= 16) {
                outSpinner.setValue(16);
            }
            control.setOutP((Integer) outSpinner.getValue());
        }
    };

    private ActionListener exitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    };

    private ActionListener helpListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new HelpWindow();
        }
    };

    private ActionListener historyListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new History();
        }
    };

    private void initNumberButtons() {
        numButtons.add(a0Button);
        numButtons.add(a1Button);
        numButtons.add(a2Button);
        numButtons.add(a3Button);
        numButtons.add(a4Button);
        numButtons.add(a5Button);
        numButtons.add(a6Button);
        numButtons.add(a7Button);
        numButtons.add(a8Button);
        numButtons.add(a9Button);
        numButtons.add(aButton);
        numButtons.add(bButton);
        numButtons.add(cButton);
        numButtons.add(dButton);
        numButtons.add(eButton);
        numButtons.add(fButton);

        for (int i=0; i<numButtons.size(); i++) {
            numButtons.get(i).setActionCommand(String.valueOf(i));
            numButtons.get(i).setFocusable(false);
        }

        clButton.setActionCommand(String.valueOf(Commands.CL));
        bsButton.setActionCommand(String.valueOf(Commands.BS));
        dotButton.setActionCommand(String.valueOf(Commands.DEL));
        pmButton.setActionCommand(String.valueOf(Commands.CZ));
        convertButton.setActionCommand(String.valueOf(Commands.CONVERT));

        clButton.addActionListener(speedButtonClick);
        bsButton.addActionListener(speedButtonClick);
        dotButton.addActionListener(speedButtonClick);
        pmButton.addActionListener(speedButtonClick);
        convertButton.addActionListener(speedButtonClick);

        clButton.setFocusable(false);
        bsButton.setFocusable(false);
        dotButton.setFocusable(false);
        pmButton.setFocusable(false);
        convertButton.setFocusable(false);
    }

    public void initTopMenu() {
        setJMenuBar(topMenu);
        requestFocus();
        JMenu file = new JMenu("<html><u>Ф</u>айл</html>");
        JMenuItem exit = new JMenuItem("Выход");
        JMenuItem help = new JMenuItem("Справка");
        JMenuItem history = new JMenuItem("<html><u>И</u>стория</html>");
        topMenu.add(file);
        topMenu.add(history);
        file.add(help);
        file.addSeparator();
        file.add(exit);

        file.setMnemonic(KeyEvent.VK_A);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
        history.setMnemonic(KeyEvent.VK_B);

        exit.addActionListener(exitListener);
        help.addActionListener(helpListener);
        history.addActionListener(historyListener);
        addKeyListener(formKeyDown);
        inTextField.setText("0");
        outTextField.setText("0");
    }

    public MainWindow() {
        super();
        setTitle("Калькулейтэд!!!");
        setContentPane(mainPanel);
        setSize(240, 300);
        setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        initNumberButtons();
        updateKey();

        inSpinner.addChangeListener(inPTrackBarChange);
        inSpinner.setValue(2);
        outSpinner.addChangeListener(outPTrackBarChange);
        outSpinner.setValue(2);

        for (JButton button : numButtons) {
            button.addActionListener(speedButtonClick);
        }

        inTextField.setFocusable(false);
        outTextField.setFocusable(false);
        inSpinner.setRequestFocusEnabled(false);
        outSpinner.setRequestFocusEnabled(false);

        initTopMenu();
    }

    private void doCommand(int command) {
        try {
            if (command == Commands.CONVERT) {
                outTextField.setText(control.doCommand(command));
            } else {
                if(command == Commands.CL) {
                    outTextField.setText("0");
                }
                inTextField.setText(control.doCommand(command));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateKey() {
        int enabledKeys = (Integer) inSpinner.getValue();

        for (JButton button : numButtons) {
            button.setEnabled(false);
        }

        for (int i=0; i<enabledKeys; i++) {
            numButtons.get(i).setEnabled(true);
        }
    }

}
