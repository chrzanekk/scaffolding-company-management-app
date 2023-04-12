package pl.com.chrzanowski.scma.service.filter.vehicle;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class VehicleFilter {

    private Long id;
    private Long brandId;
    private String brandName;
    private Long modelId;
    private String modelName;
    private String registrationNumber;
    private String vin;
    private Short productionYearStartWith;
    private Short productionYearEndWith;
    private LocalDate firstRegistrationDateStartWith;
    private LocalDate firstRegistrationDateEndWith;
    private Short freePlacesForTechInspectionStartWith;
    private Short freePlacesForTechInspectionEndWith;
    private Long fuelTypeId;
    private String fuelTypeName;
    private Long vehicleTypeId;
    private String vehicleTypeName;
    private BigDecimal lengthStartWith;
    private BigDecimal lengthEndWith;
    private BigDecimal widthStartWith;
    private BigDecimal widthEndWith;
    private BigDecimal heightStartWith;
    private BigDecimal heightEndWith;
    private Instant createDateStartWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartWith;
    private Instant modifyDateEndWith;

    public VehicleFilter() {
    }

    private VehicleFilter(Builder builder) {
        setId(builder.id);
        setBrandId(builder.brandId);
        setBrandName(builder.brandName);
        setModelId(builder.modelId);
        setModelName(builder.modelName);
        setRegistrationNumber(builder.registrationNumber);
        setVin(builder.vin);
        setProductionYearStartWith(builder.productionYearStartWith);
        setProductionYearEndWith(builder.productionYearEndWith);
        setFirstRegistrationDateStartWith(builder.firstRegistrationDateStartWith);
        setFirstRegistrationDateEndWith(builder.firstRegistrationDateEndWith);
        setFreePlacesForTechInspectionStartWith(builder.freePlacesForTechInspectionStartWith);
        setFreePlacesForTechInspectionEndWith(builder.freePlacesForTechInspectionEndWith);
        setFuelTypeId(builder.fuelTypeId);
        setFuelTypeName(builder.fuelTypeName);
        setVehicleTypeId(builder.vehicleTypeId);
        setVehicleTypeName(builder.vehicleTypeName);
        setLengthStartWith(builder.lengthStartWith);
        setLengthEndWith(builder.lengthEndWith);
        setWidthStartWith(builder.widthStartWith);
        setWidthEndWith(builder.widthEndWith);
        setHeightStartWith(builder.heightStartWith);
        setHeightEndWith(builder.heightEndWith);
        setCreateDateStartWith(builder.createDateStartWith);
        setCreateDateEndWith(builder.createDateEndWith);
        setModifyDateStartWith(builder.modifyDateStartWith);
        setModifyDateEndWith(builder.modifyDateEndWith);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Short getProductionYearStartWith() {
        return productionYearStartWith;
    }

    public void setProductionYearStartWith(Short productionYearStartWith) {
        this.productionYearStartWith = productionYearStartWith;
    }

    public Short getProductionYearEndWith() {
        return productionYearEndWith;
    }

    public void setProductionYearEndWith(Short productionYearEndWith) {
        this.productionYearEndWith = productionYearEndWith;
    }

    public LocalDate getFirstRegistrationDateStartWith() {
        return firstRegistrationDateStartWith;
    }

    public void setFirstRegistrationDateStartWith(LocalDate firstRegistrationDateStartWith) {
        this.firstRegistrationDateStartWith = firstRegistrationDateStartWith;
    }

    public LocalDate getFirstRegistrationDateEndWith() {
        return firstRegistrationDateEndWith;
    }

    public void setFirstRegistrationDateEndWith(LocalDate firstRegistrationDateEndWith) {
        this.firstRegistrationDateEndWith = firstRegistrationDateEndWith;
    }

    public Short getFreePlacesForTechInspectionStartWith() {
        return freePlacesForTechInspectionStartWith;
    }

    public void setFreePlacesForTechInspectionStartWith(Short freePlacesForTechInspectionStartWith) {
        this.freePlacesForTechInspectionStartWith = freePlacesForTechInspectionStartWith;
    }

    public Short getFreePlacesForTechInspectionEndWith() {
        return freePlacesForTechInspectionEndWith;
    }

    public void setFreePlacesForTechInspectionEndWith(Short freePlacesForTechInspectionEndWith) {
        this.freePlacesForTechInspectionEndWith = freePlacesForTechInspectionEndWith;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public BigDecimal getLengthStartWith() {
        return lengthStartWith;
    }

    public void setLengthStartWith(BigDecimal lengthStartWith) {
        this.lengthStartWith = lengthStartWith;
    }

    public BigDecimal getLengthEndWith() {
        return lengthEndWith;
    }

    public void setLengthEndWith(BigDecimal lengthEndWith) {
        this.lengthEndWith = lengthEndWith;
    }

    public BigDecimal getWidthStartWith() {
        return widthStartWith;
    }

    public void setWidthStartWith(BigDecimal widthStartWith) {
        this.widthStartWith = widthStartWith;
    }

    public BigDecimal getWidthEndWith() {
        return widthEndWith;
    }

    public void setWidthEndWith(BigDecimal widthEndWith) {
        this.widthEndWith = widthEndWith;
    }

    public BigDecimal getHeightStartWith() {
        return heightStartWith;
    }

    public void setHeightStartWith(BigDecimal heightStartWith) {
        this.heightStartWith = heightStartWith;
    }

    public BigDecimal getHeightEndWith() {
        return heightEndWith;
    }

    public void setHeightEndWith(BigDecimal heightEndWith) {
        this.heightEndWith = heightEndWith;
    }

    public Instant getCreateDateStartWith() {
        return createDateStartWith;
    }

    public void setCreateDateStartWith(Instant createDateStartWith) {
        this.createDateStartWith = createDateStartWith;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public void setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
    }

    public Instant getModifyDateStartWith() {
        return modifyDateStartWith;
    }

    public void setModifyDateStartWith(Instant modifyDateStartWith) {
        this.modifyDateStartWith = modifyDateStartWith;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public void setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
    }


    public static final class Builder {
        private Long id;
        private Long brandId;
        private String brandName;
        private Long modelId;
        private String modelName;
        private String registrationNumber;
        private String vin;
        private Short productionYearStartWith;
        private Short productionYearEndWith;

        private LocalDate firstRegistrationDateStartWith;

        private LocalDate firstRegistrationDateEndWith;
        private Short freePlacesForTechInspectionStartWith;
        private Short freePlacesForTechInspectionEndWith;
        private Long fuelTypeId;
        private String fuelTypeName;
        private Long vehicleTypeId;
        private String vehicleTypeName;
        private BigDecimal lengthStartWith;
        private BigDecimal lengthEndWith;
        private BigDecimal widthStartWith;
        private BigDecimal widthEndWith;
        private BigDecimal heightStartWith;
        private BigDecimal heightEndWith;
        private Instant createDateStartWith;
        private Instant createDateEndWith;
        private Instant modifyDateStartWith;
        private Instant modifyDateEndWith;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public Builder modelId(Long modelId) {
            this.modelId = modelId;
            return this;
        }

        public Builder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder registrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder vin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder productionYearStartWith(Short productionYearStartWith) {
            this.productionYearStartWith = productionYearStartWith;
            return this;
        }

        public Builder productionYearEndWith(Short productionYearEndWith) {
            this.productionYearEndWith = productionYearEndWith;
            return this;
        }

        public Builder firstRegistrationDateStartWith(LocalDate firstRegistrationDateStartWith) {
            this.firstRegistrationDateStartWith = firstRegistrationDateStartWith;
            return this;
        }

        public Builder firstRegistrationDateEndWith(LocalDate firstRegistrationDateEndWith) {
            this.firstRegistrationDateEndWith = firstRegistrationDateEndWith;
            return this;
        }

        public Builder freePlacesForTechInspectionStartWith(Short freePlacesForTechInspectionStartWith) {
            this.freePlacesForTechInspectionStartWith = freePlacesForTechInspectionStartWith;
            return this;
        }

        public Builder freePlacesForTechInspectionEndWith(Short freePlacesForTechInspectionEndWith) {
            this.freePlacesForTechInspectionEndWith = freePlacesForTechInspectionEndWith;
            return this;
        }

        public Builder fuelTypeId(Long fuelTypeId) {
            this.fuelTypeId = fuelTypeId;
            return this;
        }

        public Builder fuelTypeName(String fuelTypeName) {
            this.fuelTypeName = fuelTypeName;
            return this;
        }

        public Builder vehicleTypeId(Long vehicleTypeId) {
            this.vehicleTypeId = vehicleTypeId;
            return this;
        }

        public Builder vehicleTypeName(String vehicleTypeName) {
            this.vehicleTypeName = vehicleTypeName;
            return this;
        }

        public Builder lengthStartWith(BigDecimal lengthStartWith) {
            this.lengthStartWith = lengthStartWith;
            return this;
        }

        public Builder lengthEndWith(BigDecimal lengthEndWith) {
            this.lengthEndWith = lengthEndWith;
            return this;
        }

        public Builder widthStartWith(BigDecimal widthStartWith) {
            this.widthStartWith = widthStartWith;
            return this;
        }

        public Builder widthEndWith(BigDecimal widthEndWith) {
            this.widthEndWith = widthEndWith;
            return this;
        }

        public Builder heightStartWith(BigDecimal heightStartWith) {
            this.heightStartWith = heightStartWith;
            return this;
        }

        public Builder heightEndWith(BigDecimal heightEndWith) {
            this.heightEndWith = heightEndWith;
            return this;
        }

        public Builder createDateStartWith(Instant createDateStartWith) {
            this.createDateStartWith = createDateStartWith;
            return this;
        }

        public Builder createDateEndWith(Instant createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartWith(Instant modifyDateStartWith) {
            this.modifyDateStartWith = modifyDateStartWith;
            return this;
        }

        public Builder modifyDateEndWith(Instant modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public VehicleFilter build() {
            return new VehicleFilter(this);
        }
    }
}
