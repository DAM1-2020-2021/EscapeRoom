package org.iesfm.escaperoom.swing;

import org.iesfm.escaperoom.EscapeRoom;
import org.iesfm.escaperoom.QuestionAnswer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

public class SwingEscapeRoom extends JFrame {

    private EscapeRoom escapeRoom;

    private JPanel mainPanel = new JPanel();
    private Font font = new Font("Arial", 40, 40);

    public SwingEscapeRoom(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;

        init();
    }

    public void init() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JOptionPane.showMessageDialog(this, escapeRoom.getWelcomeMsg());

        java.util.Timer t = new java.util.Timer();
        t.schedule(new EndTask(this), 20 * 60 * 1000);

        this.add(mainPanel);
        mainPanel.setLayout(new GridLayout(3,1));

        showCurrentQuestion();
        this.validate();

    }

    private JTextField createSingleCharacterTextField() {
        JTextField charField = new JTextField();
        charField.setFont(font);
        charField.setText("X");
        charField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(charField.getText().equals("X")) {
                    charField.setText("");
                }
            }
        });
        charField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE && charField.getText().isEmpty()) {
                    charField.transferFocusBackward();
                } else {
                    charField.setText(""  + e.getKeyChar());
                    if(!charField.getText().equals("")) {
                        charField.transferFocus();
                    }
                }
            }
        });
        charField.setEnabled(true);
        charField.setEditable(true);
        return charField;
    }

    public void showCurrentQuestion() {
        QuestionAnswer question = escapeRoom.currentQuestion();

        mainPanel.removeAll();

        JLabel questionLabel = new JLabel();
        questionLabel.setFont(font);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setText(question.getQuestion());

        mainPanel.add(questionLabel);


        JPanel responsePanel = new JPanel();

        responsePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        mainPanel.add(responsePanel);
        List<List<JTextField>> responseFields = new LinkedList<>();
        for (int wordSize : question.numLettersPerWordInAnswer(question.getAnswer())) {
            List<JTextField> wordFields = new LinkedList<>();
            JPanel wordPanel = new JPanel();
            wordPanel.setBorder(new EmptyBorder(0,10,0,10));
            for (int i = 0; i < wordSize; i++) {
                JTextField charTextField = createSingleCharacterTextField();
                wordPanel.add(charTextField);
                wordFields.add(charTextField);
            }
            responseFields.add(wordFields);
            responsePanel.add(wordPanel);
        }

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Responder");
        button.setFont(font);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuffer responseBuffer = new StringBuffer();
                for (List<JTextField> wordFields : responseFields) {
                    StringBuffer wordBuffer = new StringBuffer();
                    for(JTextField field: wordFields) {
                        wordBuffer.append(field.getText());
                    }
                    wordBuffer.append(" ");
                    responseBuffer.append(wordBuffer.toString());
                }
                final String response = responseBuffer.toString().trim();
                if (escapeRoom.correctAnswer(response.trim())) {
                    if (escapeRoom.isFinished()) {
                        JOptionPane.showMessageDialog(SwingEscapeRoom.this, escapeRoom.getCongratulationsMsg());
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(SwingEscapeRoom.this, "Correcto! Siguiente pregunta");
                        showCurrentQuestion();
                    }
                } else {
                    JOptionPane.showMessageDialog(SwingEscapeRoom.this, "Respuesta incorrecta");
                    showCurrentQuestion();

                }
                SwingUtilities.updateComponentTreeUI(SwingEscapeRoom.this);
                SwingEscapeRoom.this.invalidate();
                SwingEscapeRoom.this.validate();
                SwingEscapeRoom.this.repaint();
            }
        });
        mainPanel.add(buttonPanel);
    }
}
