import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PhoneWin extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private JTextArea log = new JTextArea();

    private final JButton add = new JButton("Добавить");
    private final JButton del = new JButton("Удалить");
    private final JPanel panelBottom = new JPanel(new GridLayout(1, 4));
    private JTextField phNum = new JTextField("Телефон");
    private JTextField phName = new JTextField("Имя");

    PhoneWin() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Телефонный справочник");

        panelBottom.add(phNum);
        panelBottom.add(phName);
        panelBottom.add(add);
        panelBottom.add(del);
        add(panelBottom, BorderLayout.SOUTH);
        log.setEnabled(false);
        add(log);

        add.addActionListener(e -> sendMessage(phNum.getText(), phName.getText()));
        phNum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(phNum.getText(), phName.getText());
                }
            }
        });

        del.addActionListener(e -> delMessage(phNum.getText(), phName.getText()));

        setVisible(true);
    }

    private void sendMessage(String text1, String text2) {
        String message = text1 + " " + text2 + "\n";
        log.append(message);
        phNum.setText("");
        phName.setText("");
        EmployeeDirectory.addEmployee(new Employee(text1, text2));
//        try {
//            EmployeeDirectory.printEmployee(text1);
//        }catch (Exception e){
//            //e.printStackTrace();
//            System.out.println("Что то пошло не так..");
//        }
    }

    private void delMessage(String text1, String text2) {
        phNum.setText("");
        phName.setText("");
        EmployeeDirectory.delEmployee(new Employee(text1, text2));
        EmployeeDirectory.rePaint();
        log.setText("");
        for (Employee e :
                EmployeeDirectory.directory) {
            log.append(e.getPhoneNumber() + " " + e.getPhoneName() + "\n");
        }
    }
}
