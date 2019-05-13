
<%@page import="java.util.List"%>
<%@page import="alunoPackage.ClassNotas"%>
<%@page import="alunoPackage.ClassDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Alunos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body class="container">
        <br>
        <h1 class="text-center">Lista de Alunos</h1>
        <a class="btn btn-primary" href="index.html" role="button">Voltar</a><br><br>
        <table class="table border text-center">
            <tr>
                <th>Nome</th>
                <th>Disciplina</th>
                <th>Curso</th>
                <th>Nota</th>
            </tr>
                <%
                            
                    ClassDAO dao = new ClassDAO();
                    List<ClassNotas> lista = dao.Select();
                   for(ClassNotas note: lista) {
                      
                    out.print("<tr>");
                    out.print("<td>"+note.getNome_aluno()+"</td>");
                    out.print("<td>"+note.getDisciplina()+"</td>");
                    out.print("<td>"+note.getCurso()+"</td>");
                    out.print("<td>"+note.getNota()+"</td>");   
                    out.print("</tr>");
                      
                }
                
                %>
            
        </table>        
                <a class="btn btn-primary" href="index.html" role="button">Voltar</a><br><br>
    </body>
</html>
