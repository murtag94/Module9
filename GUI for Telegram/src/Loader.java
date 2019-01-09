import javax.swing.*;


public class Loader {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        MyTelegramApp myTelegramApp = new MyTelegramApp(frame);
        frame.setResizable(false);
        frame.setTitle("Telegram");
        frame.setSize(800 ,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
