/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.alunoPackage;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClassDAO {
    public ClassDAO() {
    }
    
    public static Connection con = null;
     public static boolean Conectar() {
        System.out.println("Conectando...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/atividade", "root","");
            System.out.println("Conectado!");
            return true;
        } catch (ClassNotFoundException ex) {
             System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
             Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE,null,ex);
             return false;  
        } catch (SQLException e) {
             System.out.println(e);
             throw new RuntimeException(e);
        }
    }
     public static boolean FecharConexao() {
        try {
            ClassDAO.con.close();
            return true;
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
        }
    }
     
    
     public boolean Inserir(ClassNotas nt) {
         try {
            Conectar();
            PreparedStatement prepared = con.prepareStatement("INSERT INTO notas(nome_aluno,disciplina,curso,nota) VALUES(?,?,?,?)");
            int i = 0;
            prepared.setString(++i, nt.getNome_aluno());
            prepared.setString(++i, nt.getDisciplina());
            prepared.setString(++i, nt.getCurso());
            prepared.setString(++i, String.valueOf(nt.getNota()));
            prepared.execute();
            FecharConexao();
            return true;
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
        }
     }
     
     public List<ClassNotas> Select() {
         List<ClassNotas> lista = new ArrayList();
         try {
             
             Conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM notas");
             while(rs.next()) {
                 
                 ClassNotas nota = new ClassNotas();
                 nota.setNome_aluno(rs.getString(1));
                 nota.setDisciplina(rs.getString(2));
                 nota.setCurso(rs.getString(3));
                 nota.setNota(rs.getFloat(4));
                 lista.add(nota);
             }
             FecharConexao();
         }  catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
           return null;
        }
         return lista;
     }
}
