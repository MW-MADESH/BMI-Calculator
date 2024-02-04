import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

    private JTextField heightField, weightField;
    private JLabel resultLabel;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel heightLabel = new JLabel("Height (in cm)");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        heightLabel.setForeground(Color.BLUE);
        inputPanel.add(heightLabel);

        heightField = new JTextField();
        heightField.setFont(new Font("Arial", Font.PLAIN, 26));
        inputPanel.add(heightField);

        JLabel weightLabel = new JLabel("Weight (in kg)");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        weightLabel.setForeground(Color.BLUE);
        inputPanel.add(weightLabel);

        weightField = new JTextField();
        weightField.setFont(new Font("Arial", Font.PLAIN, 28));
        inputPanel.add(weightField);

        add(inputPanel, BorderLayout.NORTH);

        // Create a new panel for the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 28));
        calculateButton.setForeground(Color.BLUE);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        buttonPanel.add(calculateButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Create a new panel for the result label
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        resultLabel.setForeground(Color.BLACK); // Set the text color to black
        resultPanel.add(resultLabel);

        add(resultPanel, BorderLayout.SOUTH);
    }

    private void calculateBMI() {
        String heightStr = heightField.getText();
        String weightStr = weightField.getText();

        if (heightStr.isEmpty() || !heightStr.matches("\\d+")) {
            resultLabel.setText("Provide a valid Height!");
        } else if (weightStr.isEmpty() || !weightStr.matches("\\d+")) {
            resultLabel.setText("Provide a valid Weight!");
        } else {
            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);

            double bmi = (weight / ((height * height) / 10000));

            if (bmi < 18.6) {
                resultLabel.setText("You are Under Weight: " + String.format("%.2f", bmi));
            } else if (bmi >= 18.6 && bmi < 24.9) {
                resultLabel.setText("You are Normal: " + String.format("%.2f", bmi));
            } else {
                resultLabel.setText("You are Over Weight: " + String.format("%.2f", bmi));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculator());
    }
}
