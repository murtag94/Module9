import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class MainScreen {
    private JPanel rootPanel;
    private JPanel top;
    private JPanel left;
    private JButton settingsButton;
    private JLabel label;
    private JButton plusButton;
    private JButton sendButton;
    private JButton searchButton;
    private JTextField searchingRequest;
    private JPanel center;
    private JTextField userMessage;
    private JButton editButton;
    private JLabel currentContact;
    private JButton contact1;
    private JButton contact2;
    private JButton contact3;
    private JButton contact4;
    private JButton closeButton;
    private JButton hideButton;
    private JLabel message1;
    private JLabel message2;
    private JLabel message3;
    private JScrollPane scrollPane;
    private JPanel messages;
    private BufferedImage iconSettings;
    private BufferedImage logoMicro;
    private BufferedImage buttonSend;
    private BufferedImage iconPlus;
    private BufferedImage iconSearch;
    private BufferedImage iconEdit;
    private BufferedImage iconHide;
    private BufferedImage iconClose;
    private BufferedImage maskGray;
    private BufferedImage maskGrayOnline;
    private BufferedImage maskWhite;
    private BufferedImage messageInBottom;
    private BufferedImage messageInLeft;
    private BufferedImage messageInTop;
    private BufferedImage messageOutBottom;
    private BufferedImage messageOutRight;
    private BufferedImage messageOutTop;
    private Font regularFont;
    private Font boldFont;

    public MainScreen(Frame frame){

        //отрисовка изобажений и текстов
        searchingRequest.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                searchingRequest.setText("");//если текстовое поле в фокусе, то текст в нем стирается
            }

            @Override
            public void focusLost(FocusEvent e) {

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
        try{
            regularFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    new File("res/fonts/OpenSansRegular.ttf")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            boldFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    new File("res/fonts/OpenSansSemiBold.ttf")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(regularFont);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(boldFont);
        //contact1.get
        try {
            messageOutTop = ImageIO.read(new File("res/img/message-out-top.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageOutRight = ImageIO.read(new File("res/img/message-out-right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageOutBottom = ImageIO.read(new File("res/img/message-out-bottom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageInTop = ImageIO.read(new File("res/img/message-in-top.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageInLeft = ImageIO.read(new File("res/img/message-in-left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageInBottom = ImageIO.read(new File("res/img/message-in-bottom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            maskWhite = ImageIO.read(new File("res/img/mask-white.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            maskGrayOnline = ImageIO.read(new File("res/img/mask-gray-online.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            maskGray = ImageIO.read(new File("res/img/mask-gray.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            iconEdit = ImageIO.read(new File("res/img/icon-edit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconSearch = ImageIO.read(new File("res/img/icon-search.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconPlus = ImageIO.read(new File("res/img/icon-plus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            buttonSend = ImageIO.read(new File("res/img/button-send.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logoMicro = ImageIO.read(new File("res/img/logo-micro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            iconSettings = ImageIO.read(new File("res/img/icon-settings.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //отрисовка изображений и шрифтов
    private void createUIComponents() {

        currentContact = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskWhite,10,0,29,29,null);
            }
        };
        message1 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(messageInTop,7,0,null);
                g.setColor(new Color(0, 169, 219));
                g.fillRect(7,8,308,50);
                g.drawImage(messageInLeft,0,19,null);
                g.drawImage(messageInBottom,7,58,null);
                g.setColor(new Color(100,100,100));
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("дд.мм.гг вв:вв",230,75);
            }
        };
        message2 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(messageInTop,7,0,null);
                g.setColor(new Color(0, 169, 219));
                g.fillRect(7,8,308,50);
                g.drawImage(messageInLeft,0,19,null);
                g.drawImage(messageInBottom,7,58,null);
                g.setColor(new Color(100,100,100));
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("вчера вв:вв",240,75);
            }
        };
        message3 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(messageOutTop,285,0,null);
                g.setColor(new Color(75, 65, 172));
                g.fillRect(285,9,307,50);
                g.drawImage(messageOutRight,592,19,null);
                g.drawImage(messageOutBottom,285,58,null);
                g.setColor(new Color(100,100,100));
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("5 минут назад",285,78);
            }
        };
        contact1 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskGrayOnline,16,15,null);
                g.setFont(regularFont.deriveFont(16.0f));
                g.drawString("Пётр Сергеев",60,40);
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("message message message message message message",60,60);
            }
        };
        contact2 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskGray,16,15,null);
                g.setFont(regularFont.deriveFont(16.0f));
                g.drawString("Андрей Петров",60,40);
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("message message message message message message",60,60);
            }
        };
        contact3 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskGray,16,15,null);
                g.setFont(regularFont.deriveFont(16.0f));
                g.drawString("Дмитрий Петров",60,40);
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("message message message message message message",60,60);
            }
        };
        contact4 = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(maskGrayOnline,16,15,null);
                g.setFont(regularFont.deriveFont(16.0f));
                g.drawString("Петраков Олег",60,40);
                g.setFont(regularFont.deriveFont(12.0f));
                g.drawString("message message message message message message",60,60);
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

        editButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconEdit,5,5,null);
            }
        };

        label = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logoMicro,5,3,null);
            }
        };
        settingsButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconSettings,0,4,null);
            }
        };

        sendButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buttonSend,0,0,null);
            }
        };
        plusButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconPlus,0,0,null);
            }
        };
        searchButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconSearch,2,4,null);
            }
        };
    }
    public JPanel getRootPanel(){return rootPanel;}
    public JButton getSettingsButton(){return settingsButton;}
    public JButton getSendButton(){return sendButton;}
    public JButton getPlusButton(){return plusButton;}
    public JButton getSearchButton(){return searchButton;}
    public JTextField getSearchingRequest(){return searchingRequest;}
    public JButton getEditButton() {
        return editButton;
    }
    public JButton getContact1() {
        return contact1;
    }
    public JButton getCloseButton() {
        return closeButton;
    }
    public JButton getHideButton() {
        return hideButton;
    }
    public JTextField getUserMessage() { return userMessage; }
}
