package br.edu.ifpb.pweb2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	private Integer faltas;

	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;

	private BigDecimal notaFinal;

	private Situations situacao;

	public Aluno() {

	}

	public Aluno(String nome, Date dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the faltas
	 */
	public Integer getFaltas() {
		return faltas;
	}

	/**
	 * @param faltas the faltas to set
	 */
	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	/**
	 * @return the nota1
	 */
	public BigDecimal getNota1() {
		return nota1;
	}

	/**
	 * @param nota1 the nota1 to set
	 */
	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	/**
	 * @return the nota2
	 */
	public BigDecimal getNota2() {
		return nota2;
	}

	/**
	 * @param nota2 the nota2 to set
	 */
	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	/**
	 * @return the nota3
	 */
	public BigDecimal getNota3() {
		return nota3;
	}

	/**
	 * @param nota3 the nota3 to set
	 */
	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	/**
	 * @return the notaFinal
	 */
	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	/**
	 * @param notaFinal the notaFinal to set
	 */
	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}

	/**
	 * @return the situacao
	 */
	public Situations getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(Situations situacao) {
		this.situacao = situacao;
	}

}
