package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.TreeMap;
import java.util.Map;

public class MyFrame
{
    private final Map<String, Person> PersonBase = new TreeMap<>();

    JFrame frame;
    JTextField logField;
    JPasswordField passwordField;
    private String text;


    MyFrame()
    {

        this.frame = createFrame();
        this.logField = createTField();
        this.passwordField = createPasswordField();

        JLabel idLabel = createLabel("ID:");
        idLabel.setBounds(110,100,20,30);

        JLabel passwordLabel = createLabel("Pass:");
        passwordLabel.setBounds(100,150,75,30);

        JButton loginButton = createButton("Login");
        loginButton.setBounds(50,300,150,50);
        loginButton.addActionListener(e -> loginButtonPressed(e));

        JButton cancelButton = createButton("Cancel");
        cancelButton.setBounds(290,300,150,50);
        cancelButton.addActionListener(e -> cancelButtonPressed());

        frame.getRootPane().setDefaultButton(loginButton); // Linia ta sprawia, że wcisniety klawisz Enter wciska przycisk "Login"
        frame.add(loginButton);
        frame.add(cancelButton);
        frame.add(logField);
        frame.add(passwordField);
        frame.add(idLabel);
        frame.add(passwordLabel);

        addUsers(PersonBase);
    }


    private JFrame createFrame()
    {
        JFrame frame = new JFrame("");

        frame.setSize(500,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.white);

        return frame;
    }

    private JButton createButton(String text)
    {
        JButton button = new JButton(text);

        button.setSize(50,10);
        button.setFocusable(false);

        return button;
    }

    private void loginButtonPressed(ActionEvent event)
    {
        String login = logField.getText();
        String password = String.valueOf(passwordField.getPassword());


        if(PersonBase.containsKey(login))
        {
            if (PersonBase.get(login).getPassword().equals(password))
                accessPermitted();

            else
                accessDenied();
        }
        else
        {
            accessDenied();
        }
    }

    private void accessPermitted()
    {
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setBackground(Color.green);
        clearT();
    }

    private void accessDenied()
    {
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setBackground(Color.red);
        clearT();
    }

    private void clearT()
    {
        logField.setText(null);
        passwordField.setText(null);
    }

    private void cancelButtonPressed()
    {
        System.exit(0);
    }

    private JTextField createTField()
    {
        JTextField loginField = new JTextField();

        loginField.setBounds(150,100,200,30);
        loginField.setBorder(BorderFactory.createLineBorder(Color.black,2));

        return loginField;
    }

    private JPasswordField createPasswordField()
    {
        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(150, 150,200,30);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black,2));

        return passwordField;
    }

    private JLabel createLabel(String text)
    {
        this.text = text;
        JLabel label = new JLabel(text);

        label.setVisible(true);
        label.setBackground(Color.white);

        return label;
    }

    private void addUsers(Map<String, Person> UserBase)
    {
        Person user1 = new Person("person1", "qweasdzxc");
        UserBase.put(user1.getLog(), user1);

        Person user2 = new Person("person2", "rtyfghvbn");
        UserBase.put(user2.getLog(), user2);

        Person user3 = new Person("person3", "uiojkl");
        UserBase.put(user3.getLog(), user3);

        Person user4 = new Person("person4", "banany9");
        UserBase.put(user4.getLog(), user4);

        Person user5 = new Person("person5", "orzechy12");
        UserBase.put(user5.getLog(), user5);
    }
}