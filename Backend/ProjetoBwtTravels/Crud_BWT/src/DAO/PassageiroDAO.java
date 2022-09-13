
package DAO;

import DTO.PassageiroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class PassageiroDAO {
    
    Connection conn;
   PreparedStatement pstm;
    
    public void cadastrarPassageiro(PassageiroDTO objpassageirodto){
        String sql = "insert into passageiro (nomeCompleto_Passageiro, endereco_Passageiro, cep_Passageiro, email_Passageiro, contato_Passageiro, senha_Passageiro (?, ?, ?, ?, ?,?)";
        
        conn = new ConexaoDAO.createConnectionToMySQL();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpassageirodto.getNomeCompleto_Passageiro());
            pstm.setString(2, objpassageirodto.getEndereco_Passageiro());
            pstm.setString(3, objpassageirodto.getCep_Passageiro());
            pstm.setString(4, objpassageirodto.getEmail_Passageiro());
            pstm.setString(5, objpassageirodto.getContato_Passageiro());
            pstm.setString(6, objpassageirodto.getSenha_Passageiro());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "PassageiroDAO" + erro);
        }
    }
    
}
