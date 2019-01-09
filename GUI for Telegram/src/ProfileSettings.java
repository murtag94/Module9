import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfileSettings {
    private JPanel rootPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton saveButton;
    private JLabel label;
    private JPanel bottom;
    private JButton backButton;
    private JButton exitButton;
    private JLabel phoneNumber;
    private JButton closeButton;
    private JButton hideButton;
    private BufferedImage buttonBackground;
    private BufferedImage backIcon;
    private BufferedImage iconHide;
    private BufferedImage iconClose;

    public ProfileSettings(Frame frame){
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
            buttonBackground = ImageIO.read(new File("res/img/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            backIcon = ImageIO.read(new File("res/img/icon-back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //отрисовка изобажений и текстов
    private void createUIComponents() {
        hideButton = new JButton(){
            @Override
            protected void paintBorder(Graphics g) {
                super.paintBorder(g);
                g.drawImage(iconHide,0,0,null);
            }
        };
        closeButton = new JButton(){
            @Override
            protected void paintBorder(Graphics g) {
                super.paintBorder(g);
                g.drawImage(iconClose,0,0,null);
            }
        };
        saveButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackground,0,1,240,40,null);
                g.drawString("СОХРАНИТЬ",50,30);
            }
        };
        backButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backIcon,0,0,null);
            }
        };
    }
    public JPanel getRootPanel() { return rootPanel; }
    public JButton getBackButton(){return backButton;}
    public JButton getExitButton() { return exitButton; }
    public JTextField getLastNameField(){return lastNameField;}
    public JTextField getFirstNameField(){return firstNameField;}
    public JButton getSaveButton() { return saveButton; }
    public JLabel getLabel() { return label; }
    public JLabel getPhoneNumber() { return phoneNumber; }
    public JButton getCloseButton() { return closeButton;}
    public JButton getHideButton() { return hideButton; }
}
