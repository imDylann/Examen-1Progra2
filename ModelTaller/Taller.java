/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelTaller;

import java.time.LocalDate;

/**
 *
 * @author Student
 */
public class Taller {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private int capacidad;

    public Taller(int id, String nombre, LocalDate fecha, String lugar, int capacidad) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Taller{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", capacidad=" + capacidad + '}';
    }
    
    
}
