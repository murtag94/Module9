import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PhoneNumber {
    private JPanel rootPanel;
    private JTextField phoneNumberTextField;
    private JLabel label;
    private JButton continueButton;
    private JButton closeButton;
    private JButton hideButton;
    private BufferedImage background;
    private BufferedImage logo;
    private BufferedImage phoneIcon;
    private BufferedImage continueButtonBackground;
    private BufferedImage iconClose;
    private BufferedImage iconHide;

    public PhoneNumber(Frame frame){
        continueButton.setBorder(new EmptyBorder(0,0,0,0));//создание пустой рамки вокруг кнопки
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));//назначение компоновщика для rootPanel и расположение в нем элементов с верху вниз
        phoneNumberTextField.setForeground(Color.WHITE);
        continueButton.setForeground(new Color(238, 238, 238));

        //обработчик событий, отслеживающий ввод с клавиатуры
        phoneNumberTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(Character.toString(e.getKeyChar()).matches("[^\\d\\+\\-\\()]")) e.consume();//в текстовоен поле вводятся симолы, соответствующие регулярному выражению, т.е. только цифры
            }
        });
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
            background = ImageIO.read(new File("res/img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logo = ImageIO.read(new File("res/img/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            phoneIcon = ImageIO.read(new File("res/img/icon-phone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            continueButtonBackground = ImageIO.read(new File("res/img/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //отрисовка изобажений и текстов
    private void createUIComponents() {
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
        rootPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            g.drawImage(background,0,0,800,500,null);
            }
        };
        label = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo,17,50,null);
            }
        };
        phoneNumberTextField = new JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(phoneIcon,0,0,null);
            }
        };

        continueButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(continueButtonBackground,0,0,240,40,null);
                g.drawString("ПРОДОЛЖИТЬ",43,27); //////////////////////pressed icon?
            }
        };
    }

    public JTextField getPhoneNumberTextField(){
        return phoneNumberTextField;
    }
    public JButton getContinueButton(){return continueButton;}
    public JPanel getRootPanel() {
        return rootPanel;
    }
    public JButton getHideButton(){return hideButton;}
    public JButton getCloseButton() { return closeButton; }
}
