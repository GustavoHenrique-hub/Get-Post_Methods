package br.senai.sp.util;

import java.io.BufferedWriter;
import java.util.List;

import br.senai.sp.entities.Funcionario;

public class Util {
	public String showList(List<Funcionario> lista) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		sb.append("<body>");
		
		sb.append("<h1> Lita de Funcionarios </h1>");
		
		for (Funcionario func : lista) {
			sb.append("<label>Name: " + func.getName() + "</label><br>");

			sb.append("<label>CPF: " + func.getCpf() + "</label><br>");

			sb.append("<label>Cargo: " + func.getCargo() + "</label><br>");

			sb.append("<a href='/Get_Post-Methods/removeFunc?CPF=" + func.getCpf() + "'> Excluir </a><br>");
			
			sb.append("<a href='/Get_Post-Methods/alteraFunc?CPF=" + func.getCpf() + "'> Alterar </a><br>");

			sb.append("<br>");
		}
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
}
