/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelInscripcion;

import ModelParticipante.Participante;
import ModelTaller.Taller;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Student
 */
public class InscripcionDTO {
      private final int id;
   private final Taller taller;
   private final Participante participante;
   private final Date fecha;
   private final boolean asistencia;

    public InscripcionDTO(int id, Taller taller, Participante participante, Date fecha, boolean asistencia) {
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

    public Date getFecha() {
        return fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    } 
}
