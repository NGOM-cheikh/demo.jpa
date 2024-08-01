
// tp jpa 3 & 4

package fr.diginamic;

import fr.diginamic.entities.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static fr.diginamic.entities.Emprunt.*;

public class App {
  public static void main(String[] args) {

    try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-biblio");
       EntityManager em = emf.createEntityManager()) {

       Emprunt emprunt = em.find(Emprunt.class, 2);
       if (null != emprunt ) {
           System.out.println(Emprunt.getLivres());
       }
    }
  }
}
