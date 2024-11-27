/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelInscripcion;

import Model.Dao.DAO;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Student
 */
import java.sql.Date;
import java.util.ArrayList;
public class InscripcionDAO extends DAO<InscripcionDTO> {

    public InscripcionDAO(Connection connection){
        super(connection);
    }
    
    @Override
    public boolean create(InscripcionDTO dto) throws SQLException {
        if(dto == null || !validatePK(dto.getId())){
            return false;
        }
        String query = "Call CreateInscripcion(?,?,?,?)";
        try( PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getTaller());
            stmt.setString(2, dto.getParticipante());
            stmt.setDate(3, (Date) dto.getFecha());
            stmt.setBoolean(4, dto.isAsistencia());
            return stmt.executeUpdate()>0;
        }
    }
    

    @Override
    public InscripcionDTO read(Object id) throws SQLException {
           if(id == null || String.valueOf(id).trim().isEmpty()){
            return null;
        }
        String query = "Call ReadInscripcionforID(?)";
        try( PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, (int) id);
          try( ResultSet rs = stmt.executeQuery()){
              if(rs.next()){
                  return new InscripcionDTO(
                  rs.getInt(1),
                  rs.getInt(2) ,
                  rs.getString(3),
                  rs.getDate(4),
                  rs.getBoolean(5)
                  );
              }
          }
            
        }
    return null;
    }

    @Override
    public List readAll() throws SQLException {
        String query = "Call ReadInscripcionAll()";
        List<InscripcionDTO> list = new ArrayList<>();
        try( PreparedStatement stmt = connection.prepareStatement(query)){
         try(ResultSet rs = stmt.executeQuery()){
             list.add(new InscripcionDTO(
             rs.getInt(1),
             rs.getInt(2),
             rs.getString(3),
             rs.getDate(4),
             rs.getBoolean(5)        
              ));
         }
        }
        return list;
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if(id == null || (int)id == 0){
            return false;
        }
        String query = "Call DeleteInscripcion";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, (int) id);
            return stmt.executeUpdate()>0;
        }
    }

    public boolean validatePK(Object id)throws SQLException {
        return read(id) == null;
    }
    
}
