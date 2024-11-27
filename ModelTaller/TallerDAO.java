/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTaller;

import Model.Dao.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Student
 */
public class TallerDAO extends DAO<TallerDTO>{

    public TallerDAO(Connection connection) {
        super(connection);
    }
    
       @Override
    public boolean create(TallerDTO dto) throws SQLException {
        if (dto==null || !validatePK(dto.getCapacidad())){
            return false;
        }
        String query = "Call createTaller(?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getNombre());
            stmt.setInt(3, dto.getCapacidad());
            return stmt.executeUpdate()>0;
        }
    }

       @Override
    public TallerDTO read(Object id) throws SQLException {
        if (id==null || String.valueOf(id).trim().isEmpty()){
            return null;
        }
        String query = "Call ReadTaller(?)";
       try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, String.valueOf(id));
        try(ResultSet rs= stmt.executeQuery()){
            if(rs.next()){
                return new TallerDTO(
                rs.getInt(1),
                rs.getString(2),
                rs.getDate(3),
                rs.getString(4),
                rs.getInt(5)) ;
            }
        }
            
        }
       return null;
    }

     @Override
    public List<TallerDTO> readAll() throws SQLException {
 String query = "Call ReadParticipanteAll(?)";
 List<TallerDTO> list= new ArrayList<>();
       try(PreparedStatement stmt = connection.prepareStatement(query)){
           
      try(ResultSet rs= stmt.executeQuery()){
            while (rs.next()){
                list.add( new TallerDTO(
                rs.getInt(1),
                rs.getString(2),
                rs.getDate(3),
                rs.getString(4),
                rs.getInt(5)));
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
          String query = "Call DeleteTaller(?)";
       try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, String.valueOf(id));
          return stmt.executeUpdate() > 0;
       }
         
    }
    
    
    public boolean validatePK(Object id) throws SQLException{
        return read(id)==null;
    }
  
    
}
