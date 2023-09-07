package DTO;

public abstract class Funcionario {

    protected String nomeFuncionario;
    protected String departamentoFuncionario;

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
}
