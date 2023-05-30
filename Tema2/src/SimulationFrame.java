import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {

    private JTextArea simulationLog;
    private JScrollPane scrollPane;
    private JPanel resultsPanel;
    private JPanel inputPanel;
    private JLabel avgWaitingLabel;
    private JLabel avgServiceLabel;
    private JLabel peakHourLabel;
    private JLabel outAvgWaitingLabel;
    private JLabel outAvgServiceLabel;
    private JLabel outPeakHourLabel;
    private JTextField numberOfClientsField;
    private JTextField numberOfServersField;
    private JTextField timeLimitField;
    private JTextField minArrivalTimeField;
    private JTextField maxArrivalTimeField;
    private JTextField minServiceTimeField;
    private JTextField maxServiceTimeField;
    private JButton startButton;

    public SimulationFrame() {
        setTitle("Simulation");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        simulationLog = new JTextArea(20, 70);
        simulationLog.setEditable(false);

        scrollPane = new JScrollPane(simulationLog);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        inputPanel = createInputPanel();
        add(inputPanel);

        resultsPanel = createResultsPanel();
        add(resultsPanel);

        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Number of Clients:"), gbc);
        numberOfClientsField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(numberOfClientsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Number of Servers:"), gbc);
        numberOfServersField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(numberOfServersField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Time Limit:"), gbc);
        timeLimitField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(timeLimitField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Min Arrival Time:"), gbc);
        minArrivalTimeField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(minArrivalTimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Max Arrival Time:"), gbc);
        maxArrivalTimeField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(maxArrivalTimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Min Service Time:"), gbc);
        minServiceTimeField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(minServiceTimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Max Service Time:"), gbc);
        maxServiceTimeField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(maxServiceTimeField, gbc);

        startButton = new JButton("Start Simulation");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(startButton, gbc);

        return panel;
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(avgWaitingLabel = new JLabel("Average waiting time:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(avgServiceLabel = new JLabel("Average service time:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(peakHourLabel = new JLabel("Peak hour:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(outAvgServiceLabel = new JLabel("--"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(outAvgServiceLabel = new JLabel("--"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(outPeakHourLabel = new JLabel("--"), gbc);

        return panel;
    }

    public void appendLog(String text) {
        simulationLog.append(text + "\n");
        simulationLog.setCaretPosition(simulationLog.getDocument().getLength());
    }

    public void setAvgWaitingTime(double avgWaitingTime) {
        outAvgWaitingLabel.setText("" + avgWaitingTime);
    }

    public void setAvgServiceTime(double avgServiceTime) {
        outAvgServiceLabel.setText("" + avgServiceTime);
    }

    public void setPeakHour(int peakHour) {
        outPeakHourLabel.setText("" + peakHour);
    }

    public void setStartButtonActionListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    // Getters for input fields
    public int getNumberOfClients() {
        return Integer.parseInt(numberOfClientsField.getText());
    }

    public int getNumberOfServers() {
        return Integer.parseInt(numberOfServersField.getText());
    }

    public int getTimeLimit() {
        return Integer.parseInt(timeLimitField.getText());
    }

    public int getMinArrivalTime() {
        return Integer.parseInt(minArrivalTimeField.getText());
    }

    public int getMaxArrivalTime() {
        return Integer.parseInt(maxArrivalTimeField.getText());
    }

    public int getMinServiceTime() {
        return Integer.parseInt(minServiceTimeField.getText());
    }

    public int getMaxServiceTime() {
        return Integer.parseInt(maxServiceTimeField.getText());
    }
}
