/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelParticipante;

import Model.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author JosilloPillo
 */
public class ParticipanteMapper implements Mapper<Participante, ParticipanteDTO> {

    @Override
    public ParticipanteDTO toDto(Participante ent) {
        return new ParticipanteDTO(
                ent.getCedula(),
                ent.getNombre(),
                ent.getTelefono(),
                ent.getCorreo()
        );
    }

    @Override
    public Participante toEnt(ParticipanteDTO dto) throws SQLException {
        return new Participante(
                dto.getCedula(),
                dto.getNombre(),
                dto.getTelefono(),
                dto.getCorreo()
        );

    }

}
