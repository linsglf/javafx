package DTO;

public class FuncionarioDTO {
	
	private String nomeFuncionario,
			departamentoFuncionario;
	private int idFuncionario;
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getDepartamentoFuncionario() {
		return departamentoFuncionario;
	}

	public void setDepartamentoFuncionario(String departamentoFuncionario) {
		this.departamentoFuncionario = departamentoFuncionario;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}
