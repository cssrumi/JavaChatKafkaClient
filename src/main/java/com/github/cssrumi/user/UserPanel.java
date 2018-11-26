package com.github.cssrumi.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {
    private JTextField userField;
    private JButton changeBtn;
    private UserListener userListener;
    private String token;
    private String username;
    private UsernameChecker checker;

    public UserPanel() {
        init();
        actionInit();

    }

    private void init(){
        Dimension dim = getPreferredSize();
        dim.height = 200;

        userField = new JTextField(10);
        changeBtn = new JButton("Change");

        setLayout(new BorderLayout());

        add(userField, BorderLayout.CENTER);
        add(changeBtn, BorderLayout.EAST);
    }

    private void actionInit() {
        changeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();

                UserEvent ev = new UserEvent(this, username);

                if(userListener != null) {
                    userListener.userEventOccurred(ev);
                }
            }
        });
    }

    public String checkUserAndGetToken(String username){
        token = checker.ifValidGetToken(username);
        return token;
    }

    public void setUserListener(UserListener listener) {
        this.userListener = listener;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
