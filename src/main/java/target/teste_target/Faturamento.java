package target.teste_target;

public class Faturamento {
	
	private Integer dia;
	private Double valor;
	
	public Faturamento() {
		
	}

	public Faturamento(Integer dia, Double valor) {
		this.dia = dia;
		this.valor = valor;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Faturamento [dia=" + dia + ", valor=" + valor + "]";
	}
	
	
	
}
