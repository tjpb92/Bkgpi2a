package bkgpi2a;

import static bkgpi2a.NameType.CIVIL_NAME;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant un nom qualifi�
 *
 * @author Thierry Baribaud
 * @version 1.18
 */
@JsonTypeName("CivilName")
public class CivilName extends Name {

    /**
     * Genre
     */
    private String gender;

    /**
     * Nom propre
     */
    private String lastName;

    /**
     * Pr�nom
     */
    private String firstName;

    /**
     * Soci�t� (optionnel)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String company;

    /**
     * @return le genre
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender d�finit le genre
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Constructeur principal de la classe CivilName
     */
    public CivilName() {
        setNameType(CIVIL_NAME.getName());
    }

    /**
     * @return le nom propre
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName d�finit le nom propre
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le pr�nom
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName d�finit le pr�nom
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return la soci�t�
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company d�finit la soci�t�
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "CivilName:{"
                + super.toString()
                + ", gender:" + getGender()
                + ", lastName:" + getLastName()
                + ", firstName:" + getFirstName()
                + ", company:" + getCompany()
                + "}";
    }
}
