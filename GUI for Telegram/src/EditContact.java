import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditContact {
    private JPanel rootPanel;
    private JTextField name;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton backButton;
    private JLabel contactNumber;
    private JLabel editLabel;
    private JButton hideButton;
    private JButton closeButton;
    private BufferedImage iconTrash;
    private BufferedImage iconBack;
    private BufferedImage maskDarkGrayBig;
    private BufferedImage buttonBackGround;
    private BufferedImage iconHide;
    private BufferedImage iconClose;

    public EditContact(Frame frame){
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));//назначение компоновщика для rootPanel и расположение в нем элементов с верху вниз
        editLabel.setForeground(new Color(0, 179, 230));//изменение цвета надписи

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
            buttonBackGround = ImageIO.read(new File("res/img/button-background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            maskDarkGrayBig = ImageIO.read(new File("res/img/mask-dark-gray-big.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            iconBack = ImageIO.read(new File("res/img/icon-back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            iconTrash = ImageIO.read(new File("res/img/icon-trash.png"));
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
        saveButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonBackGround,0,0,240,40,null);
                g.drawString("Сохранить",43,27);
            }
        };

        name = new JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskDarkGrayBig,10,5,40,40,null);
            }
        };

        backButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconBack,0,0,null);
            }
        };

        deleteButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconTrash,4,3,null);
            }
        };
    }

    public JPanel getRootPanel() { return rootPanel; }
    public JTextField getName() { return name; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getSaveButton() { return saveButton; }
    public JLabel getEditLabel() { return editLabel; }
    public JButton getBackButton() { return backButton; }
    public JButton getCloseButton() { return closeButton; }
    public JButton getHideButton() { return hideButton; }
}
