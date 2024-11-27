/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelParticipante;

import Model.Dao.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Student
 */
public class ParticipanteDAO extends DAO<ParticipanteDTO> {

    public ParticipanteDAO(Connection connection) {
        super(connection);
    }

       @Override
    public boolean create(ParticipanteDTO dto) throws SQLException {
        if (dto==null || !validatePK(dto.getCedula())){
            return false;
        }
        String query = "Call createParticipante(?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getNombre());
            stmt.setInt(3, dto.getTelefono());
            stmt.setString(5, dto.getCorreo());
            return stmt.executeUpdate()>0;
        }
    }

       @Override
    public ParticipanteDTO read(Object id) throws SQLException {
        if (id==null || String.valueOf(id).trim().isEmpty()){
            return null;
        }
        String query = "Call ReadParticipante(?)";
       try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, String.valueOf(id));
        try(ResultSet rs= stmt.executeQuery()){
            if(rs.next()){
                return new ParticipanteDTO(
                rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4));
            }
        }
            
        }
       return null;
    }

     @Override
    public List<ParticipanteDTO> readAll() throws SQLException {
 String query = "Call ReadParticipanteAll(?)";
 List<ParticipanteDTO> list= new ArrayList<>();
       try(PreparedStatement stmt = connection.prepareStatement(query)){
           
      try(ResultSet rs= stmt.executeQuery()){
            while (rs.next()){
                list.add( new ParticipanteDTO(
                rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4)));
            }
        }
          return list;          
    }
    }

    
   
       @Override
    public boolean delete(Object id) throws SQLException {
         if (id==null || String.valueOf(id).trim().isEmpty()){
           return false;
         }
          String query = "Call DeleteParticipante(?)";
       try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, String.valueOf(id));
          return stmt.executeUpdate() > 0;
       }
         
    }
    
    
    public boolean validatePK(Object id) throws SQLException{
        return read(id)==null;
    }
  
}
