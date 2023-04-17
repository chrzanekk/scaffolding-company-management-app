package pl.com.chrzanowski.scma.service.dto;

import pl.com.chrzanowski.scma.domain.enumeration.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class VehicleTireDTO {
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
    private final Long vehicleId;
    private final Long vehicleBrandId;
    private final Long vehicleModelId;
    private final String vehicleBrandName;
    private final String vehicleModelName;
    private final Instant createDate;
    private final Instant modifyDate;
    private final Instant removeDate;
    private final Integer productionYear;
    private final LocalDate purchaseDate;

    public VehicleTireDTO(Long id,
                          String brand,
                          String model,
                          Integer width,
                          Integer profile,
                          Integer diameter, TireType type,
                          TireReinforcedIndex tireReinforcedIndex,
                          TireSpeedIndex speedIndex,
                          TireLoadCapacityIndex capacityIndex,
                          TireSeasonType tireSeasonType,
                          Boolean runOnFlat,
                          Long vehicleId,
                          Long vehicleBrandId,
                          Long vehicleModelId,
                          String vehicleBrandName,
                          String vehicleModelName,
                          Instant createDate,
                          Instant modifyDate,
                          Instant removeDate,
                          Integer productionYear,
                          LocalDate purchaseDate) {
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
        this.vehicleId = vehicleId;
        this.vehicleBrandId = vehicleBrandId;
        this.vehicleModelId = vehicleModelId;
        this.vehicleBrandName = vehicleBrandName;
        this.vehicleModelName = vehicleModelName;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
        this.productionYear = productionYear;
        this.purchaseDate = purchaseDate;
    }



    private VehicleTireDTO(Builder builder) {
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
        vehicleId = builder.vehicleId;
        vehicleBrandId = builder.vehicleBrandId;
        vehicleModelId = builder.vehicleModelId;
        vehicleBrandName = builder.vehicleBrandName;
        vehicleModelName = builder.vehicleModelName;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
        productionYear = builder.productionYear;
        purchaseDate = builder.purchaseDate;
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

    public Integer getDiameter() {
        return diameter;
    }

    public Integer getProfile() {
        return profile;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public Long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
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

    public Integer getProductionYear() {
        return productionYear;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleTireDTO that = (VehicleTireDTO) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(brand, that.brand)) return false;
        if (!Objects.equals(model, that.model)) return false;
        if (!Objects.equals(width, that.width)) return false;
        if (!Objects.equals(profile, that.profile)) return false;
        if (!Objects.equals(diameter, that.diameter)) return false;
        if (type != that.type) return false;
        if (tireReinforcedIndex != that.tireReinforcedIndex) return false;
        if (speedIndex != that.speedIndex) return false;
        if (capacityIndex != that.capacityIndex) return false;
        if (tireSeasonType != that.tireSeasonType) return false;
        if (!Objects.equals(runOnFlat, that.runOnFlat)) return false;
        if (!Objects.equals(vehicleId, that.vehicleId)) return false;
        if (!Objects.equals(vehicleBrandId, that.vehicleBrandId))
            return false;
        if (!Objects.equals(vehicleModelId, that.vehicleModelId))
            return false;
        if (!Objects.equals(vehicleBrandName, that.vehicleBrandName))
            return false;
        if (!Objects.equals(vehicleModelName, that.vehicleModelName))
            return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(modifyDate, that.modifyDate)) return false;
        if (!Objects.equals(removeDate, that.removeDate)) return false;
        if (!Objects.equals(productionYear, that.productionYear))
            return false;
        return Objects.equals(purchaseDate, that.purchaseDate);
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
        result = 31 * result + (vehicleId != null ? vehicleId.hashCode() : 0);
        result = 31 * result + (vehicleBrandId != null ? vehicleBrandId.hashCode() : 0);
        result = 31 * result + (vehicleModelId != null ? vehicleModelId.hashCode() : 0);
        result = 31 * result + (vehicleBrandName != null ? vehicleBrandName.hashCode() : 0);
        result = 31 * result + (vehicleModelName != null ? vehicleModelName.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        result = 31 * result + (productionYear != null ? productionYear.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTireDTO{" +
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
                ", vehicleId=" + vehicleId +
                ", vehicleBrandId=" + vehicleBrandId +
                ", vehicleModelId=" + vehicleModelId +
                ", vehicleBrandName='" + vehicleBrandName + '\'' +
                ", vehicleModelName='" + vehicleModelName + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", productionYear=" + productionYear +
                ", purchaseDate=" + purchaseDate +
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
        private Long vehicleId;
        private Long vehicleBrandId;
        private Long vehicleModelId;
        private String vehicleBrandName;
        private String vehicleModelName;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;
        private Integer productionYear;
        private LocalDate purchaseDate;

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

        public Builder vehicleId(Long vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder vehicleBrandId(Long vehicleBrandId) {
            this.vehicleBrandId = vehicleBrandId;
            return this;
        }

        public Builder vehicleModelId(Long vehicleModelId) {
            this.vehicleModelId = vehicleModelId;
            return this;
        }

        public Builder vehicleBrandName(String vehicleBrandName) {
            this.vehicleBrandName = vehicleBrandName;
            return this;
        }

        public Builder vehicleModelName(String vehicleModelName) {
            this.vehicleModelName = vehicleModelName;
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

        public Builder productionYear(Integer productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder purchaseDate(LocalDate purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public VehicleTireDTO build() {
            return new VehicleTireDTO(this);
        }
    }
}
