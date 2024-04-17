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

@WebServlet("/novoFuncGet")
public class NovoFuncGet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = res.getWriter();

		try {

			String name = req.getParameter("NAME");
			String cpf = req.getParameter("CPF");
			String cargo = req.getParameter("CARGO");

			Funcionario func1 = new Funcionario(name, cpf, cargo);

			List<Funcionario> lista = null;

			HttpSession session = req.getSession();

			Object obj = session.getAttribute("listaFunc");

			if (obj == null) {
				lista = new ArrayList<>();
				lista.add(func1);

				session.setAttribute("listaFunc", lista);
			} else {
				lista = (ArrayList<Funcionario>) obj;
				lista.add(func1);

				session.setAttribute("listaFunc", lista);
			}

			Util util = new Util();
			pw.append(util.showList(lista));

		} catch (NullPointerException e) {
			pw.append("<html>");
			pw.append("<body>");

			pw.append("<h1>Name: " + e.getMessage() + "</h1><br>");

			pw.append("</body>");
			pw.append("</html>");
		} finally {
			if (pw != null) {
				pw.close();

			}
		}

	}

}
