
// tp JPA

package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        EntityManager em = emf.createEntityManager();

        // Connexion réussie
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("Connexion réussie !");

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Échec de la connexion !");
        }
          finally
        {
            // Fermer les ressources

            em.close();
            emf.close();
        }
    }
}
