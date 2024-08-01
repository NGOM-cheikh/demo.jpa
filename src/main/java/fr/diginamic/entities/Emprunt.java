
// tp jpa 3 & 4
package fr.diginamic.entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "DATE DEBUT")
    private LocalDate dateDebut;
    @Column(name = "DATEFIN")
    private LocalDate dateFin;
    @Column(name = "DELAI")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;


    @ManyToMany
    @JoinTable(
            name = "compo",
                joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private static Set<Livre> livres;

    {
        livres = new HashSet<>();
    }

        // Constructeurs, getters et setters

    public Emprunt() {

    }

    public Emprunt(int id, LocalDate dateDebut, LocalDate dateFin, int delai, Client client) {
            this.id = id;
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
            this.delai = delai;
            this.client = client;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public LocalDate getDateDebut() {
            return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
            this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
            return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
            this.dateFin = dateFin;
    }

    public int getDelai() {
            return delai;
    }

    public void setDelai(int delai) {
            this.delai = delai;
    }

    public Client getClient() {
            return client;
    }

    public void setClient(Client client) {
            this.client = client;
    }

    public static Set<Livre> getLivres() {
            return livres;
    }

    public void setLivres(Set<Livre> livres) {
            this.livres = livres;
    }

    @Override
    public String toString() {
            final StringBuffer sb = new StringBuffer("Emprunt{");
            sb.append("id=").append(id);
            sb.append(", dateDebut=").append(dateDebut);
            sb.append(", dateFin=").append(dateFin);
            sb.append(", delai=").append(delai);
            sb.append(", client=").append(client);
            sb.append('}');
            return sb.toString();
    }


}
