/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Mapper;
import java.sql.SQLException;
/**
 *
 * @author tilin
 */
public interface Mapper <Ent, DTO> {
    public DTO toDto (Ent, ent);
    public Ent toEnt (DTO, dto) throw SQLException;
}
