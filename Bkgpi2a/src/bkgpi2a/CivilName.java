package bkgpi2a;

import static bkgpi2a.NameType.CIVIL_NAME;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un nom qualifié
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
     * Prénom
     */
    private String firstName;

    /**
     * Société (optionnel)
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
     * @param gender définit le genre
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
     * @param lastName définit le nom propre
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return le prénom
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName définit le prénom
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return la société
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company définit la société
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
