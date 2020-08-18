package bkgpi2a;

import static bkgpi2a.TicketAssigneeType.ANONYMOUS_ASSIGNEE;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Classe d�crivant un individu non r�f�renc�
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see <A href="http://performanceimmo.github.io/API/#assigneetype">AnonymousAssignee</A>
 */
@JsonTypeName("AnonymousAssignee")
@JsonPropertyOrder({"name", "phones", "fax", "emails", "tiketAssigneeType"})
public class AnonymousAssignee extends TicketAssignee {

    /**
     * Nom de l'individu
     */
    private Name name;

    /**
     * Liste de t�l�phone pour joindre l'individu
     */
    @JsonUnwrapped
    private PhoneList phones;

    /**
     * Liste de num�ros de fax pour joindre l'individu
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
        setTicketAssigneeType(ANONYMOUS_ASSIGNEE.getName());
    }

    /**
     * @return le nom de l'individu
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name d�finit le nom de l'individu
     */
    public void setName(Name name) {
        this.name = name;
    }


    /**
     * @return la liste des num�ros de t�l�phone pour contacter l'individu
     */
    public PhoneList getPhones() {
        return phones;
    }

    /**
     * @param phones d�finit la liste des num�ros de t�l�phone pour contacter
     * l'individu
     */
    public void setPhones(PhoneList phones) {
        this.phones = phones;
    }

    /**
     * @return une liste de num�ros de fax
     */
    public FaxList getFax() {
        return fax;
    }

    /**
     * @param fax d�finit une liste de num�ros de fax.
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
     * @param emails d�finit la liste des mails pour contacter l'individu
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