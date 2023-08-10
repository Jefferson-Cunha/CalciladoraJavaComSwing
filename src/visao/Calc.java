package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calc extends JFrame {

	public Calc() {

		organizarLayout();
		setSize(275, 335);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Display dpl = new Display();
		dpl.setPreferredSize(new Dimension(145, 60));
		add(dpl, BorderLayout.NORTH);
			
		Teclado tcl = new Teclado();
		add(tcl, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new Calc();
	}

}
