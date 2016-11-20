package bkgpi2a;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Classse donnant la derni�re date d'ex�cution d'un programme donn�
 *
 * @author Thierry Baribaud
 * @version 0.27
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastRun {

    /**
     * Constructeur principal de la classe
     */
    public LastRun() {
    }

    /**
     * Constructeur secondaire de la classe
     *
     * @param programName nom du programme
     */
    public LastRun(@JsonProperty("programName") String programName) {
        DateTimeFormatter fmt = ISODateTimeFormat.dateTimeNoMillis();

        this.programName = programName;
        this.lastRun = fmt.print(new DateTime().toDateTime(DateTimeZone.UTC));
    }

    /**
     * Nom du programme
     */
    private String programName;

    /**
     * Date de derni�re ex�cution
     */
    private String lastRun;

    /**
     * @return le nom du programme
     */
    @JsonGetter("programName")
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName d�finit le nom du programme
     */
    @JsonSetter("programName")
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * @return la date de derni�re ex�cution
     */
    @JsonGetter("lastRun")
    public String getLastRun() {
        return lastRun;
    }

    /**
     * @param lastRun d�finit la date de derni�re ex�cution
     */
    @JsonSetter("lastRun")
    public void setLastRun(String lastRun) {
        this.lastRun = lastRun;
    }

    /**
     * @return Retourne la derni�re ex�cution sous forme textuelle
     */
    @Override
    public String toString() {
        return "LastRun:{programName:" + getProgramName()
                + ", lastRun:" + getLastRun()
                + "}";
    }
}
