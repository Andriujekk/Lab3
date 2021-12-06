package javalab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map;

public class MyFrame
{
    private final Map<String, Person> PersonBase = new TreeMap<>();

    JFrame frame;

    private String text;


    MyFrame()
    {

        this.frame = createFrame();



        JButton moveButton = createButton("Move");
        moveButton.setBounds(50,300,150,50);
        moveButton.addActionListener(e -> loginButtonPressed(e));
        Random r =new Random();
        moveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                int x = (r.nextInt()%225)+225;
                int y = (r.nextInt()%200)+200;
                moveButton.setLocation(x,y);
            }
        });
        JButton resetButton = createButton("Reset");
        resetButton.setBounds(290,300,150,50);
        resetButton.addActionListener(e -> resetButtonPressed());


        frame.getRootPane().setDefaultButton(moveButton); // Linia ta sprawia, że wcisniety klawisz Enter wciska przycisk "Login"
        frame.add(moveButton);
        frame.add(resetButton);



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

    }


    private void resetButtonPressed()
    {

    }

    private JTextField createTField()
    {
        JTextField loginField = new JTextField();

        loginField.setBounds(150,100,200,30);
        loginField.setBorder(BorderFactory.createLineBorder(Color.black,2));

        return loginField;
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