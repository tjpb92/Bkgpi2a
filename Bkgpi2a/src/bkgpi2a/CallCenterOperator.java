package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Classe décrivant un opérateur de centre d'appel
 *
 * @author Thierry Baribaud
 * @version 1.37
 * @see
 * <A href="http://performanceimmo.github.io/API/#userqueryview">UserQueryView</A>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("callCenterOperator")
public class CallCenterOperator extends User {

    /**
     * Call center dont dépend l'opérateur
     */
    @JsonProperty("company")
    private CompanyUserQueryView company;

    /**
     * @return le call center dont dépend l'opérateur
     */
    @JsonGetter("company")
    public CompanyUserQueryView getCompany() {
        return company;
    }

    /**
     * @param company définit le call center dont dépend l'opérateur
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
        return "CallCenterUser:{"
                + super.toString()
                + ", company:" + getCompany()
                + "}";
    }

}
