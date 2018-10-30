/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mc.tickets.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "AT_TECNICO")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TECNICO_ID")
    Long tecnicoID;
    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String nombre;
    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    String email;
    @OneToMany(mappedBy = "tecnico")
    @JoinColumn(name = "tecnico_id")
    List<Ticket> tickets;
    
    public Tecnico() {
        
    }

    public Tecnico(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    
    
    public Long getTecnicoID() {
        return tecnicoID;
    }

    public void setTecnicoID(Long tecnicoID) {
        this.tecnicoID = tecnicoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}


