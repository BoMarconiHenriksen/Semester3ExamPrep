/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import entities.EventFacade;
import entities.PetFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ejer
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gson gson = new Gson();
        PetFacade pf = new PetFacade();
        EventFacade ef = new EventFacade();
   System.out.println("pets:  "+(pf.getAllPets()));
//        System.out.println("petCount:  "+gson.toJson(pf.petCount()));
//        System.out.println("eventlist:  " + gson.toJson(ef.getAllEvents()));
//        System.out.println("get events by dogtag: " + gson.toJson(ef.getAllEventsByPetId(3)));
    }

}
