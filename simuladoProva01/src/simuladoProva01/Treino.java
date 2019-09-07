package simuladoProva01;

public class Treino {

	private double distancia;
	private int tempoEsperado;
	private String descricao;
	private String status;
	private int tempoGasto;
	private int resistencia;

	public Treino(double distancia, int tempoEsperado, String descricao) {
		this.distancia = distancia;
		this.tempoEsperado = tempoEsperado;
		this.descricao = descricao;
		this.status = "nao iniciado";
		this.tempoGasto = 0;
		this.resistencia = 0;
	}

	public void finalizarTreino(int tempoGasto) {
		this.tempoGasto = tempoGasto;
		this.status = "terminado";
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int GetResistencia() {
		if ("terminado".equals(status)) {
			if(this.tempoEsperado > this.tempoGasto) {
				return 1;	
			}
			if(this.tempoEsperado < this.tempoGasto) {
				return -1;	
			}
			if(this.tempoEsperado == this.tempoGasto) {
				return 0;	
			}
			
		}
		return resistencia;
	}
	
	public String toString() {
		return this.distancia + "km - " + this.tempoEsperado + " - " + this.descricao;
	}

}
