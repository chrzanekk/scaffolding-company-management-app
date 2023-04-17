package pl.com.chrzanowski.scma.service.filter.vehicletire;

import pl.com.chrzanowski.scma.domain.enumeration.*;

import java.time.Instant;
import java.time.LocalDate;

public class VehicleTireFilter {

    private Long id;
    private String brand;
    private String model;
    private Integer widthStartsWith;
    private Integer widthEndWith;
    private Integer profileStartsWith;
    private Integer profileEndWith;
    private TireType type;
    private TireReinforcedIndex reinforcedIndex;
    private TireSpeedIndex speedIndex;
    private TireLoadCapacityIndex loadCapacityIndex;
    private TireSeasonType seasonType;
    private Boolean runOnFlat;
    private Long vehicleId;
    private Long vehicleBrandId;
    private Long vehicleModelId;
    private String vehicleBrandName;
    private String vehicleModelName;
    private Instant createDateStartsWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartsWith;
    private Instant modifyDateEndWith;
    private Instant removeDateStartsWith;
    private Instant removeDateEndWith;
    private Integer productionYearStartsWith;
    private Integer productionYearEndWith;
    private LocalDate purchaseDateStartsWith;
    private LocalDate purchaseDateEndWith;

    public VehicleTireFilter() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWidthStartsWith() {
        return widthStartsWith;
    }

    public void setWidthStartsWith(Integer widthStartsWith) {
        this.widthStartsWith = widthStartsWith;
    }

    public Integer getWidthEndWith() {
        return widthEndWith;
    }

    public void setWidthEndWith(Integer widthEndWith) {
        this.widthEndWith = widthEndWith;
    }

    public Integer getProfileStartsWith() {
        return profileStartsWith;
    }

    public void setProfileStartsWith(Integer profileStartsWith) {
        this.profileStartsWith = profileStartsWith;
    }

    public Integer getProfileEndWith() {
        return profileEndWith;
    }

    public void setProfileEndWith(Integer profileEndWith) {
        this.profileEndWith = profileEndWith;
    }

    public TireType getType() {
        return type;
    }

    public void setType(TireType type) {
        this.type = type;
    }

    public TireReinforcedIndex getReinforcedIndex() {
        return reinforcedIndex;
    }

    public void setReinforcedIndex(TireReinforcedIndex reinforcedIndex) {
        this.reinforcedIndex = reinforcedIndex;
    }

    public TireSpeedIndex getSpeedIndex() {
        return speedIndex;
    }

    public void setSpeedIndex(TireSpeedIndex speedIndex) {
        this.speedIndex = speedIndex;
    }
    public TireLoadCapacityIndex getLoadCapacityIndex() {
        return loadCapacityIndex;
    }

    public void setLoadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
        this.loadCapacityIndex = loadCapacityIndex;
    }

    public TireSeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(TireSeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public Boolean getRunOnFlat() {
        return runOnFlat;
    }

    public void setRunOnFlat(Boolean runOnFlat) {
        this.runOnFlat = runOnFlat;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public void setVehicleBrandId(Long vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public Instant getCreateDateStartsWith() {
        return createDateStartsWith;
    }

    public void setCreateDateStartsWith(Instant createDateStartsWith) {
        this.createDateStartsWith = createDateStartsWith;
    }

    public Instant getModifyDateStartsWith() {
        return modifyDateStartsWith;
    }

    public void setModifyDateStartsWith(Instant modifyDateStartsWith) {
        this.modifyDateStartsWith = modifyDateStartsWith;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
    }

    public Integer getProductionYearStartsWith() {
        return productionYearStartsWith;
    }

    public void setProductionYearStartsWith(Integer productionYearStartsWith) {
        this.productionYearStartsWith = productionYearStartsWith;
    }

    public Integer getProductionYearEndWith() {
        return productionYearEndWith;
    }

    public void setProductionYearEndWith(Integer productionYearEndWith) {
        this.productionYearEndWith = productionYearEndWith;
    }

    public LocalDate getPurchaseDateStartsWith() {
        return purchaseDateStartsWith;
    }

    public void setPurchaseDateStartsWith(LocalDate purchaseDateStartsWith) {
        this.purchaseDateStartsWith = purchaseDateStartsWith;
    }

    public LocalDate getPurchaseDateEndWith() {
        return purchaseDateEndWith;
    }

    public void setPurchaseDateEndWith(LocalDate purchaseDateEndWith) {
        this.purchaseDateEndWith = purchaseDateEndWith;
    }

    public static final class Builder {
        private Long id;
        private String brand;
        private String model;
        private Integer widthStartsWith;
        private Integer widthEndWith;
        private Integer profileStartsWith;
        private Integer profileEndWith;
        private TireType type;
        private TireReinforcedIndex reinforcedIndex;
        private TireSpeedIndex speedIndex;
        private TireLoadCapacityIndex loadCapacityIndex;
        private TireSeasonType seasonType;
        private Boolean runOnFlat;
        private Long vehicleId;
        private Long vehicleBrandId;
        private Long vehicleModelId;
        private String vehicleBrandName;
        private String vehicleModelName;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;
        private Integer productionYearStartsWith;
        private Integer productionYearEndWith;
        private LocalDate purchaseDateStartsWith;
        private LocalDate purchaseDateEndWith;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
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

        public Builder widthStartsWith(Integer widthStartsWith) {
            this.widthStartsWith = widthStartsWith;
            return this;
        }

        public Builder widthEndWith(Integer widthEndWith) {
            this.widthEndWith = widthEndWith;
            return this;
        }

        public Builder profileStartsWith(Integer profileStartsWith) {
            this.profileStartsWith = profileStartsWith;
            return this;
        }

        public Builder profileEndWith(Integer profileEndWith) {
            this.profileEndWith = profileEndWith;
            return this;
        }

        public Builder type(TireType type) {
            this.type = type;
            return this;
        }

        public Builder reinforcedIndex(TireReinforcedIndex reinforcedIndex) {
            this.reinforcedIndex = reinforcedIndex;
            return this;
        }

        public Builder speedIndex(TireSpeedIndex speedIndex) {
            this.speedIndex = speedIndex;
            return this;
        }

        public Builder loadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
            this.loadCapacityIndex = loadCapacityIndex;
            return this;
        }

        public Builder seasonType(TireSeasonType seasonType) {
            this.seasonType = seasonType;
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

        public Builder productionYearStartsWith(Integer productionYearStartsWith) {
            this.productionYearStartsWith = productionYearStartsWith;
            return this;
        }

        public Builder productionYearEndWith(Integer productionYearEndWith) {
            this.productionYearEndWith = productionYearEndWith;
            return this;
        }

        public Builder purchaseDateStartsWith(LocalDate purchaseDateStartsWith) {
            this.purchaseDateStartsWith = purchaseDateStartsWith;
            return this;
        }

        public Builder purchaseDateEndWith(LocalDate purchaseDateEndWith) {
            this.purchaseDateEndWith = purchaseDateEndWith;
            return this;
        }

        public VehicleTireFilter build() {
            return new VehicleTireFilter(this);
        }
    }
}
