package bkgpi2a;

/**
 * Classe décrivant l'événement ProviderContactEnabled #430
 * 
 * Prévoir une enum pour :
 * 400 = ProviderContactAdded
 * 410 = ProviderContactUpdated
 * 420 = ProviderContactDisabled
 * 430 = ProviderContactEnabled
 * 440 = ProviderLinkedToAgency
 * 460 = ActivityAdded
 * 
 * @author Thierry Baribaud
 * @version Octobre 2016
 */
public class ProviderContactEnabled extends Event {
    
    public ProviderContactEnabled(String date)  {
        this.setDate(date);
        this.setEventType(this.getClass().getSimpleName());
        this.setEventTypeUid(430);
    }
    
}
