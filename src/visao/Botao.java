package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton {

	
	
	public Botao(String label, Color cor){
		setText(label);
		setFont(new Font("courier", Font.PLAIN, 15));
		setOpaque(true);
		setBackground(cor);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setForeground(Color.WHITE);
	}
	
	
}
