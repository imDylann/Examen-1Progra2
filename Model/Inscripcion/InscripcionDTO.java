/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DTO;

import Model.Participante;
import Model.Taller;
import java.time.LocalDate;

/**
 *
 * @author Student
 */
public class InscripcionDTO {
      private final int id;
   private final Taller taller;
   private final Participante participante;
   private final LocalDate fecha;
   private final boolean asistencia;

    public InscripcionDTO(int id, Taller taller, Participante participante, LocalDate fecha, boolean asistencia) {
        this.id = id;
        this.taller = taller;
        this.participante = participante;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    public int getId() {
        return id;
    }

    public Taller getTaller() {
        return taller;
    }

    public Participante getParticipante() {
        return participante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    } 
   
}
