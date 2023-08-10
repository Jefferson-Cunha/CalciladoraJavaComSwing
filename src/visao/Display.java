package visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Memoria;
import Modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {

	private final JLabel label;

	public Display() {
		Memoria.getInstancia().AdicionarObs(this);

		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memoria.getInstancia().getTxtAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Serif", Font.PLAIN, 30));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));

		add(label);
	}

	@Override
	public void valorAlterado(String valor) {
		label.setText(valor);

	}

}
