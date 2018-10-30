/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mc.tickets;

import gt.com.mc.tickets.model.Tecnico;
import gt.com.mc.tickets.model.Ticket;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author programacion
 */
public class PruebaTicket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Ticket ticket = new Ticket("Navegacion", "No puedo ingresar a pagina de Banguat", new Date(), "C");
        tx.begin();
        //Todo lo que se encuentra aca esta dentro de la transaccion
        //INSERT
        em.persist(ticket);
        
        //Asignar ticket a tecnico
        //UPDATE
        Tecnico tecnico = new Tecnico("Malco Chacon", "malcochacon@kinal.org.gt");
        //em.persist(tecnico);
        //ticket.setTecnicoId(1L);
        ticket.setTecnico(tecnico);
        ticket.setEstado("A");
       
        //Eliminar de base de datos
        //DELETE
        //em.remove(ticket);
        
        tx.commit();
        
        System.out.println("Transaccion ejecutada");
        em.close();
        emf.close();
    }
            
}
