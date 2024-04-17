package br.senai.sp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.entities.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/novoFunc")
public class NovoFunc extends HttpServlet {

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

			pw.append("<html>");
			pw.append("<body>");

			for (Funcionario func : lista) {
				pw.append("<label>Name: " + func.getName() + "</label><br>");

				pw.append("<label>CPF: " + func.getCpf() + "</label><br>");

				pw.append("<label>Cargo: " + func.getCargo() + "</label><br>");
				pw.append("<br>");
			}
			pw.append("</body>");
			pw.append("</html>");

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

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = res.getWriter();

		try {
			String name = req.getParameter("NAME");
			String cpf = req.getParameter("CPF");
			String cargo = req.getParameter("CARGO");

			Funcionario func1 = new Funcionario(name, cpf, cargo);

			pw.append("<html>");
			pw.append("<body>");

			pw.append("<label>Name: " + func1.getName() + "</label><br>");

			pw.append("<label>CPF: " + func1.getCpf() + "</label><br>");

			pw.append("<label>Cargo: " + func1.getCargo() + "</label><br>");

			pw.append("</body>");
			pw.append("</html>");
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
