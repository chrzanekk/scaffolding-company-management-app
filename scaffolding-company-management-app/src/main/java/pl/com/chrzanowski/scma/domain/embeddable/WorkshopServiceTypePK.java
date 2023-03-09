package pl.com.chrzanowski.scma.domain.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WorkshopServiceTypePK implements Serializable {

    @Column(name = "workshop_id")
    private Long workshopId;

    @Column(name = "service_action_type_id")
    private Long serviceActionTypeId;

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public Long getServiceActionTypeId() {
        return serviceActionTypeId;
    }

    public void setServiceActionTypeId(Long serviceActionTypeId) {
        this.serviceActionTypeId = serviceActionTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkshopServiceTypePK that = (WorkshopServiceTypePK) o;

        if (!Objects.equals(workshopId, that.workshopId)) return false;
        return Objects.equals(serviceActionTypeId, that.serviceActionTypeId);
    }

    @Override
    public int hashCode() {
        int result = workshopId != null ? workshopId.hashCode() : 0;
        result = 31 * result + (serviceActionTypeId != null ? serviceActionTypeId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkshopServiceTypePK{" +
                "workshopId=" + workshopId +
                ", serviceActionTypeId=" + serviceActionTypeId +
                '}';
    }
}
