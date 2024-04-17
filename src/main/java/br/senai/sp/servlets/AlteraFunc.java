package br.senai.sp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.entities.Funcionario;
import br.senai.sp.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/alteraFunc")
public class AlteraFunc extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();

		String cpf = req.getParameter("CPF");

		Funcionario func1 = new Funcionario();
		func1.setCpf(cpf);

		List<Funcionario> lista = null;

		HttpSession session = req.getSession();

		Object obj = session.getAttribute("listaFunc");

		if (obj != null) {
			lista = (ArrayList<Funcionario>) obj;

			int posicao = lista.indexOf(func1);
			
			if(posicao >= 0) {
				func1 = lista.get(posicao);
			}
		}

		pw.append("<!DOCTYPE html>");
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset='ISO-8859-1'>");
		pw.append("<title>Novo funcionario</title>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<form action='/Get_Post-Methods/alteraFunc' method='post'>");
		pw.append("<label for='NAME'>NAME: </label>");
		pw.append("<input type='text' name='NAME' value='"+ func1.getName()+"' >");
		pw.append("<label for='CPF'>CPF: </label>");
		pw.append("<input type='text' name='CPF' value='"+ func1.getCpf()+"'>");
		pw.append("<label for='CARGO'>CARGO: </label>");
		pw.append("<select name='CARGO'>");
		pw.append("<option value='Analista'>Analista</option>");
		pw.append("<option value='Programador'>Programador</option>");
		pw.append("<option value='Gerente'>Gerente</option>");
		pw.append("</select>");
		pw.append("<input type='submit' value='Gravar'>");
		pw.append("</form>");
		pw.append("</body>");
		pw.append("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("NAME");
		String cpf = req.getParameter("CPF");
		String cargo = req.getParameter("CARGO");

		Funcionario func1 = new Funcionario(name, cpf, cargo);

		List<Funcionario> lista = null;

		HttpSession session = req.getSession();

		Object obj = session.getAttribute("listaFunc");
		
		if (obj != null) {
			lista = (ArrayList<Funcionario>) obj;

			int posicao = lista.indexOf(func1);
			
			if(posicao >= 0) {
				lista.set(posicao, func1);
			}
		}
		
		Util util = new Util();
		pw.append(util.showList(lista));
	}

}
