package bkgpi2a;

/**
 * Classe décrivant un commentaire contextuel.
 *
 * @author Thierry Baribaud
 * @version 1.36
 * @see
 * <A href="https://performanceimmo.github.io/API/#contextualcomment">ContextualComment</A>
 */
public class ContextualComment {

    /**
     * Identifiant unique du commentaire
     */
    private String uid;

    /**
     * Titre du commentaire
     */
    private String title;

    /**
     * Commentaire
     */
    private String comment;

    /**
     * @return l'identifiant unique du commentaire
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid définit l'identifiant unique du commentaire
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return le titre du commentaire
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title définit le titre du commentaire
     */
    public void setTitle(String title) {
        this.title = title;
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
        return ("ContextualComment:{"
                + "uid:" + getUid()
                + ", title:" + getTitle()
                + ", comment:" + getComment()
                + "}");
    }
}
