package com.password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class PasswordGeneratorGUI extends JFrame implements ActionListener {
    private JTextField lengthField;
    private JButton generateButton;
    private JCheckBox uppercaseCheckbox;
    private JCheckBox lowercaseCheckbox;
    private JCheckBox numbersCheckbox;
    private JCheckBox specialCharsCheckbox;
    private JTextField passwordField;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField(10);
        generateButton = new JButton("Generate");
        generateButton.addActionListener(this);
        passwordField = new JTextField(20);
        passwordField.setEditable(false);

        topPanel.add(lengthLabel);
        topPanel.add(lengthField);
        topPanel.add(generateButton);
        topPanel.add(passwordField);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 4));

        uppercaseCheckbox = new JCheckBox("Uppercase");
        lowercaseCheckbox = new JCheckBox("Lowercase");
        numbersCheckbox = new JCheckBox("Numbers");
        specialCharsCheckbox = new JCheckBox("Special Characters");

        bottomPanel.add(uppercaseCheckbox);
        bottomPanel.add(lowercaseCheckbox);
        bottomPanel.add(numbersCheckbox);
        bottomPanel.add(specialCharsCheckbox);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            generatePassword();
        }
    }

    private void generatePassword() {
        int length = Integer.parseInt(lengthField.getText());
        boolean includeUppercase = uppercaseCheckbox.isSelected();
        boolean includeLowercase = lowercaseCheckbox.isSelected();
        boolean includeNumbers = numbersCheckbox.isSelected();
        boolean includeSpecialChars = specialCharsCheckbox.isSelected();

        String password = PasswordGenerator.generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        passwordField.setText(password);
        passwordField.selectAll();

        StringSelection selection = new StringSelection(password);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordGeneratorGUI());
    }
}
