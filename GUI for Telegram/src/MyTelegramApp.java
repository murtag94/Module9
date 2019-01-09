import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MyTelegramApp {
    PhoneNumber phoneNumber;
    PasswordField passwordField;
    SignUp signUp;
    MainScreen mainScreen;
    ProfileSettings profileSettings;
    AddContact addContact;
    EditContact editContact;

    Font regularFont;
    Font lightFont;
    Font boldFont;

    Border line;
    Border bottomBorderWithIndention;
    Border simpleBottomBorder;
    Border emptyBorder;

    public MyTelegramApp(JFrame frame){
        //загрузка шрифтов
        try{
        regularFont = Font.createFont(
                Font.TRUETYPE_FONT,
                new File("res/fonts/OpenSansRegular.ttf")
        );
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
        lightFont = Font.createFont(
                Font.TRUETYPE_FONT,
                new File("res/fonts/OpenSansLight.ttf")
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
        //регистрация шрифтов
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(regularFont);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(boldFont);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(lightFont);

        //параметры рамок
        line = BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE);
        bottomBorderWithIndention = new CompoundBorder(line, new EmptyBorder(0, 23, 0, 0));
        simpleBottomBorder = new CompoundBorder(line,new EmptyBorder(0,0,0,0));
        emptyBorder = new EmptyBorder(0,0,0,0);

        //отрисовка первой формы с вводом номера телефона, выставление параметров отрисовки рамок и шрифтов в форме
        phoneNumber = new PhoneNumber(frame);
        phoneNumber.getContinueButton().setFont(regularFont.deriveFont(22.0f));
        phoneNumber.getPhoneNumberTextField().setFont(regularFont.deriveFont(28.0f));
        phoneNumber.getPhoneNumberTextField().setBorder(bottomBorderWithIndention);
        phoneNumber.getHideButton().setBorder(emptyBorder);
        phoneNumber.getCloseButton().setBorder(emptyBorder);
        frame.setContentPane(phoneNumber.getRootPanel());
        frame.setVisible(true);
        phoneNumber.getPhoneNumberTextField().setCaretPosition(3);
        passwordField = new PasswordField(frame);

        //обработчик нажатия кнопки "продолжить"
        phoneNumber.getContinueButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               //при нажатии на кнопку, отрисовывается окно ввода пароля с заданными параметрами рамок и шрифтов
               passwordField.getPhoneNumber().setText(phoneNumber.getPhoneNumberTextField().getText());
               passwordField.getPasswordField().setBorder(bottomBorderWithIndention);
               passwordField.getContinueButton().setBorder(new EmptyBorder(0,0,0,0));
               passwordField.getCloseButton().setBorder(emptyBorder);
               passwordField.getHideButton().setBorder(emptyBorder);
               passwordField.getContinueButton().setFont(regularFont.deriveFont(22.0f));
               passwordField.getPhoneNumber().setFont(regularFont.deriveFont(36.0f));
               passwordField.getMessage().setFont(regularFont.deriveFont(14.0f));
               frame.setContentPane(passwordField.getRootPanel());
               frame.setVisible(true);
           }
       });
       signUp = new SignUp(frame);
       //обработчик нажатия кнопки "продолжить" в окне с паролем
       passwordField.getContinueButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //при нажатии на кнопку, отрисовывается окно ввода фамилии и имени с заданными параметрами рамок и шрифтов
               signUp.getFirstNameField().setBorder(simpleBottomBorder);
               signUp.getLastNameField().setBorder(simpleBottomBorder);
               signUp.getCloseButton().setBorder(emptyBorder);
               signUp.getHideButton().setBorder(emptyBorder);
               signUp.getCompleteButton().setBorder(new EmptyBorder(0,0,0,0));  //вынести в объект
               signUp.getCompleteButton().setFont(regularFont.deriveFont(22.0f));
               signUp.getFirstNameField().setFont(lightFont.deriveFont(24.0f));
               signUp.getLastNameField().setFont(lightFont.deriveFont(24.0f));
               signUp.getLabel().setFont(regularFont.deriveFont(14.0f));
               frame.setContentPane(signUp.getRootPanel());
               frame.setVisible(true);
           }
       });
       mainScreen = new MainScreen(frame);
        //обработчик нажатия кнопки "завершить" в окне с вводом имени и пароля
       signUp.getCompleteButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //при нажатии на кнопку, отрисовывается основное окно с чатом и контактами с заданными параметрами рамок и шрифтов
               mainScreen.getContact1().setBorder(new LineBorder(Color.GRAY,1));
               mainScreen.getEditButton().setBorder(emptyBorder);
               mainScreen.getSettingsButton().setBorder(emptyBorder);
               mainScreen.getSendButton().setBorder(emptyBorder);
               mainScreen.getPlusButton().setBorder(emptyBorder);
               mainScreen.getSearchButton().setBorder(emptyBorder);
               mainScreen.getSearchingRequest().setBorder(emptyBorder);
               mainScreen.getCloseButton().setBorder(emptyBorder);
               mainScreen.getHideButton().setBorder(emptyBorder);
               mainScreen.getUserMessage().setFont(regularFont.deriveFont(18.0f));
               mainScreen.getSearchingRequest().setFont(regularFont.deriveFont(18.0f));
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        profileSettings  = new ProfileSettings(frame);
        //обработчик нажатия кнопки настроек
       mainScreen.getSettingsButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //при нажатии на кнопку, отрисовывается окно с настройками профиля с заданными параметрами рамок и шрифтов
               profileSettings.getFirstNameField().setFont(regularFont.deriveFont(20.0f));
               profileSettings.getLastNameField().setFont(regularFont.deriveFont(20.0f));
               profileSettings.getLabel().setFont(regularFont.deriveFont(28.0f));
               profileSettings.getSaveButton().setFont(regularFont.deriveFont(20.0f));
               profileSettings.getPhoneNumber().setFont(regularFont.deriveFont(14.0f));
               profileSettings.getCloseButton().setBorder(emptyBorder);
               profileSettings.getHideButton().setBorder(emptyBorder);
               profileSettings.getLastNameField().setBorder(simpleBottomBorder);
               profileSettings.getFirstNameField().setBorder(simpleBottomBorder);
               profileSettings.getExitButton().setBorder(emptyBorder);
               profileSettings.getSaveButton().setBorder(emptyBorder);
               profileSettings.getBackButton().setBorder(emptyBorder);

               frame.setContentPane(profileSettings.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки "выход" в окне настроек, при нажатии отрисовывается первое окно ввода телефона
       profileSettings.getExitButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(phoneNumber.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки назад в окне настроек, при нажатии отрисовывается основное окно с чатом
       profileSettings.getBackButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        addContact = new AddContact(frame);
        //обработчик нажатия кнопки плюс
       mainScreen.getPlusButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               //при нажатии на кнопку, отрисовывается окно добавления нового контакта с заданными параметрами рамок и шрифтов
               addContact.getFirstName().setBorder(simpleBottomBorder);
               addContact.getLastName().setBorder(simpleBottomBorder);
               addContact.getPhoneNumber().setBorder(bottomBorderWithIndention);
               addContact.getAddButton().setBorder(emptyBorder);
               addContact.getBackButton().setBorder(emptyBorder);
               addContact.getHideButton().setBorder(emptyBorder);
               addContact.getCloseButton().setBorder(emptyBorder);
               addContact.getPhoneNumber().setFont(regularFont.deriveFont(20.0f));
               addContact.getLastName().setFont(regularFont.deriveFont(20.0f));
               addContact.getFirstName().setFont(regularFont.deriveFont(20.0f));
               addContact.getAddLabel().setFont(regularFont.deriveFont(28.0f));
               addContact.getUserInformationLabel().setFont(regularFont.deriveFont(14.0f));
               addContact.getAddButton().setFont(regularFont.deriveFont(24.0f));
               frame.setContentPane(addContact.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки назад в окне добавления нового пользователя, при нажатии отрисовывается основное окно
       addContact.getBackButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки "добавить" в окне добавления нового пользователя, при нажатии отрисовывается основное окно
       addContact.getAddButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        editContact = new EditContact(frame);
        //обработчик нажатия кнопки сизображением карандаша
       mainScreen.getEditButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //при нажатии на кнопку, отрисовывается окно редактирования контакта с заданными параметрами рамок и шрифтов
               editContact.getBackButton().setBorder(emptyBorder);
               editContact.getSaveButton().setBorder(emptyBorder);
               editContact.getCloseButton().setBorder(emptyBorder);
               editContact.getHideButton().setBorder(emptyBorder);
               editContact.getName().setBorder(new CompoundBorder(line, new EmptyBorder(0, 60, 0, 0)));
               editContact.getName().setFont(regularFont.deriveFont(20.0f));
               editContact.getEditLabel().setFont(regularFont.deriveFont(28.0f));
               editContact.getSaveButton().setFont(regularFont.deriveFont(30.0f));
               editContact.getDeleteButton().setBorder(new LineBorder(Color.red,1));
               frame.setContentPane(editContact.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки "удалить пользователя" в окне редактирования контакта, при нажатии отрисовывается основное окно
       editContact.getDeleteButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки "сохранить" в окне редактирования контакта, при нажатии отрисовывается основное окно
       editContact.getSaveButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
        //обработчик нажатия кнопки назад в окне редактирования контакта, при нажатии отрисовывается основное окно
       editContact.getBackButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setContentPane(mainScreen.getRootPanel());
               frame.setVisible(true);
           }
       });
    }
}
