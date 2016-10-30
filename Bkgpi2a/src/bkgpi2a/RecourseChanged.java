package bkgpi2a;

import static bkgpi2a.ProviderAssignationPurposeType.RECOURSE_CHANGED;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un changement de recours sur un ticket et le motif.
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 * @see http://performanceimmo.github.io/API/#providerassignationpurpose
 */
@JsonTypeName("RecourseChanged")
public class RecourseChanged extends ProviderAssignationPurpose {

    /**
     * Motif de l'affectation
     */
    private String comment;

    /**
     * Constructeur principal de la classe Purpose
     */
    public RecourseChanged() {
        setProviderAssignationPurposeType(RECOURSE_CHANGED.getName());
    }

    /**
     * @return le motif de l'affectation
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le motif de l'affectation
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Purpose:{"
                + super.toString()
                + ", comment:" + getComment()
                + "}";
    }
}
