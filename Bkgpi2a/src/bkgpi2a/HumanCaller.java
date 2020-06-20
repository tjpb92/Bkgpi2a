package bkgpi2a;

import static bkgpi2a.CallerType.HUMAN_CALLER;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un appelant humain
 *
 * @author Thierry Baribaud
 * @version 1.34
 * @see <A href="http://performanceimmo.github.io/API/#callertype">CallerType</A>
 */
@JsonTypeName("HumanCaller")
public class HumanCaller extends Caller {

    /**
     * Nom de l'appelant
     */
    private Name name;

    /**
     * Type de medium
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactMedium medium;

    /**
     * Commentaire
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String comment;

    /**
     * Constructeur principal de la classe ReferencedUser
     */
    public HumanCaller() {
        setCallerType(HUMAN_CALLER.getName());
    }

    /**
     * @return le nom de l'appelant
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'appelant
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return le moyen de liaison
     */
    public ContactMedium getMedium() {
        return medium;
    }

    /**
     * @param medium définit le moyen de liaison
     */
    public void setMedium(ContactMedium medium) {
        this.medium = medium;
    }

    /**
     * @return le commentaire
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment définit le commentaire
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "HumanCaller:{"
                + super.toString()
                + ", name:" + getName()
                + ", medium:" + getMedium()
                + ", comment:" + getComment()
                + "}";
    }
}
