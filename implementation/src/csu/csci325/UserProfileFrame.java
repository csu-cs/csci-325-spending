package csu.csci325;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by N'dia on 11/12/2015.
 */
public class UserProfileFrame extends JFrame{

    private JLabel title;

    private JLabel selectUserLabel;
    //private JComboBox userBox;

    public static String[] userArray;

    private JRadioButton user0;
    private JRadioButton user1;
    private JRadioButton user2;
    private JButton submit1;

    private JLabel newUserLabel;
    private JTextField newUser;
    private JButton submit2;

    private JLabel warningLabel = new JLabel();
    private JLabel updateLabel = new JLabel();
    private JLabel infoLabel = new JLabel();

    //public String userAddTo = "";

    public UserProfileFrame() {
        JFrame userProfileFrame = new JFrame("User Profile Panel");

        userProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        userProfileFrame.setPreferredSize(new Dimension(400, 425));
        UserProfilePanel userProfilePanel = new UserProfilePanel();
        userProfileFrame.getContentPane().add(userProfilePanel).setBackground(Color.BLUE);

        userProfileFrame.pack();
        userProfileFrame.setVisible(true);

    }

    public class UserProfilePanel extends JPanel {
        public UserProfilePanel() {
            title = new JLabel("Manage Users", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 28));
            title.setForeground(Color.BLUE);

            selectUserLabel = new JLabel("Select user:");
            user0 = new JRadioButton("Default User");
            user1 = new JRadioButton("-");
            user1.setEnabled(false);
            user2 = new JRadioButton("-");
            user2.setEnabled(false);
            submit1 = new JButton("Submit");

            RadioListener radioListener = new RadioListener();
            user0.addItemListener(radioListener);
            user1.addItemListener(radioListener);
            user2.addItemListener(radioListener);
            submit1.addItemListener(radioListener);


            newUserLabel = new JLabel("<html>Or enter the name of a new user:");
            newUser = new JTextField();
            newUser.setMaximumSize(new Dimension(300,25));
            submit2 = new JButton("Submit");

            SubmitListener sl = new SubmitListener();
            submit2.addActionListener(sl);

            warningLabel = new JLabel("");
            updateLabel = new JLabel("");
            infoLabel = new JLabel("");


            //PANELS
            JPanel selectUserPane = new JPanel();
            selectUserPane.setLayout(new BoxLayout(selectUserPane, BoxLayout.Y_AXIS));
            selectUserPane.add(selectUserLabel);
            selectUserPane.add(user0);
            selectUserPane.add(user1);
            selectUserPane.add(user2);
            selectUserPane.add(submit1);


            JPanel addUserPane = new JPanel();
            addUserPane.setLayout(new BoxLayout(addUserPane, BoxLayout.Y_AXIS));
            addUserPane.add(newUserLabel);
            addUserPane.add(newUser);
            addUserPane.add(submit2);
            addUserPane.add(warningLabel);
            addUserPane.add(updateLabel);
            addUserPane.add(infoLabel);

            JPanel userPane = new JPanel();
            userPane.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;

            c.weightx = .5;
            c.weighty = .5;
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 3;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridx = 4;
            c.gridy = 0;

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.gridheight = 1;
            c.ipady = 30;
            c.weightx = 1.0;
            c.weighty = 1.0;
            c.gridx = 0;
            c.gridy = 1;
            userPane.add(title, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
            c.weighty = 1;
            c.gridx = 0;
            c.gridy = 2;
            userPane.add(selectUserPane, c);

            c.gridwidth = GridBagConstraints.REMAINDER;
            c.weightx = 1.0;
            c.weighty = 1;
            c.gridx = 0;
            c.gridy = 3;
            userPane.add(addUserPane, c);

            userPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

            add(userPane);
        }
    }

    public class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class RadioListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }
}
