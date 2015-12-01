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

    //public static String[] userArray;
    public static int userID;

    private JRadioButton defaultUser;
    private JRadioButton userName;
    private JRadioButton newUserName;


    private JLabel userLogin;
    private JTextField userLoginInput;
    private JLabel userPassword;
    private JTextField userPasswordInput;
    private JButton submit;

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
            defaultUser = new JRadioButton("Default User");
            newUserName = new JRadioButton("New User Name");
            userName = new JRadioButton("User Name");

            //now the buttons only select one at a time.
            ButtonGroup bg = new ButtonGroup();
            bg.add(defaultUser);
            bg.add(newUserName);
            bg.add(userName);

            defaultUser.addActionListener(new radioButtonAction());
            userName.addActionListener(new radioButtonAction());
            newUserName.addActionListener(new radioButtonAction());


            userLogin = new JLabel("<html>User Name:");
            userLoginInput = new JTextField();
            userLoginInput.setMaximumSize(new Dimension(300, 25));

            userPassword = new JLabel("<html>Password:");
            userPasswordInput = new JTextField();
            userPasswordInput.setMaximumSize(new Dimension(300, 25));
            submit = new JButton("Submit");

            SubmitListener sl = new SubmitListener();
            userName.addActionListener(sl);
            newUserName.addActionListener(sl);
            submit.addActionListener(sl);

            warningLabel = new JLabel("");
            updateLabel = new JLabel("");
            infoLabel = new JLabel("");


            //PANELS
            JPanel selectUserPane = new JPanel();
            selectUserPane.setLayout(new BoxLayout(selectUserPane, BoxLayout.Y_AXIS));
            selectUserPane.add(selectUserLabel);
            selectUserPane.add(defaultUser);
            selectUserPane.add(newUserName);
            selectUserPane.add(userName);

            JPanel addUserPane = new JPanel();
            addUserPane.setLayout(new BoxLayout(addUserPane, BoxLayout.Y_AXIS));
            addUserPane.add(userLogin);
            addUserPane.add(userLoginInput);
            addUserPane.add(userPassword);
            addUserPane.add(userPasswordInput);
            addUserPane.add(submit);
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
            String user, password;
            user = userLoginInput.getText();
            password = userPasswordInput.getText();
            AddUsers add = new AddUsers();

            if(e.getSource() == submit){
                if(e.getSource() == newUserName) {
                    add.put(user, password);
                    System.out.println(add.size());
                }else if(e.getSource() == userName){
                    System.out.println(add.get(password));
                }

            }
        }
    }

    public class radioButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object s = e.getSource();

            if(s == defaultUser){
                defaultUser.setText("Click 'X' to run a manual budget!");
                userLogin.setVisible(false);
                userLoginInput.setVisible(false);
                userPassword.setVisible(false);
                userPasswordInput.setVisible(false);
                //submit1.setVisible(false);
                submit.setVisible(false);
                userID = 1;

            }
            else if(s == userName){
                userLogin.setText("User Name:");
                userPassword.setText("Password");
                defaultUser.setText("Default User");
                userLogin.setVisible(true);
                userLoginInput.setVisible(true);
                userPassword.setVisible(true);
                userPasswordInput.setVisible(true);
                //submit1.setVisible(true);
                submit.setVisible(true);
                userID = 2;
            }
            else if(s == newUserName) {
                userLogin.setText("New User Name:");
                userPassword.setText("New Password");
                defaultUser.setText("Default User");
                userLogin.setVisible(true);
                userLoginInput.setVisible(true);
                userPassword.setVisible(true);
                userPasswordInput.setVisible(true);
                //submit1.setVisible(true);
                submit.setVisible(true);

            }
        }
    }
}