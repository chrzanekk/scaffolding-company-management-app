package pl.com.chrzanowski.scma.service.dto;


import pl.com.chrzanowski.scma.domain.enumeration.TireStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class VehicleTireDTO {

    private final Long id;
    private final Integer productionYear;
    private final LocalDate purchaseDate;
    private final TireStatus tireStatus;
    private final Long vehicleId;
    private final Long tireId;
    private final Instant createDate;
    private final Instant modifyDate;
    private final Instant removeDate;

    public VehicleTireDTO(Long id,
                          Integer productionYear,
                          LocalDate purchaseDate,
                          TireStatus tireStatus,
                          Long vehicleId,
                          Long tireId,
                          Instant createDate,
                          Instant modifyDate,
                          Instant removeDate) {
        this.id = id;
        this.productionYear = productionYear;
        this.purchaseDate = purchaseDate;
        this.tireStatus = tireStatus;
        this.vehicleId = vehicleId;
        this.tireId = tireId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    private VehicleTireDTO(Builder builder) {
        id = builder.id;
        productionYear = builder.productionYear;
        purchaseDate = builder.purchaseDate;
        tireStatus = builder.tireStatus;
        vehicleId = builder.vehicleId;
        tireId = builder.tireId;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public TireStatus getTireStatus() {
        return tireStatus;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public Long getTireId() {
        return tireId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleTireDTO that = (VehicleTireDTO) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(productionYear, that.productionYear))
            return false;
        if (!Objects.equals(purchaseDate, that.purchaseDate)) return false;
        if (tireStatus != that.tireStatus) return false;
        if (!Objects.equals(vehicleId, that.vehicleId)) return false;
        if (!Objects.equals(tireId, that.tireId)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(modifyDate, that.modifyDate)) return false;
        return Objects.equals(removeDate, that.removeDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productionYear != null ? productionYear.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (tireStatus != null ? tireStatus.hashCode() : 0);
        result = 31 * result + (vehicleId != null ? vehicleId.hashCode() : 0);
        result = 31 * result + (tireId != null ? tireId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTireDTO{" +
                "id=" + id +
                ", productionYear=" + productionYear +
                ", purchaseDate=" + purchaseDate +
                ", tireStatus=" + tireStatus +
                ", vehicleId=" + vehicleId +
                ", tireId=" + tireId +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }


    public static final class Builder {
        private Long id;
        private Integer productionYear;
        private LocalDate purchaseDate;
        private TireStatus tireStatus;
        private Long vehicleId;
        private Long tireId;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder productionYear(Integer productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder purchaseDate(LocalDate purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public Builder tireStatus(TireStatus tireStatus) {
            this.tireStatus = tireStatus;
            return this;
        }

        public Builder vehicleId(Long vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder tireId(Long tireId) {
            this.tireId = tireId;
            return this;
        }

        public Builder createDate(Instant createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder modifyDate(Instant modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public Builder removeDate(Instant removeDate) {
            this.removeDate = removeDate;
            return this;
        }

        public VehicleTireDTO build() {
            return new VehicleTireDTO(this);
        }
    }
}
