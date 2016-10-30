package bkgpi2a;

import static bkgpi2a.ProviderAssignationPurposeType.PURPOSE;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant une affectation d'un intervenant � un ticket et le motif.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#providerassignationpurpose
 */
@JsonTypeName("Purpose")
public class Purpose extends ProviderAssignationPurpose {

    /**
     * Motif de l'affectation
     */
    private String purpose;

    /**
     * Constructeur principal de la classe Purpose
     */
    public Purpose() {
        setProviderAssignationPurposeType(PURPOSE.getName());
    }

    /**
     * @return le motif de l'affectation
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose d�finit le motif de l'affectation
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Purpose:{"
                + super.toString()
                + ", purpose:" + getPurpose()
                + "}";
    }
}
