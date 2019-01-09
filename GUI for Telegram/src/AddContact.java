import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddContact {
    private JPanel rootPanel;
    private JTextField phoneNumber;
    private JTextField firstName;
    private JTextField lastName;
    private JButton addButton;
    private JButton backButton;
    private JLabel addLabel;
    private JLabel userInformationLabel;
    private JPanel bottom;
    private JButton hideButton;
    private JButton closeButton;
    private BufferedImage iconPhone;
    private BufferedImage buttonBackground;
    private BufferedImage iconBack;
    private BufferedImage iconHide;
    private BufferedImage iconClose;

    public AddContact(Frame frame){
        //установка цвета и прозрачности фона элементов формы
        rootPanel.setBackground(new Color(0,0,0,0.8f));
        addButton.setBackground(new Color(0,0,0,0.8f));
        phoneNumber.setBackground(new Color(0,0,0,0.8f));
        lastName.setBackground(new Color(0,0,0,0.8f));
        firstName.setBackground(new Color(0,0,0,0.8f));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));//назначение компоновщика для rootPanel и расположение в нем элементов с верху вниз
        addButton.setForeground(new Color(238, 238, 238));
        backButton.setBackground(Color.BLACK);
        addButton.setBackground(Color.BLACK);

        //обработка нажатия на кнопку закрытия приложения
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//завершение работы приложения
            }
        });

        //обработка нажатия на кнопку сворачивания приложения
        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(JFrame.ICONIFIED); //минимизация окна
            }
        });

        //загрузка ресурсов
        try {
            iconHide = ImageIO.read(new File("res/img/icon-hide.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconClose = ImageIO.read(new File("res/img/icon-close.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconBack = ImageIO.read(new File("res/img/icon-back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconPhone = ImageIO.read(new File("res/img/icon-phone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
}
//отрисовка изобажений и текстов
    private void createUIComponents() {
       phoneNumber = new JTextField(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(iconPhone,0,0,null);
           }
       };

       addButton = new JButton(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(buttonBackground,0,0,240,40,null);
               g.drawString("ДОБАВИТЬ",60,27);
           }
       };

       backButton = new JButton(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(iconBack,0,0,null);
           }
       };
        closeButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconClose,0,0,null);
            }
        };

        hideButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconHide,0,0,null);
            }
        };
    }

    public JPanel getRootPanel() { return rootPanel; }
    public JTextField getPhoneNumber() { return phoneNumber; }
    public JTextField getFirstName() { return firstName; }
    public JTextField getLastName() { return lastName; }
    public JButton getAddButton() { return addButton; }
    public JButton getBackButton() { return backButton; }
    public JLabel getAddLabel() { return addLabel; }
    public JLabel getUserInformationLabel() { return userInformationLabel; }
    public JButton getHideButton() { return hideButton; }
    public JButton getCloseButton() { return closeButton; }
}
