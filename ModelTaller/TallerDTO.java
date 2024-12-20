/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTaller;

import java.time.LocalDate;
import java.util.Date;
//import java.sql.Date;

/**
 *
 * @author Student
 */
public class TallerDTO {
   private final int id;
    private final String nombre;
    private final Date fecha;
    private final String lugar;
    private final int capacidad;

    public TallerDTO(int id, String nombre, Date fecha, String lugar, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public int getCapacidad() {
        return capacidad;
    }

  
       
}
