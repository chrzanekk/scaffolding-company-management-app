package pl.com.chrzanowski.scma.domain;

import pl.com.chrzanowski.scma.domain.embeddable.WorkshopServiceTypePK;

import javax.persistence.*;

@Entity
@Table(name = "workshop_service_action_types")
public class WorkshopServiceActionType {

    @EmbeddedId
    private WorkshopServiceTypePK id;

    @ManyToOne
    @MapsId("workshop_id")
    @JoinColumn(name = "id")
    private Workshop workshop;

    @ManyToOne
    @MapsId("service_action_type_id")
    @JoinColumn(name = "id")
    private ServiceActionType serviceActionType;
}
