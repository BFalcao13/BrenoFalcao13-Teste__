package com.example.validacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Cliente {

	@NotBlank(message = "nome deve ser informado")
	private String Nome;

	@NotBlank(message = "cpf deve ser informado")
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3} -\\d{2}", message = "Cpf deve estar no formato XXX.XXX.XXX-XX")
	private String cpf;

	// Construtor
	public Cliente(String nome, String cpf, double saldoInicial) {
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldoInicial;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void getSaldo() {
		return saldo;
	}

	public void getSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String depositar(double valor) {
		if (valor > 30) {
			saldo += valor;
			return "Depósito realizado com sucesso!";
		} else {
			return "Valor mínimo para depósito é 30 reais!";
		}
	}

	public String sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			return "Saque realizado com sucesso!";
		} else {
			return "Saldo insuficiente!";
		}
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				'}';
	}
}