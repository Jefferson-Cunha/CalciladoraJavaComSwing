package visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private final Color CINZA_ESCURO = new Color(68, 68, 68);
	private final Color CINZA_CLARO = new Color(97, 100, 99);
	private final Color LARANJA = new Color(242, 163, 60);

	public Teclado() {
		GridBagLayout lt = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		setLayout(lt);

		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;

		// Linha 1

		c.gridwidth = 2;
		adcBotao("AC", CINZA_ESCURO, c, 0, 0);
		c.gridwidth = 1;
		adcBotao("±", CINZA_ESCURO, c, 2, 0);
		adcBotao("/", LARANJA, c, 3, 0);

		// Linha 2
		adcBotao("7", CINZA_CLARO, c, 0, 1);
		adcBotao("8", CINZA_CLARO, c, 1, 1);
		adcBotao("9", CINZA_CLARO, c, 2, 1);
		adcBotao("*", LARANJA, c, 3, 1);

		// Linha 3
		adcBotao("4", CINZA_CLARO, c, 0, 2);
		adcBotao("5", CINZA_CLARO, c, 1, 2);
		adcBotao("6", CINZA_CLARO, c, 2, 2);
		adcBotao("-", LARANJA, c, 3, 2);

		// Linha 4
		adcBotao("1", CINZA_CLARO, c, 0, 3);
		adcBotao("2", CINZA_CLARO, c, 1, 3);
		adcBotao("3", CINZA_CLARO, c, 2, 3);
		adcBotao("+", LARANJA, c, 3, 3);

		// Linha 5

		c.gridwidth = 2;
		adcBotao("0", CINZA_CLARO, c, 0, 4);
		c.gridwidth = 1;
		adcBotao(",", CINZA_CLARO, c, 2, 4);
		adcBotao("=", LARANJA, c, 3, 4);

	}

	private void adcBotao(String txt, Color cor, GridBagConstraints c, int x, int y) {

		c.gridx = x;
		c.gridy = y;
		Botao bt = new Botao(txt, cor);
		bt.addActionListener(this);
		add(bt, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			Memoria.getInstancia().precessarCmt(bt.getText());
		}

	}

}
