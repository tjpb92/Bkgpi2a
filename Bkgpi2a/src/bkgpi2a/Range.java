package bkgpi2a;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

/**
 * Classe d�crivant les param�tres d'�tendues intervenants dans les requ�tes
 * HTTP.
 *
 * Content-Range: offset-limit/count, exemple : 0-10/256 
 * Accept-Range: page, exemple : 100 range: start-end, exemple 0-10
 *
 * @author Thierry Baribaud
 * @version October 2016
 */
public class Range {

    /**
     * Le nombre d'enregistrements � r�cup�rer
     */
    private int count = 0;

    /**
     * L'offset � partir duquel lire les enregistrements
     */
    private int offset = 0;

    /**
     * L'indice du dernier enregistrement lu
     */
    private int limit = 0;

    /**
     * Le nombre d'enregistrements par page
     */
    private int page = 100;

    /**
     * Constructeur principal
     * @param contentRange lut dans le header HTTP
     * @param acceptRange le nombre d'enregistrements par page
     */
    public Range(String contentRange, String acceptRange) {
        contentRange(contentRange);
        setPage(acceptRange);
    }

    /**
     * Extrait les valeurs : offset, limit et count de contentRange
     *
     * @param contentRange lut dans le header HTTP
     */
    public void contentRange(String contentRange) {
        String[] buffer1;
        String[] buffer2;

        buffer1 = contentRange.split("/");
        if (buffer1.length == 2) {
            setCount(buffer1[1]);
            buffer2 = buffer1[0].split("-");
            if (buffer2.length == 2) {
                setOffset(buffer2[0]);
                setLimit(buffer2[1]);
            } else {
                setOffset(0);
                setLimit(0);
            }
        } else {
            setCount(0);
            setOffset(0);
            setLimit(0);
        }
    }

    /**
     * @return le nombre d'enregistrements � r�cup�rer
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count d�finit le nombre d'enregistrements � r�cup�rer
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @param count d�finit le nombre d'enregistrements � r�cup�rer
     */
    public void setCount(String count) {

        try {
            setCount(parseInt(count));
        } catch (Exception exception) {
            System.out.println("ERREUR : Impossible de convertir " + count + " en entier " + exception);
        }
    }

    /**
     * @return l'offset � partir duquel lire les enregistrements
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset d�finit l'offset � partir duquel lire les enregistrements
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @param offset d�finit l'offset � partir duquel lire les enregistrements
     */
    public void setOffset(String offset) {

        try {
            setOffset(parseInt(offset));
        } catch (Exception exception) {
            System.out.println("ERREUR : Impossible de convertir " + offset + " en entier " + exception);
        }
    }

    /**
     * @return l'indice du dernier enregistrement lu
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit d�finit l'indice du dernier enregistrement lu
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @param limit d�finit l'offset � partir duquel lire les enregistrements
     */
    public void setLimit(String limit) {

        try {
            setLimit(parseInt(limit));
        } catch (Exception exception) {
            System.out.println("ERREUR : Impossible de convertir " + limit + " en entier " + exception);
        }
    }

    /**
     * @return le nombre d'enregistrements par page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page d�finit le nombre d'enregistrements par page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @param page d�finit le nombre d'enregistrements par page
     */
    public void setPage(String page) {

        try {
            setPage(parseInt(page));
        } catch (Exception exception) {
            System.out.println("ERREUR : Impossible de convertir " + page + " en entier " + exception);
        }
    }

    /**
     * Calcule l'�tendue suivante
     * @return indique s'il reste des donn�es � lire
     */
    public boolean hasNext() {

        setOffset(min((getLimit()+1), getCount()));
        setLimit(min((getLimit() + getPage()), getCount()));
        return getLimit() < getCount();
    }
    
    /**
     * @return l'�tendue 
     */
    public String getRange() {
        return offset + "-" + limit;
    }

    /**
     * @return l'�tendue sous forme textuelle
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + 
                ":{" +
                "offset:" + getOffset() + 
                ", limit:" + getLimit() + 
                ", count:" + getCount() + 
                ", page:" + getPage() + 
                "}";
    }
}
