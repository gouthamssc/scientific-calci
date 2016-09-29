import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Fraction {
	private int numerator, denominator;
	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fraction window = new Fraction();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String toString(Fraction x){
		return x.getNumerator() +"/" +x.getDenominator();
	}

	private int getDenominator() {
		// TODO Auto-generated method stub
		return denominator;
	}
	private int getNumerator() {
		// TODO Auto-generated method stub
		return numerator;
	}
	/**
	 * Create the application.
	 */
	public Fraction(int n, int d){
		numerator=n; denominator=d;
	}
	public Fraction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private Fraction toFraction(String text) {
		int pos= text.indexOf("/");
		String s1= text.substring(0,pos);
		String s2= text.substring(pos+1);
		int numerator=Integer.parseInt(s1);
		int denominator= Integer.parseInt(s2);
		return (new Fraction(numerator, denominator));
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(106, 11, 86, 20);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		JButton btnNewButton_2 = new JButton("Multiply");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fraction f1= toFraction(textField1.getText());
				Fraction f2= toFraction(textField2.getText());
				textField3.setText(f1.toString(f1.multF(f2)));
			}
		});
		btnNewButton_2.setBounds(335, 10, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Divide");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fraction f1= toFraction(textField1.getText());
				Fraction f2= toFraction(textField2.getText());
				textField3.setText(f1.toString((Fraction) f1.divF(f2)));

			}
		});
		btnNewButton_3.setBounds(236, 10, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Subtract");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fraction f1= toFraction(textField1.getText());
				Fraction f2= toFraction(textField2.getText());
				textField3.setText(f1.toString(f1.subF(f2)));
			}
		});
		btnNewButton_4.setBounds(236, 42, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fraction f1= toFraction(textField1.getText());
				Fraction f2= toFraction(textField2.getText());
				textField3.setText(f1.toString(f1.addF(f2)));
			}
		});
		btnNewButton_5.setBounds(335, 42, 89, 23);
		frame.getContentPane().add(btnNewButton_5);

		JLabel lblAnswerIs = new JLabel("Answer is: ");
		lblAnswerIs.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAnswerIs.setBounds(117, 189, 75, 31);
		frame.getContentPane().add(lblAnswerIs);

		textField3 = new JTextField();
		textField3.setBounds(236, 181, 175, 52);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);
	}
	protected Fraction addF(Fraction f2) {
		if (this.getDenominator()==f2.getDenominator()){
			numerator= this.getNumerator()+f2.getNumerator();
		}
		else {
			numerator=(this.getNumerator()*f2.getDenominator())+(f2.getNumerator()*this.getDenominator());
			denominator= this.getDenominator()*f2.getDenominator();
		}
		return (new Fraction(numerator, denominator));
	}
	protected Fraction subF(Fraction f2) {
		if (this.getDenominator()==f2.getDenominator()){
			numerator= this.getNumerator()-f2.getNumerator();
		}
		else {
			numerator=(this.getNumerator()*f2.getDenominator())-(f2.getNumerator()*this.getDenominator());
			denominator= this.getDenominator()*f2.getDenominator();
		}
		return (new Fraction(numerator, denominator));
	}
	protected Object divF(Fraction f2) {
		numerator= this.getNumerator()*f2.getDenominator();
		denominator= this.getDenominator()* f2.getNumerator();
		return (new Fraction(numerator, denominator));
	}
	public Fraction multF(Fraction f2) {
		numerator=this.getNumerator()*f2.getNumerator();
		denominator= this.getDenominator()*f2.getDenominator();
		return (new Fraction(numerator,denominator));
	}
}
