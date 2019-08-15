package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant l'objet DataGouvAPIIdChecker
 *
 * @author Thierry Baribaud
 * @version 1.11
 * @see http://performanceimmo.github.io/API/#addresschecker
 */
@JsonIgnoreProperties({"addressCheckerType"})
public class DataGouvAPIIdChecker extends AddressChecker {

//    private String dataGouvAddressId;

    /**
     * Constructeur principal
     */
    public DataGouvAPIIdChecker() {
    }

    /**
     * @return l'identifiant du lieu par Google
     */
    public String getDataGouvAddressId() {
//        return dataGouvAddressId;
        return getAddressCheckerType();
    }

    /**
     * @param dataGouvAddressId définit l'identifiant du lieu par Google
     */
    public void setDataGouvAddressId(String dataGouvAddressId) {
//        this.dataGouvAddressId = dataGouvAddressId;
        setAddressCheckerType(dataGouvAddressId);
    }

    /**
     * @return l'objet Checker sous forme textuelle.
     */
    @Override
    public String toString() {
        return "DataGouvAPIIdChecker:{"
                + "dataGouvAddressId:" + getDataGouvAddressId()
                + "}";
    }
}
