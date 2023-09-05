package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class AdminPanel extends JFrame implements ActionListener {

    private List<QuizQuestion> quizQuestions; // Store quiz questions
    private int currentIndex; // Track the current question being edited
    private JTextArea questionArea;
    private JTextField option1Field, option2Field, option3Field, option4Field;
    private ButtonGroup optionGroup;
    private JRadioButton option1RadioButton, option2RadioButton, option3RadioButton, option4RadioButton;
    private JButton addQuestionButton, editQuestionButton, deleteQuestionButton, saveQuestionButton, nextQuestionButton;

    AdminPanel() {
        setTitle("Admin Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        quizQuestions = new ArrayList<>();
        currentIndex = -1;

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a panel for the question input
JPanel questionPanel = new JPanel();
questionPanel.setLayout(new BorderLayout());

// Create a label for entering questions
JLabel questionLabel = new JLabel("Enter Your Question:");

// Add the label and text area to the question panel
questionPanel.add(questionLabel, BorderLayout.NORTH);
//questionPanel.add(questionScrollPane, BorderLayout.CENTER);

// Add the question panel to the main panel
panel.add(questionPanel, BorderLayout.NORTH);
  



        // Create a text area for entering questions
        questionArea = new JTextArea(5, 20);
        JScrollPane questionScrollPane = new JScrollPane(questionArea);
        panel.add(questionScrollPane, BorderLayout.NORTH);

        // Create option fields and radio buttons
        option1Field = new JTextField(20);
        option2Field = new JTextField(20);
        option3Field = new JTextField(20);
        option4Field = new JTextField(20);

        option1RadioButton = new JRadioButton();
        option1RadioButton.setActionCommand("Option1");
        option2RadioButton = new JRadioButton();
        option2RadioButton.setActionCommand("Option2");
        option3RadioButton = new JRadioButton();
        option3RadioButton.setActionCommand("Option3");
        option4RadioButton = new JRadioButton();
        option4RadioButton.setActionCommand("Option4");

        optionGroup = new ButtonGroup();
        optionGroup.add(option1RadioButton);
        optionGroup.add(option2RadioButton);
        optionGroup.add(option3RadioButton);
        optionGroup.add(option4RadioButton);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 2));
        optionsPanel.add(option1RadioButton);
        optionsPanel.add(option1Field);
        optionsPanel.add(option2RadioButton);
        optionsPanel.add(option2Field);
        optionsPanel.add(option3RadioButton);
        optionsPanel.add(option3Field);
        optionsPanel.add(option4RadioButton);
        optionsPanel.add(option4Field);

        panel.add(optionsPanel, BorderLayout.CENTER);

        // Create buttons for actions
        addQuestionButton = new JButton("Add Question");
        editQuestionButton = new JButton("Edit Question");
        deleteQuestionButton = new JButton("Delete Question");
        saveQuestionButton = new JButton("Save Question");
        nextQuestionButton = new JButton("Next Question");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addQuestionButton);
        buttonPanel.add(editQuestionButton);
        buttonPanel.add(deleteQuestionButton);
        buttonPanel.add(saveQuestionButton);
        buttonPanel.add(nextQuestionButton);

        addQuestionButton.addActionListener(this);
        editQuestionButton.addActionListener(this);
        deleteQuestionButton.addActionListener(this);
        saveQuestionButton.addActionListener(this);
        nextQuestionButton.addActionListener(this);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQuestionButton) {
            // Add a new question
            currentIndex = -1;
            clearFields();
        } else if (e.getSource() == editQuestionButton) {
            // Edit the selected question
            int selectedOption = getSelectedOption();
            if (selectedOption != -1) {
                currentIndex = selectedOption;
                QuizQuestion question = quizQuestions.get(currentIndex);
                populateFields(question);
            }
        } else if (e.getSource() == deleteQuestionButton) {
            // Delete the selected question
            int selectedOption = getSelectedOption();
            if (selectedOption != -1) {
                quizQuestions.remove(selectedOption);
                clearFields();
            }
        } else if (e.getSource() == saveQuestionButton) {
            // Save the current question
            String questionText = questionArea.getText();
            String[] options = {
                option1Field.getText(),
                option2Field.getText(),
                option3Field.getText(),
                option4Field.getText()
            };
            int correctOption = getSelectedOption();
            if (currentIndex != -1 && !questionText.isEmpty() && correctOption != -1) {
                QuizQuestion updatedQuestion = new QuizQuestion(questionText, options, correctOption);
                quizQuestions.set(currentIndex, updatedQuestion);
                clearFields();
            }
        } else if (e.getSource() == nextQuestionButton) {
            // Move to the next question
            if (currentIndex < quizQuestions.size() - 1) {
                currentIndex++;
                QuizQuestion question = quizQuestions.get(currentIndex);
                populateFields(question);
            } else {
                clearFields();
            }
        }
    }

    private int getSelectedOption() {
        if (option1RadioButton.isSelected()) return 0;
        if (option2RadioButton.isSelected()) return 1;
        if (option3RadioButton.isSelected()) return 2;
        if (option4RadioButton.isSelected()) return 3;
        return -1; // No option selected
    }

    private void populateFields(QuizQuestion question) {
        questionArea.setText(question.getQuestion());
        String[] options = question.getOptions();
        option1Field.setText(options[0]);
        option2Field.setText(options[1]);
        option3Field.setText(options[2]);
        option4Field.setText(options[3]);
        optionGroup.clearSelection();
        switch (question.getCorrectOption()) {
            case 0:
                option1RadioButton.setSelected(true);
                break;
            case 1:
                option2RadioButton.setSelected(true);
                break;
            case 2:
                option3RadioButton.setSelected(true);
                break;
            case 3:
                option4RadioButton.setSelected(true);
                break;
        }
    }

    private void clearFields() {
        questionArea.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        optionGroup.clearSelection();
        currentIndex = -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminPanel());
    }

    // Define a QuizQuestion class to store question data
    private class QuizQuestion {
        private String question;
        private String[] options;
        private int correctOption;

        QuizQuestion(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }

        String getQuestion() {
            return question;
        }

        String[] getOptions() {
            return options;
        }

        int getCorrectOption() {
            return correctOption;
        }
    }
}


