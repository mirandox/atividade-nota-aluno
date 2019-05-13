
package java.alunoPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Alunos")
public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ClassDAO dao = new ClassDAO();
    ClassNotas nota = new ClassNotas();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           nota.setNome_aluno(request.getParameter("nome"));
           nota.setDisciplina(request.getParameter("disc"));
           nota.setCurso(request.getParameter("curso"));
           nota.setNota(Float.valueOf(request.getParameter("nota")));
           dao.Inserir(nota);
           out.print("<html><head>");
           out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"/>");
           out.print("</head><body class=\"container\">");
           out.print("<br><h3>Aluno cadastro com sucesso!</h3>");
           out.print("<a class=\"btn btn-primary\" href=\"index.html\" role=\"button\">Voltar</a>");
           out.print("</body></html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
