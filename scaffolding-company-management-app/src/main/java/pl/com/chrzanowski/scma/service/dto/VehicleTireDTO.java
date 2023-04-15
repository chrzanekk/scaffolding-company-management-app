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
                          TireType type,
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
        return Objects.equals(id, that.id) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(width, that.width) && Objects.equals(profile, that.profile) && type == that.type && tireReinforcedIndex == that.tireReinforcedIndex && speedIndex == that.speedIndex && capacityIndex == that.capacityIndex && tireSeasonType == that.tireSeasonType && Objects.equals(runOnFlat, that.runOnFlat) && Objects.equals(vehicleId, that.vehicleId) && Objects.equals(vehicleBrandId, that.vehicleBrandId) && Objects.equals(vehicleModelId, that.vehicleModelId) && Objects.equals(vehicleBrandName, that.vehicleBrandName) && Objects.equals(vehicleModelName, that.vehicleModelName) && Objects.equals(createDate, that.createDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(removeDate, that.removeDate) && Objects.equals(productionYear, that.productionYear) && Objects.equals(purchaseDate, that.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, width, profile, type, tireReinforcedIndex, speedIndex, capacityIndex, tireSeasonType, runOnFlat, vehicleId, vehicleBrandId, vehicleModelId, vehicleBrandName, vehicleModelName, createDate, modifyDate, removeDate, productionYear, purchaseDate);
    }

    @Override
    public String toString() {
        return "VehicleTireDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", width=" + width +
                ", profile=" + profile +
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

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder brand(String val) {
            brand = val;
            return this;
        }

        public Builder model(String val) {
            model = val;
            return this;
        }

        public Builder width(Integer val) {
            width = val;
            return this;
        }

        public Builder profile(Integer val) {
            profile = val;
            return this;
        }

        public Builder type(TireType val) {
            type = val;
            return this;
        }

        public Builder tireReinforcedIndex(TireReinforcedIndex val) {
            tireReinforcedIndex = val;
            return this;
        }

        public Builder speedIndex(TireSpeedIndex val) {
            speedIndex = val;
            return this;
        }

        public Builder capacityIndex(TireLoadCapacityIndex val) {
            capacityIndex = val;
            return this;
        }

        public Builder tireSeasonType(TireSeasonType val) {
            tireSeasonType = val;
            return this;
        }

        public Builder runOnFlat(Boolean val) {
            runOnFlat = val;
            return this;
        }

        public Builder vehicleId(Long val) {
            vehicleId = val;
            return this;
        }

        public Builder vehicleBrandId(Long val) {
            vehicleBrandId = val;
            return this;
        }

        public Builder vehicleModelId(Long val) {
            vehicleModelId = val;
            return this;
        }

        public Builder vehicleBrandName(String val) {
            vehicleBrandName = val;
            return this;
        }

        public Builder vehicleModelName(String val) {
            vehicleModelName = val;
            return this;
        }

        public Builder createDate(Instant val) {
            createDate = val;
            return this;
        }

        public Builder modifyDate(Instant val) {
            modifyDate = val;
            return this;
        }

        public Builder removeDate(Instant val) {
            removeDate = val;
            return this;
        }

        public Builder productionYear(Integer val) {
            productionYear = val;
            return this;
        }

        public Builder purchaseDate(LocalDate val) {
            purchaseDate = val;
            return this;
        }

        public VehicleTireDTO build() {
            return new VehicleTireDTO(this);
        }
    }
}
