import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Student {
    String name;
    int misd;
    int mish;
    int pris;

    public Student(String name, int misd, int mish, int pris) {
        this.name = name;
        this.misd = misd;
        this.mish = mish;
        this.pris = pris;
    }

    public void displayInfo() {
        JOptionPane.showMessageDialog(null, 
            "Student Name: " + name + "\n" +
            "Missed Days: " + misd + "\n" +
            "Missed Hours: " + mish + "\n" +
            "Disciplinary Actions: " + pris
        );
    }
}

public class StudentsGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Information");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));  // Структура сетки для организации компонентов

        // Панели для каждого студента
        JPanel panel1 = createStudentPanel("Student 1");
        JPanel panel2 = createStudentPanel("Student 2");
        JPanel panel3 = createStudentPanel("Student 3");

        // Добавляем панели на окно
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // Кнопка для отображения информации
        JButton displayButton = new JButton("Display Information");
        frame.add(displayButton);
        
        // Слушатель кнопки, чтобы после нажатия показать информацию
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем данные и создаем студентов
                Student std1 = createStudentFromPanel(panel1);
                Student std2 = createStudentFromPanel(panel2);
                Student std3 = createStudentFromPanel(panel3);
                
                // Показываем информацию о студентах
                std1.displayInfo();
                std2.displayInfo();
                std3.displayInfo();
            }
        });

        // Настроим окно
        frame.setVisible(true);
    }

    // Метод для создания панели ввода данных для студента
    private static JPanel createStudentPanel(String studentLabel) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel(studentLabel + " Name:");
        JTextField nameField = new JTextField();
        JLabel misdLabel = new JLabel("Missed Days:");
        JTextField misdField = new JTextField();
        JLabel mishLabel = new JLabel("Missed Hours:");
        JTextField mishField = new JTextField();
        JLabel prisLabel = new JLabel("Disciplinary Actions:");
        JTextField prisField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(misdLabel);
        panel.add(misdField);
        panel.add(mishLabel);
        panel.add(mishField);
        panel.add(prisLabel);
        panel.add(prisField);

        // Добавляем компоненты в панель
        panel.add(new JLabel());  // Просто пустая строка
        panel.add(new JLabel());  // Просто пустая строка

        // Добавляем текстовые поля в панель
        panel.putClientProperty("nameField", nameField);
        panel.putClientProperty("misdField", misdField);
        panel.putClientProperty("mishField", mishField);
        panel.putClientProperty("prisField", prisField);

        return panel;
    }

    // Метод для создания объекта Student из панели
    private static Student createStudentFromPanel(JPanel panel) {
        JTextField nameField = (JTextField) panel.getClientProperty("nameField");
        JTextField misdField = (JTextField) panel.getClientProperty("misdField");
        JTextField mishField = (JTextField) panel.getClientProperty("mishField");
        JTextField prisField = (JTextField) panel.getClientProperty("prisField");

        String name = nameField.getText();
        int misd = Integer.parseInt(misdField.getText());
        int mish = Integer.parseInt(mishField.getText());
        int pris = Integer.parseInt(prisField.getText());

        return new Student(name, misd, mish, pris);
    }
}
