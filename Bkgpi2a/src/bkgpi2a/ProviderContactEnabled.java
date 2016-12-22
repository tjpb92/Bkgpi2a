package bkgpi2a;

/**
 * Classe d�crivant l'�v�nement ProviderContactEnabled #430
 * 
 * Pr�voir une enum pour :
 * 400 = ProviderContactAdded
 * 410 = ProviderContactUpdated
 * 420 = ProviderContactDisabled
 * 430 = ProviderContactEnabled
 * 440 = ProviderLinkedToAgency
 * 460 = ActivityAdded
 * 
 * @author Thierry Baribaud
 * @version 0.41
 */
public class ProviderContactEnabled extends Event {
    
    /**
     * M�thode servant � activer le statut d'un fournisseur
     * @param date date d'activation
     */
    public ProviderContactEnabled(String date)  {
        this.setDate(date);
        this.setEventType(this.getClass().getSimpleName());
        this.setEventTypeUid(430);
    }
    
}
