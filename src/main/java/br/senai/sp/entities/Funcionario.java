package br.senai.sp.entities;

public class Funcionario {
	private String name;
	private String cpf;
	private String cargo;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String name, String cpf, String cargo) {
		this.name = name;
		this.cpf = cpf;
		this.cargo = cargo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Name: " 
				+ name 
				+ ", CPF: " 
				+ cpf 
				+ ", Cargo: " 
				+ cargo;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass().equals(this.getClass())) {
			Funcionario func = (Funcionario) obj;
			
			return func.getCpf().equals(this.getCpf());
			
		}else {
			return false;
		}
		
		
		 
	}
	
	
	
	
}
