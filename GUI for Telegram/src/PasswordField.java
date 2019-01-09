import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PasswordField {
    private JPanel rootPanel;
    private JPasswordField passwordField;
    private JButton continueButton;
    private JLabel phoneNumber;
    private JLabel message;
    private JButton closeButton;
    private JButton hideButton;
    private BufferedImage logo;
    private BufferedImage background;
    private BufferedImage lock;
    private BufferedImage continueButtonBackground;
    private BufferedImage iconHide;
    private BufferedImage iconClose;

    public PasswordField(Frame frame){
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));//назначение компоновщика для rootPanel и расположение в нем элементов с верху вниз

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
                frame.setState(JFrame.ICONIFIED);//минимизация окна
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
            continueButtonBackground = ImageIO.read(new File("res/img/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            background = ImageIO.read(new File("res/img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logo = ImageIO.read(new File("res/img/logo-mini.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            lock = ImageIO.read(new File("res/img/icon-lock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //отрисовка изобажений и текстов
    private void createUIComponents() {
        hideButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconHide,0,0,null);
            }
        };

        closeButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconClose,0,0,null);
            }
        };
        phoneNumber = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo,78,30,null);
            }
        };

        rootPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background,0,0,800,500,null);
            }
        };
        passwordField = new JPasswordField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lock,0,0,null);
            }
        };
        continueButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(continueButtonBackground,0,0,240,40,null);
                g.drawString("ПРОДОЛЖИТЬ",43,27);//как отцентрировать
            }
        };
    }

    public JLabel getPhoneNumber() { return phoneNumber; }
    public JPanel getRootPanel(){return rootPanel;}
    public JPasswordField getPasswordField(){return passwordField;}
    public JLabel getMessage(){return message;}
    public JButton getContinueButton(){
        return continueButton;
    }
    public JButton getHideButton() { return hideButton; }
    public JButton getCloseButton() { return closeButton; }
}
