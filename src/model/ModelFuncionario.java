package model;

import java.io.Serializable;

public class ModelFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Integer matricula;
	private String profissao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
