import javax.swing.*;
import java.awt.*;

public class GammaCalculatorApp {
    public static double gamma(double x) {
        if (x == (int)x && x <= 0) {
            throw new IllegalArgumentException("Undefined for non-positive integers.");
        }
        double[] p = {
            0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6,
            1.5056327351493116e-7
        };
        int g = 7;
        if (x < 0.5) {
            return Math.PI / (Math.sin(Math.PI * x) * gamma(1 - x));
        }
        x -= 1;
        double a = p[0];
        for (int i = 1; i < p.length; i++) {
            a += p[i] / (x + i);
        }
        double t = x + g + 0.5;
        return Math.sqrt(2 * Math.PI) * Math.pow(t, x + 0.5) * Math.exp(-t) * a;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gamma Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JTextField input = new JTextField();
        JLabel result = new JLabel("Result:");
        JButton compute = new JButton("Compute Γ(x)");

        compute.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                double res = gamma(val);
                result.setText("Result: " + String.format("%.6f", res));
            } catch (Exception ex) {
                result.setText("Error: " + ex.getMessage());
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(input);
        panel.add(compute);
        panel.add(result);

        frame.add(panel);
        frame.setVisible(true);
    }
}