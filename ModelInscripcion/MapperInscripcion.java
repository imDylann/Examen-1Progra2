/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelInscripcion;

import Model.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author Student
 */
public class MapperInscripcion implements Mapper <Inscripcion, InscripcionDTO> {

    @Override
    public InscripcionDTO toDto(Inscripcion ent) {
        return new InscripcionDTO(
                ent.getId(),
                ent.getTaller(),
                ent.getParticipante(),
                ent.getFecha(),
                ent.isAsistencia()
        );
    }

    @Override
    public Inscripcion toEnt(InscripcionDTO dto) throws SQLException {
        return new Inscripcion(
                dto.getId(),
                dto.getTaller(),
                dto.getParticipante(),
                dto.getFecha(),
                dto.isAsistencia()
        );
        
        
    }
    
}
