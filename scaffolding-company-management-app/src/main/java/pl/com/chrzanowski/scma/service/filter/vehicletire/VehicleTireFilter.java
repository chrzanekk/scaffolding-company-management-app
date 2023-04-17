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
    private Integer diameterStartsWith;
    private Integer diameterEndWith;
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

    private VehicleTireFilter(Builder builder) {
        setId(builder.id);
        setBrand(builder.brand);
        setModel(builder.model);
        setWidthStartsWith(builder.widthStartsWith);
        setWidthEndWith(builder.widthEndWith);
        setProfileStartsWith(builder.profileStartsWith);
        setProfileEndWith(builder.profileEndWith);
        setDiameterStartsWith(builder.diameterStartsWith);
        setDiameterEndWith(builder.diameterEndWith);
        setType(builder.type);
        setReinforcedIndex(builder.reinforcedIndex);
        setSpeedIndex(builder.speedIndex);
        setLoadCapacityIndex(builder.loadCapacityIndex);
        setSeasonType(builder.seasonType);
        setRunOnFlat(builder.runOnFlat);
        setVehicleId(builder.vehicleId);
        setVehicleBrandId(builder.vehicleBrandId);
        setVehicleModelId(builder.vehicleModelId);
        setVehicleBrandName(builder.vehicleBrandName);
        setVehicleModelName(builder.vehicleModelName);
        setCreateDateStartsWith(builder.createDateStartsWith);
        setCreateDateEndWith(builder.createDateEndWith);
        setModifyDateStartsWith(builder.modifyDateStartsWith);
        setModifyDateEndWith(builder.modifyDateEndWith);
        setRemoveDateStartsWith(builder.removeDateStartsWith);
        setRemoveDateEndWith(builder.removeDateEndWith);
        setProductionYearStartsWith(builder.productionYearStartsWith);
        setProductionYearEndWith(builder.productionYearEndWith);
        setPurchaseDateStartsWith(builder.purchaseDateStartsWith);
        setPurchaseDateEndWith(builder.purchaseDateEndWith);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public VehicleTireFilter setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleTireFilter setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VehicleTireFilter setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getWidthStartsWith() {
        return widthStartsWith;
    }

    public VehicleTireFilter setWidthStartsWith(Integer widthStartsWith) {
        this.widthStartsWith = widthStartsWith;
        return this;
    }

    public Integer getWidthEndWith() {
        return widthEndWith;
    }

    public VehicleTireFilter setWidthEndWith(Integer widthEndWith) {
        this.widthEndWith = widthEndWith;
        return this;
    }

    public Integer getProfileStartsWith() {
        return profileStartsWith;
    }

    public VehicleTireFilter setProfileStartsWith(Integer profileStartsWith) {
        this.profileStartsWith = profileStartsWith;
        return this;
    }

    public Integer getProfileEndWith() {
        return profileEndWith;
    }

    public VehicleTireFilter setProfileEndWith(Integer profileEndWith) {
        this.profileEndWith = profileEndWith;
        return this;
    }

    public Integer getDiameterStartsWith() {
        return diameterStartsWith;
    }

    public VehicleTireFilter setDiameterStartsWith(Integer diameterStartsWith) {
        this.diameterStartsWith = diameterStartsWith;
        return this;
    }

    public Integer getDiameterEndWith() {
        return diameterEndWith;
    }

    public VehicleTireFilter setDiameterEndWith(Integer diameterEndWith) {
        this.diameterEndWith = diameterEndWith;
        return this;
    }

    public TireType getType() {
        return type;
    }

    public VehicleTireFilter setType(TireType type) {
        this.type = type;
        return this;
    }

    public TireReinforcedIndex getReinforcedIndex() {
        return reinforcedIndex;
    }

    public VehicleTireFilter setReinforcedIndex(TireReinforcedIndex reinforcedIndex) {
        this.reinforcedIndex = reinforcedIndex;
        return this;
    }

    public TireSpeedIndex getSpeedIndex() {
        return speedIndex;
    }

    public VehicleTireFilter setSpeedIndex(TireSpeedIndex speedIndex) {
        this.speedIndex = speedIndex;
        return this;
    }

    public TireLoadCapacityIndex getLoadCapacityIndex() {
        return loadCapacityIndex;
    }

    public VehicleTireFilter setLoadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
        this.loadCapacityIndex = loadCapacityIndex;
        return this;
    }

    public TireSeasonType getSeasonType() {
        return seasonType;
    }

    public VehicleTireFilter setSeasonType(TireSeasonType seasonType) {
        this.seasonType = seasonType;
        return this;
    }

    public Boolean getRunOnFlat() {
        return runOnFlat;
    }

    public VehicleTireFilter setRunOnFlat(Boolean runOnFlat) {
        this.runOnFlat = runOnFlat;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public VehicleTireFilter setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public Long getVehicleBrandId() {
        return vehicleBrandId;
    }

    public VehicleTireFilter setVehicleBrandId(Long vehicleBrandId) {
        this.vehicleBrandId = vehicleBrandId;
        return this;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public VehicleTireFilter setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
        return this;
    }

    public String getVehicleBrandName() {
        return vehicleBrandName;
    }

    public VehicleTireFilter setVehicleBrandName(String vehicleBrandName) {
        this.vehicleBrandName = vehicleBrandName;
        return this;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public VehicleTireFilter setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
        return this;
    }

    public Instant getCreateDateStartsWith() {
        return createDateStartsWith;
    }

    public VehicleTireFilter setCreateDateStartsWith(Instant createDateStartsWith) {
        this.createDateStartsWith = createDateStartsWith;
        return this;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public VehicleTireFilter setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
        return this;
    }

    public Instant getModifyDateStartsWith() {
        return modifyDateStartsWith;
    }

    public VehicleTireFilter setModifyDateStartsWith(Instant modifyDateStartsWith) {
        this.modifyDateStartsWith = modifyDateStartsWith;
        return this;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public VehicleTireFilter setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
        return this;
    }

    public Instant getRemoveDateStartsWith() {
        return removeDateStartsWith;
    }

    public VehicleTireFilter setRemoveDateStartsWith(Instant removeDateStartsWith) {
        this.removeDateStartsWith = removeDateStartsWith;
        return this;
    }

    public Instant getRemoveDateEndWith() {
        return removeDateEndWith;
    }

    public VehicleTireFilter setRemoveDateEndWith(Instant removeDateEndWith) {
        this.removeDateEndWith = removeDateEndWith;
        return this;
    }

    public Integer getProductionYearStartsWith() {
        return productionYearStartsWith;
    }

    public VehicleTireFilter setProductionYearStartsWith(Integer productionYearStartsWith) {
        this.productionYearStartsWith = productionYearStartsWith;
        return this;
    }

    public Integer getProductionYearEndWith() {
        return productionYearEndWith;
    }

    public VehicleTireFilter setProductionYearEndWith(Integer productionYearEndWith) {
        this.productionYearEndWith = productionYearEndWith;
        return this;
    }

    public LocalDate getPurchaseDateStartsWith() {
        return purchaseDateStartsWith;
    }

    public VehicleTireFilter setPurchaseDateStartsWith(LocalDate purchaseDateStartsWith) {
        this.purchaseDateStartsWith = purchaseDateStartsWith;
        return this;
    }

    public LocalDate getPurchaseDateEndWith() {
        return purchaseDateEndWith;
    }

    public VehicleTireFilter setPurchaseDateEndWith(LocalDate purchaseDateEndWith) {
        this.purchaseDateEndWith = purchaseDateEndWith;
        return this;
    }


    public static final class Builder {
        private Long id;
        private String brand;
        private String model;
        private Integer widthStartsWith;
        private Integer widthEndWith;
        private Integer profileStartsWith;
        private Integer profileEndWith;
        private Integer diameterStartsWith;
        private Integer diameterEndWith;
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

        public Builder diameterStartsWith(Integer diameterStartsWith) {
            this.diameterStartsWith = diameterStartsWith;
            return this;
        }

        public Builder diameterEndWith(Integer diameterEndWith) {
            this.diameterEndWith = diameterEndWith;
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

        public Builder createDateStartsWith(Instant createDateStartsWith) {
            this.createDateStartsWith = createDateStartsWith;
            return this;
        }

        public Builder createDateEndWith(Instant createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartsWith(Instant modifyDateStartsWith) {
            this.modifyDateStartsWith = modifyDateStartsWith;
            return this;
        }

        public Builder modifyDateEndWith(Instant modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public Builder removeDateStartsWith(Instant removeDateStartsWith) {
            this.removeDateStartsWith = removeDateStartsWith;
            return this;
        }

        public Builder removeDateEndWith(Instant removeDateEndWith) {
            this.removeDateEndWith = removeDateEndWith;
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
