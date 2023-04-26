package pl.com.chrzanowski.scma.service.dto;

import pl.com.chrzanowski.scma.domain.enumeration.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class TireDTO {
    private final Long id;
    private final String brand;
    private final String model;
    private final Integer width;
    private final Integer profile;
    private final Integer diameter;
    private final TireType type;
    private final TireReinforcedIndex tireReinforcedIndex;
    private final TireSpeedIndex speedIndex;
    private final TireLoadCapacityIndex capacityIndex;
    private final TireSeasonType tireSeasonType;
    private final Boolean runOnFlat;
    private final Integer productionYear;
    private final LocalDate purchaseDate;
    private final TireStatus tireStatus;
    private final Instant createDate;
    private final Instant modifyDate;
    private final Instant removeDate;
    private final Long vehicleId;

    public TireDTO(Long id,
                   String brand,
                   String model,
                   Integer width,
                   Integer profile,
                   Integer diameter,
                   TireType type,
                   TireReinforcedIndex tireReinforcedIndex,
                   TireSpeedIndex speedIndex,
                   TireLoadCapacityIndex capacityIndex,
                   TireSeasonType tireSeasonType,
                   Boolean runOnFlat,
                   Integer productionYear,
                   LocalDate purchaseDate,
                   TireStatus tireStatus,
                   Instant createDate,
                   Instant modifyDate,
                   Instant removeDate, Long vehicleId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.width = width;
        this.profile = profile;
        this.diameter = diameter;
        this.type = type;
        this.tireReinforcedIndex = tireReinforcedIndex;
        this.speedIndex = speedIndex;
        this.capacityIndex = capacityIndex;
        this.tireSeasonType = tireSeasonType;
        this.runOnFlat = runOnFlat;
        this.productionYear = productionYear;
        this.purchaseDate = purchaseDate;
        this.tireStatus = tireStatus;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
        this.vehicleId = vehicleId;
    }

    private TireDTO(Builder builder) {
        id = builder.id;
        brand = builder.brand;
        model = builder.model;
        width = builder.width;
        profile = builder.profile;
        diameter = builder.diameter;
        type = builder.type;
        tireReinforcedIndex = builder.tireReinforcedIndex;
        speedIndex = builder.speedIndex;
        capacityIndex = builder.capacityIndex;
        tireSeasonType = builder.tireSeasonType;
        runOnFlat = builder.runOnFlat;
        productionYear = builder.productionYear;
        purchaseDate = builder.purchaseDate;
        tireStatus = builder.tireStatus;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
        vehicleId = builder.vehicleId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getProfile() {
        return profile;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public TireType getType() {
        return type;
    }

    public TireReinforcedIndex getTireReinforcedIndex() {
        return tireReinforcedIndex;
    }

    public TireSpeedIndex getSpeedIndex() {
        return speedIndex;
    }

    public TireLoadCapacityIndex getCapacityIndex() {
        return capacityIndex;
    }

    public TireSeasonType getTireSeasonType() {
        return tireSeasonType;
    }

    public Boolean getRunOnFlat() {
        return runOnFlat;
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

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TireDTO tireDTO = (TireDTO) o;

        if (!Objects.equals(id, tireDTO.id)) return false;
        if (!Objects.equals(brand, tireDTO.brand)) return false;
        if (!Objects.equals(model, tireDTO.model)) return false;
        if (!Objects.equals(width, tireDTO.width)) return false;
        if (!Objects.equals(profile, tireDTO.profile)) return false;
        if (!Objects.equals(diameter, tireDTO.diameter)) return false;
        if (type != tireDTO.type) return false;
        if (tireReinforcedIndex != tireDTO.tireReinforcedIndex) return false;
        if (speedIndex != tireDTO.speedIndex) return false;
        if (capacityIndex != tireDTO.capacityIndex) return false;
        if (tireSeasonType != tireDTO.tireSeasonType) return false;
        if (!Objects.equals(runOnFlat, tireDTO.runOnFlat)) return false;
        if (!Objects.equals(productionYear, tireDTO.productionYear))
            return false;
        if (!Objects.equals(purchaseDate, tireDTO.purchaseDate))
            return false;
        if (tireStatus != tireDTO.tireStatus) return false;
        if (!Objects.equals(createDate, tireDTO.createDate)) return false;
        if (!Objects.equals(modifyDate, tireDTO.modifyDate)) return false;
        if (!Objects.equals(removeDate, tireDTO.removeDate)) return false;
        return Objects.equals(vehicleId, tireDTO.vehicleId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (tireReinforcedIndex != null ? tireReinforcedIndex.hashCode() : 0);
        result = 31 * result + (speedIndex != null ? speedIndex.hashCode() : 0);
        result = 31 * result + (capacityIndex != null ? capacityIndex.hashCode() : 0);
        result = 31 * result + (tireSeasonType != null ? tireSeasonType.hashCode() : 0);
        result = 31 * result + (runOnFlat != null ? runOnFlat.hashCode() : 0);
        result = 31 * result + (productionYear != null ? productionYear.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (tireStatus != null ? tireStatus.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        result = 31 * result + (vehicleId != null ? vehicleId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TireDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", width=" + width +
                ", profile=" + profile +
                ", diameter=" + diameter +
                ", type=" + type +
                ", tireReinforcedIndex=" + tireReinforcedIndex +
                ", speedIndex=" + speedIndex +
                ", capacityIndex=" + capacityIndex +
                ", tireSeasonType=" + tireSeasonType +
                ", runOnFlat=" + runOnFlat +
                ", productionYear=" + productionYear +
                ", purchaseDate=" + purchaseDate +
                ", tireStatus=" + tireStatus +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", vehicleId=" + vehicleId +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String brand;
        private String model;
        private Integer width;
        private Integer profile;
        private Integer diameter;
        private TireType type;
        private TireReinforcedIndex tireReinforcedIndex;
        private TireSpeedIndex speedIndex;
        private TireLoadCapacityIndex capacityIndex;
        private TireSeasonType tireSeasonType;
        private Boolean runOnFlat;
        private Integer productionYear;
        private LocalDate purchaseDate;
        private TireStatus tireStatus;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;
        private Long vehicleId;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder width(Integer width) {
            this.width = width;
            return this;
        }

        public Builder profile(Integer profile) {
            this.profile = profile;
            return this;
        }

        public Builder diameter(Integer diameter) {
            this.diameter = diameter;
            return this;
        }

        public Builder type(TireType type) {
            this.type = type;
            return this;
        }

        public Builder tireReinforcedIndex(TireReinforcedIndex tireReinforcedIndex) {
            this.tireReinforcedIndex = tireReinforcedIndex;
            return this;
        }

        public Builder speedIndex(TireSpeedIndex speedIndex) {
            this.speedIndex = speedIndex;
            return this;
        }

        public Builder capacityIndex(TireLoadCapacityIndex capacityIndex) {
            this.capacityIndex = capacityIndex;
            return this;
        }

        public Builder tireSeasonType(TireSeasonType tireSeasonType) {
            this.tireSeasonType = tireSeasonType;
            return this;
        }

        public Builder runOnFlat(Boolean runOnFlat) {
            this.runOnFlat = runOnFlat;
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

        public Builder vehicleId(Long vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public TireDTO build() {
            return new TireDTO(this);
        }
    }
}
