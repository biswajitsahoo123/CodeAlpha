import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class word_counter extends JFrame {
    private JPanel panelmain;
    private JLabel no1;
    private JTextField textField1;
    private JButton COUNTWORDButton;
    private JTextField res;
    private JLabel result;
    public JFrame jf;

    private void countword(){

        String text=textField1.getText();
        if(text.length()<=0){
            res.setText("NO WORDS HERE ! ");
        }
        else{
            String [] word=text.split("\\s+");
            int count =word.length;
            res.setText("NUMBER OF WORD/S IS/ARE : "+count);
        }
    }

    public word_counter(){

        COUNTWORDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countword();
            }
        });
    }
    public static void main (String[]args){
       word_counter word=new word_counter();
        word.setContentPane(word.panelmain);
       word.setTitle(" WELCOME TO WORD COUNTER");
        word.setBounds(300,300,400,200);
        word.setVisible(true);
        word.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

