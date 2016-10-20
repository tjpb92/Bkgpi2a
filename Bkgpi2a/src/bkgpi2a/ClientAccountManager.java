package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe d�crivant client de type administrateur de compte
 *
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
@JsonTypeName("clientAccountManager")
public class ClientAccountManager extends User {

    /**
     * Call center dont d�pend le manager
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    /**
     * @return le call center dont d�pend le manager
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company d�finit le call center dont d�pend le manager
     */
    @JsonSetter("company")
    public void setCompany(CompanyUserQueryView company) {
        this.company = company;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "ClientAccountManager:{"
                + super.toString()
                + ", company:" + getCompany()
                + "}";
    }

}
