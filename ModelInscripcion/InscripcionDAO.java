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


/**
 *
 * @author Student
 */
import java.sql.Date;
import java.util.ArrayList;
public class InscripcionDAO extends DAO {

    public InscripcionDAO(Connection connection){
        super(connection);
    }
    
    public boolean create(InscripcionDTO dto) throws SQLException {
        if(dto == null || !validatePK(dto.getId())){
            return false;
        }
        String query = "Call CreateInscripcion(?,?,?,?)";
        try( PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getTaller().getId());
            stmt.setString(2, dto.getParticipante().getCedula() );
            stmt.setDate(3, (Date) dto.getFecha());
            stmt.setBoolean(4, dto.isAsistencia());
            return stmt.executeUpdate()>0;
        }
    }
    

    @Override
    public Object read(Object id) throws SQLException {
           if(id == null || String.valueOf(id).trim().isEmpty()){
            return false;
        }
        String query = "Call ReadInscripcionforID(?)";
        try( PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, (int) id);
            
        }
    return null;
    }

    @Override
    public List readAll() throws SQLException {
        String query = "Call ReadInscripcionAll()";
        List<InscripcionDTO> list = new ArrayList<>();
        
        try( PreparedStatement stmt = connection.prepareStatement(query)){
          while()
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean validatePK(Object id)throws SQLException {
        return read(id) == null;
    }
    
}
