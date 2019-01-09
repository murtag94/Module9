import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SignUp {
    private JPanel rootPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton completeButton;
    private JLabel label;
    private JButton closeButton;
    private JButton hideButton;
    private BufferedImage logo;
    private BufferedImage background;
    private BufferedImage continueButtonBackground;
    private BufferedImage iconClose;
    private BufferedImage iconHide;

    public SignUp(Frame frame) {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));//назначение компоновщика для rootPanel и расположение в нем элементов с верху вниз
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
        //отслеживание фокуса компонента
        lastNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lastNameField.setText(null);//если текстовое поле в фокусе, то текст в нем стирается
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        //отрисовка изобажений и текстов
        firstNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                firstNameField.setText(null);//если текстовое поле в фокусе, то текст в нем стирается
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }
    //отрисовка изобажений и текстов
    private void createUIComponents(){
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
       completeButton = new JButton(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(continueButtonBackground,0,0,240,40,null);
               g.drawString("ЗАВЕРШИТЬ",50,27);
           }
       };

       label = new JLabel(){
           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(logo,78,30,null);
           }
       };
    }

    public JPanel getRootPanel() { return rootPanel; }
    public JTextField getLastNameField() { return lastNameField; }
    public JTextField getFirstNameField() { return firstNameField; }
    public JButton getCompleteButton(){return completeButton; }
    public JLabel getLabel(){return label;}
    public JButton getHideButton() { return hideButton;}
    public JButton getCloseButton() { return closeButton; }
}
