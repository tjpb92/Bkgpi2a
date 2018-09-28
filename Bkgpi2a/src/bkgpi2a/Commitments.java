package bkgpi2a;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant une liste d'engagements contractuels
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see https://github.com/PerformanceIMMO/perfimmo-front/issues/275
 */
public class Commitments {

    /**
     * Liste d'engagements contractuels
     */
    private List<Commitment> commitments;

    /**
     * Contractueur de la classe Commitments
     */
    public Commitments() {
        this.commitments = new ArrayList();
    }

    /**
     * Ajoute un engagement contractuel à la liste
     * @param commitment engagement contractuel à ajouter
     */
    public void add(Commitment commitment) {
        this.commitments.add(commitment);
    }
    
    /**
     * Retourne la liste des engagements contractuels
     *
     * @return la liste des engagements contractuels
     */
    public List<Commitment> getCommitments() {
        return commitments;
    }

    /**
     * Définit la liste des engagements contractuels
     *
     * @param commitments la liste des engagements contractuels
     */
    public void setCommitments(List<Commitment> commitments) {
        this.commitments = commitments;
    }

    @Override
    public String toString() {
        return "Commitments{"
                + "commitments=" + commitments
                + '}';
    }

}
