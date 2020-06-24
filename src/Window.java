import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class Window
{
ArrayList<JPanel> obj = null;
//zastępuj lub nie, jeśli wejdzie na kwadracik to go kasujemy
    public Window()
    {
        obj = new ArrayList<>();
        JFrame window = new JFrame("Squares");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(850, 850);
        JButton buttonUp = new JButton("Up");
        JButton buttonDown = new JButton("Down");
        JButton buttonLeft = new JButton("Left");
        JButton buttonRight = new JButton("Right");

        JButton restartButton = new JButton("Restart");
        JButton saveButton = new JButton("Save");
        JButton readButton = new JButton("Read File");

        JCheckBox pattern = new JCheckBox("Make Pattern");
        JCheckBox eraser = new JCheckBox("Erase Pattern");

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel square = new JPanel();
        square.setBackground(Color.RED);
        square.setBounds(0, 0, 50, 50);
        panel.setLayout(null);
        buttonUp.setBounds(80,0,70,30);
        buttonDown.setBounds(80,40,70,30);
        buttonRight.setBounds(160,40,70,30);
        buttonLeft.setBounds(0,40,70,30);

        restartButton.setBounds(300,0,80,30);
        saveButton.setBounds(390,0,80,30);
        readButton.setBounds(480,0,100,30);
        pattern.setBounds(580,0,200,30);
        eraser.setBounds(580,40,200,30);

        panel.setBounds(0,0,850,850);
        panel2.setBounds(25,125,750,650);
        panel2.setBorder(BorderFactory.createLineBorder(Color.RED));
        panel2.setLayout(null);
        panel2.add(square);
        panel.add(panel2);
        panel.add(buttonUp);
        panel.add(buttonDown);
        panel.add(buttonLeft);
        panel.add(buttonRight);
        panel.add(restartButton);
        panel.add(saveButton);
        panel.add(readButton);
        panel.add(pattern);
        panel.add(eraser);
        window.setContentPane(panel);

        buttonDown.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        if (square.getLocation().y + 50 < 550)
                        {
                            JPanel newSquare = new JPanel();
                            JPanel exists = new JPanel();
                            boolean found = false;

                            newSquare.setBounds(square.getLocation().x + 12, square.getLocation().y + 12, 25,25);
                            newSquare.setBackground(Color.YELLOW);

                            for (JPanel panelsearch : obj) {
                                if(panelsearch.getLocation().y == square.getLocation().y + 12 && panelsearch.getLocation().x == square.getLocation().x + 12)
                                {
                                    exists = panelsearch;
                                    found = true;
                                    break;
                                }
                            }

                            if(pattern.isSelected() && !found)
                            {
                                    panel2.add(newSquare);
                                    obj.add(newSquare);
                            }else if(eraser.isSelected() && found)
                            {
                                obj.remove(exists);
                                panel2.remove(exists);
                            }else if(eraser.isSelected() && pattern.isSelected())
                            {
                                if(found)
                                {
                                    panel2.add(newSquare);
                                    obj.add(newSquare);
                                }else
                                {
                                    obj.remove(exists);
                                    panel2.remove(exists);
                                }
                            }
                            square.setLocation(square.getLocation().x, square.getLocation().y + 50);
                        }
                    }
                }
        );

        buttonUp.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        if (square.getLocation().y - 50 >= 0)
                        {
                            JPanel newSquare = new JPanel();
                            JPanel exists = new JPanel();
                            boolean found = false;

                            newSquare.setBounds(square.getLocation().x + 12, square.getLocation().y + 12, 25,25);
                            newSquare.setBackground(Color.YELLOW);

                            for (JPanel panelsearch : obj) {
                                if(panelsearch.getLocation().y == square.getLocation().y + 12 && panelsearch.getLocation().x == square.getLocation().x + 12)
                                {
                                    exists = panelsearch;
                                    found = true;
                                    break;
                                }
                            }

                            if(pattern.isSelected() && !found)
                            {
                                panel2.add(newSquare);
                                obj.add(newSquare);
                            }else if(eraser.isSelected() && found)
                            {
                                obj.remove(exists);
                                panel2.remove(exists);
                            }else if(eraser.isSelected() && pattern.isSelected())
                            {
                                if(found)
                                {
                                    panel2.add(newSquare);
                                    obj.add(newSquare);
                                }else
                                {
                                    obj.remove(exists);
                                    panel2.remove(exists);
                                }
                            }
                            square.setLocation(square.getLocation().x, square.getLocation().y - 50);
                        }
                    }
                }
        );

        buttonRight.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        if (square.getLocation().x + 50 < 750)
                        {
                            JPanel newSquare = new JPanel();
                            JPanel exists = new JPanel();
                            boolean found = false;

                            newSquare.setBounds(square.getLocation().x + 12, square.getLocation().y + 12, 25,25);
                            newSquare.setBackground(Color.YELLOW);

                            for (JPanel panelsearch : obj) {
                                if(panelsearch.getLocation().y == square.getLocation().y + 12 && panelsearch.getLocation().x == square.getLocation().x + 12)
                                {
                                    exists = panelsearch;
                                    found = true;
                                    break;
                                }
                            }

                            if(pattern.isSelected() && !found)
                            {
                                panel2.add(newSquare);
                                obj.add(newSquare);
                            }else if(eraser.isSelected() && found)
                            {
                                obj.remove(exists);
                                panel2.remove(exists);
                            }else if(eraser.isSelected() && pattern.isSelected())
                            {
                                if(found)
                                {
                                    panel2.add(newSquare);
                                    obj.add(newSquare);
                                }else
                                {
                                    obj.remove(exists);
                                    panel2.remove(exists);
                                }
                            }
                            square.setLocation(square.getLocation().x + 50, square.getLocation().y);

                        }
                    }
                }
        );

        buttonLeft.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        if (square.getLocation().x - 50 >= 0)
                        {
                            JPanel newSquare = new JPanel();
                            JPanel exists = new JPanel();
                            boolean found = false;

                            newSquare.setBounds(square.getLocation().x + 12, square.getLocation().y + 12, 25,25);
                            newSquare.setBackground(Color.YELLOW);

                            for (JPanel panelsearch : obj) {
                                if(panelsearch.getLocation().y == square.getLocation().y + 12 && panelsearch.getLocation().x == square.getLocation().x + 12)
                                {
                                    exists = panelsearch;
                                    found = true;
                                    break;
                                }
                            }

                            if(pattern.isSelected() && !found)
                            {
                                panel2.add(newSquare);
                                obj.add(newSquare);
                            }else if(eraser.isSelected() && found)
                            {
                                obj.remove(exists);
                                panel2.remove(exists);
                            }else if(eraser.isSelected() && pattern.isSelected())
                            {
                                if(found)
                                {
                                    panel2.add(newSquare);
                                    obj.add(newSquare);
                                }else
                                {
                                    obj.remove(exists);
                                    panel2.remove(exists);
                                }
                            }
                            square.setLocation(square.getLocation().x - 50, square.getLocation().y);

                        }
                    }
                }
        );

        restartButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        obj.clear();
                        panel2.removeAll();
                        panel2.revalidate();
                        panel2.add(square);
                        square.setLocation(0,0);
                        panel.repaint();
                    }
                }
        );

        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try
                    {
                        FileOutputStream fos = new FileOutputStream((JOptionPane.showInputDialog("Name of file")+".ser"));
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(obj);
                        oos.close();
                        fos.close();
                    }
                        catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                }
                }
        );

        readButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent)
                    {
                        try
                        {
                            FileInputStream fis = new FileInputStream((JOptionPane.showInputDialog("Name of file")+".ser"));
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<JPanel> readObject = null;
                            readObject = (ArrayList<JPanel>) ois.readObject();

                            if(readObject != null)
                            {
                                for (JPanel readSquare : readObject) {
                                    readSquare.setBounds(readSquare.getLocation().x, readSquare.getLocation().y, 25,25);
                                    readSquare.setBackground(Color.YELLOW);
                                    panel2.add(readSquare);
                                    obj.add(readSquare);
                                }
                                panel2.repaint();
                            }
                            ois.close();
                            fis.close();
                        }
                        catch (IOException ioe)
                        {
                            ioe.printStackTrace();
                            return;
                        }
                        catch (ClassNotFoundException c)
                        {
                            System.out.println("Class not found");
                            c.printStackTrace();
                            return;
                        }
                    }
                }
        );
    }
}
