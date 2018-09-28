package bkgpi2a;

import static bkgpi2a.AssigneeType.ANONYMOUS_ASSIGNEE;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe décrivant un individu non référencé
 *
 * @author Thierry Baribaud
 * @version 0.48
 * @see http://performanceimmo.github.io/API/...
 */
@JsonTypeName("AnonymousAssignee")
@JsonPropertyOrder({"name", "phones", "fax", "emails", "assigneeType"})
public class AnonymousAssignee extends Assignee {

    /**
     * Nom de l'individu
     */
    private Name name;

    /**
     * Liste de téléphone pour joindre l'individu
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Liste de numéros de fax pour joindre l'individu
     */
    @JsonUnwrapped
    private FaxList fax;

    /**
     * Liste de emails pour joindre l'individu
     */
    @JsonUnwrapped
    private EmailList emails;

    /**
     * Constructeur principal de la classe AnonymousAssignee
     */
    public AnonymousAssignee() {
        setAssigneeType(ANONYMOUS_ASSIGNEE.getName());
    }

    /**
     * @return le nom de l'individu
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name définit le nom de l'individu
     */
    public void setName(Name name) {
        this.name = name;
    }


    /**
     * @return la liste des numéros de téléphone pour contacter l'individu
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones définit la liste des numéros de téléphone pour contacter
     * l'individu
     */
    public void setPhones(PhoneList phones) {
        this.phones = phones;
    }

    /**
     * @return une liste de numéros de fax
     */
    public FaxList getFax() {
        return fax;
    }

    /**
     * @param fax définit une liste de numéros de fax.
     */
    public void setFax(FaxList fax) {
        this.fax = fax;
    }

    /**
     * @return la liste des mails pour contacter l'individu
     */
    public EmailList getEmails() {
        return emails;
    }

    /**
     * @param emails définit la liste des mails pour contacter l'individu
     */
    public void setEmails(EmailList emails) {
        this.emails = emails;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "AnonymousAssignee:{"
                + super.toString()
                + ", name:" + getName()
                + ", phones:" + getPhones()
                + ", fax:" + getFax()
                + ", emails:" + getEmails()
                + "}";
    }
}
