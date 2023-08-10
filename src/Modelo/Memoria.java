package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> obs = new ArrayList<>();
	private String txtAtual = "";
	private String txtBuffer = "";
	private Boolean substituir = false;
	private tpComando ultimaOp = null;

	private enum tpComando {
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA
	};

	private Memoria() {
	}

	public String getTxtAtual() {
		return txtAtual.isEmpty() ? "0" : txtAtual;
	}

	public void setTxtAtual(String txtAtual) {
		this.txtAtual = txtAtual;
	}

	public static Memoria getInstancia() {
		return instancia;
	}

	public void AdicionarObs(MemoriaObservador o) {
		obs.add(o);
	}

	public void precessarCmt(String txt) {

		tpComando tpCmd = detectarTipoComando(txt);

		System.out.println(tpCmd);

		if (tpCmd == null) {
			return;
		}else if (tpCmd == tpComando.ZERAR) {
			txtAtual = "";
			substituir = false;
		}else if (tpCmd == tpComando.NUMERO || tpCmd == tpComando.VIRGULA) {
			txtAtual = substituir ? txt : txtAtual + txt;

		}else {
			substituir = true;
			txtAtual = obterResultadoOp();
			txtBuffer = txtAtual;
			ultimaOp = tpCmd;
			
		}
		
		
		
		obs.forEach(o -> o.valorAlterado(getTxtAtual()));
	}

	private String obterResultadoOp() {
		if(ultimaOp == null || ultimaOp == tpComando.IGUAL) {
			return txtAtual;
		}
		
		double numBuffer = Double.parseDouble(txtBuffer.replace(",", "."));
		double numAtual = Double.parseDouble(txtAtual.replace(",", "."));
		double resultado = 0;
		
		if(ultimaOp == tpComando.SOMA) {
			resultado = numBuffer + numAtual;
		} else if(ultimaOp == tpComando.SUB) {
			resultado = numBuffer - numAtual;
		} else if (ultimaOp == tpComando.MULT) {
			resultado = numBuffer * numAtual;
		} else if(ultimaOp == tpComando.DIV) {
			resultado = numBuffer / numAtual;
		}
		
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		
		boolean inteiro = resultadoString.endsWith(",0");
		
		return inteiro ? resultadoString.replace(",0", "") : resultadoString;
	}

	private tpComando detectarTipoComando(String txt) {
		if (txtAtual.isEmpty() && txt == "0") {
			return null;
		}

		try {

			Integer.parseInt(txt);
			return tpComando.NUMERO;

		} catch (NumberFormatException e) {

			// Quando não for número

			if ("AC".equals(txt)) {
				return tpComando.ZERAR;
			} 
			else if ("/".equals(txt)) {
				return tpComando.DIV;
			} 
			else if ("*".equals(txt)) {
				return tpComando.MULT;
			} 
			else if ("+".equals(txt)) {
				return tpComando.SOMA;
			} 
			else if ("-".equals(txt)) {
				return tpComando.SUB;
			} 
			else if ("=".equals(txt)) {
				return tpComando.IGUAL;
			} 
			else if (",".equals(txt) && !txtAtual.contains(",")) {
				return tpComando.VIRGULA;
			}
		}

		return null;
	}

}
