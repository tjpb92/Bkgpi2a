package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 * Classe d�crivant un utilisateur d'un patrimoine.
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#userqueryview">UserQueryView</A>
 */
@JsonTypeName("patrimonyManager")
public class PatrimonyManager extends User {

    /**
     * Soci�t� dont d�pend l'utilisateur
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    /**
     * Agences supervis�es par l'utilisateur
     */
    @JsonProperty("managedAgencies")
    private List<AgencyUserQueryView> managedAgencies;

    /**
     * Patrimoines supervis�s par l'utilisateur
     */
    @JsonProperty("managedPatrimonies")
    private List<PatrimonyUserQueryView> managedPatrimonies;

    /**
     * @return la soci�t� dont d�pend l'utilisateur
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company d�finit la soci�t� dont d�pend l'utilisateur
     */
    @JsonSetter("company")
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

    /**
     * @return les agences supervis�es par l'utilisateur
     */
    @JsonGetter("managedAgencies")
    public List<AgencyUserQueryView> getManagedAgencies() {
        return managedAgencies;
    }

    /**
     * @param managedAgencies d�finit les agences supervis�es par l'utilisateur
     */
    @JsonSetter("managedAgencies")
    public void setManagedAgencies(List<AgencyUserQueryView> managedAgencies) {
        this.managedAgencies = managedAgencies;
    }

    /**
     * @return les patrimoines supervis�s par l'utilisateur
     */
    @JsonGetter("managedPatrimonies")
    public List<PatrimonyUserQueryView> getManagedPatrimonies() {
        return managedPatrimonies;
    }

    /**
     * @param managedPatrimonies d�finit les agences supervis�es par
     * l'utilisateur
     */
    @JsonSetter("managedPatrimonies")
    public void setManagedPatrimonies(List<PatrimonyUserQueryView> managedPatrimonies) {
        this.managedPatrimonies = managedPatrimonies;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Executive:{"
                + super.toString()
                + ", company:" + getCompany()
                + ", managedAgencies:" + getManagedAgencies()
                + ", managedPatrimonies:" + getManagedPatrimonies()
                + "}";
    }
}
