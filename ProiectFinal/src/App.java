import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class KbcTest implements ActionListener {
    JFrame game, menu;
    JRadioButton rb1, rb2, rb3, rb4;
    JButton b1, b2, exitButton;
    JLabel lb1, lb2;
    JLabel scoreLabel;
    ButtonGroup bg;
    String questions[] = {"Soarele este o planetă, sau o stea?", "Cine a scris cartea Ciuleandra?", "De câți jucători este nevoie într-p echipăde rugbi?",
    "Câți ani a durat Războiul de 100 de ani?", "Cum se numește celebra bătălie în care a fost învins Napoleon"};
    String op1[] = { "Stea", "Liviu Rebreanu", "12", "100", "Waterloo"};
    String op2[] = { "Planetă", "Ion Creangă", "13", "101", "Madrid"};
    String op3[] = { "Mini planetă", "Mihai Eminescu", "14", "103", "Roma"};
    String op4[] = { "Mega planetă", "George Bacovia", "15" , "116", "Paris"};
    String ans[] = { "Stea", "Liviu Rebreanu", "15", "116", "Waterloo"};
    int cn, Score, countQuestion = 0, questionNumber = questions.length;

    KbcTest() {
        // crearea meniului de start
        menu = new JFrame();
        menu.setTitle("Meniu - Joc");
        menu.setLayout(null);
        menu.setSize(800, 800);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        Container cMenu = menu.getContentPane();
        cMenu.setBackground(Color.lightGray);
        b1 = new JButton("Start joc");
        exitButton = new JButton("Ieșire");
        b1.setBounds(350, 400, 150, 30);
        exitButton.setBounds(350, 430, 150, 30);
        exitButton.addActionListener(this);
        b1.addActionListener(this);
        menu.add(b1);
        menu.add(exitButton);

        // crearea intrefetei quizului
        game = new JFrame();
        game.setTitle("Joc");
        game.setLayout(null);
        game.setSize(800, 800);
        Container cGame = game.getContentPane();
        game.setLocationRelativeTo(null);
        cGame.setBackground(Color.lightGray);

        // crearea zonei de scor
        scoreLabel = new JLabel("Scor: 0");
        scoreLabel.setBounds(50, 50, 150, 30);
        game.add(scoreLabel);

        // label pentru intrebare
        lb1 = new JLabel(questions[0]);
        lb1.setBounds(200, 50, 800, 30);
        game.add(lb1);
        lb1.setFont(new Font("Serif", Font.BOLD, 30));

        //prima varianta de raspuns
        rb1 = new JRadioButton(op1[0]);
        rb1.setBounds(200, 120, 150, 30);
        game.add(rb1);
        
        // a doua varianta de raspuns
        rb2 = new JRadioButton(op2[0]);
        rb2.setBounds(400, 120, 150, 30);
        game.add(rb2);

        // a treia varianta de raspuns
        rb3 = new JRadioButton(op3[0]);
        rb3.setBounds(200, 200, 150, 30);
        game.add(rb3);

        // a patra varianta de raspuns
        rb4 = new JRadioButton(op4[0]);
        rb4.setBounds(400, 200, 150, 30);
        game.add(rb4);
        
        //adaugarea elementelor care vor compune interfata grafica
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        
    
        //buton pentru trecerea la intrebarea urmatoare
        b2 = new JButton("Mai departe");
        b2.setBounds(350, 400, 150, 30);
        game.add(b2);
        // b1.addActionListener(this);
        b2.addActionListener(this);
        // game.setVisible(true);
        // menu.setVisible(true);
    }

    public static void main(String s[]) {
        new KbcTest();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            game.setVisible(true);
            menu.dispose();
        } else if (e.getSource() == exitButton) {
            menu.dispose();
        }
        if (e.getSource() == b2) {
            countQuestion++;

            String en = "";
            if (rb1.isSelected())
                en = rb1.getText();
            if (rb2.isSelected())
                en = rb2.getText();
            if (rb3.isSelected())
                en = rb3.getText();
            if (rb4.isSelected())
                en = rb4.getText();
            if (en.equals(ans[cn])) { // afisarea unei ferestre de dialog care precizeaza daca s-a raspuns corect sau gresit la intrebare
                JOptionPane.showMessageDialog(null, "Răspuns corect");
                Score++;
                scoreLabel.setText("Scor: " + Score);
            }
            else 
                JOptionPane.showMessageDialog(null, "Răspuns greșit\nRăspuns corect " + ans[cn]);
            if (countQuestion == questionNumber) { // verificarea daca s-a ajuns al ultima intrebare
                JOptionPane.showMessageDialog(null, "Ai răspuns corect la " + Score + "/" + questionNumber + "întrebări");
            }
            // urmatoarea intrebare
            cn++;
            lb1.setText(questions[cn]);
            rb1.setText(op1[cn]);
            rb2.setText(op2[cn]);
            rb3.setText(op3[cn]);
            rb4.setText(op4[cn]);
        }
    }
}