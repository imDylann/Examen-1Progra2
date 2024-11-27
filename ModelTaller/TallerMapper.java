/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTaller;

import Model.Mapper.Mapper;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Student
 */
public class TallerMapper implements Mapper<Taller, TallerDTO> {

    @Override
    public TallerDTO toDto(Taller ent) {
        return new TallerDTO(
                ent.getId(),
                ent.getNombre(),
                ent.getFecha(),
                ent.getLugar(),
                ent.getCapacidad()
        );

    }

    @Override
    public Taller toEnt(TallerDTO dto) throws SQLException {
        return new Taller(
                dto.getId(),
                dto.getNombre(),
                dto.getFecha(),
                dto.getLugar(),
                dto.getCapacidad()
        );
    }

}
