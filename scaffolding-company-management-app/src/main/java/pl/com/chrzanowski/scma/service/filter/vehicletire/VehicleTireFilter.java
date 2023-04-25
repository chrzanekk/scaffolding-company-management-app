package pl.com.chrzanowski.scma.service.filter.vehicletire;

import pl.com.chrzanowski.scma.domain.enumeration.*;
import pl.com.chrzanowski.scma.service.filter.tire.TireFilter;

import java.time.Instant;
import java.time.LocalDate;

public class VehicleTireFilter extends TireFilter {

    private Long id;
    private Integer productionYearStartsWith;
    private Integer productionYearEndWith;
    private LocalDate purchaseDateStartsWith;
    private LocalDate purchaseDateEndWith;
    private TireStatus tireStatus;
    private Instant createDateStartWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartWith;
    private Instant modifyDateEndWith;
    private Long vehicleId;
    private Long brandId;
    private String brandName;
    private Long modelId;
    private String modelName;
    private String registrationNumber;

    public VehicleTireFilter(Long id,
                             String brand,
                             String model,
                             Integer widthStartsWith,
                             Integer widthEndWith,
                             Integer profileStartsWith,
                             Integer profileEndWith,
                             Integer diameterStartsWith,
                             Integer diameterEndWith,
                             TireType type,
                             TireReinforcedIndex reinforcedIndex,
                             TireSpeedIndex speedIndex,
                             TireLoadCapacityIndex loadCapacityIndex,
                             TireSeasonType seasonType,
                             Boolean runOnFlat,
                             Instant createDateStartsWith,
                             Instant createDateEndWith,
                             Instant modifyDateStartsWith,
                             Instant modifyDateEndWith,
                             Instant removeDateStartsWith,
                             Instant removeDateEndWith,
                             Long id1,
                             Integer productionYearStartsWith,
                             Integer productionYearEndWith,
                             LocalDate purchaseDateStartsWith,
                             LocalDate purchaseDateEndWith,
                             TireStatus tireStatus,
                             Instant createDateStartWith,
                             Instant createDateEndWith1,
                             Instant modifyDateStartWith,
                             Instant modifyDateEndWith1,
                             Long vehicleId,
                             Long brandId,
                             String brandName,
                             Long modelId,
                             String modelName,
                             String registrationNumber) {
        super(id, brand, model, widthStartsWith, widthEndWith, profileStartsWith, profileEndWith, diameterStartsWith, diameterEndWith, type, reinforcedIndex, speedIndex, loadCapacityIndex, seasonType, runOnFlat, createDateStartsWith, createDateEndWith, modifyDateStartsWith, modifyDateEndWith, removeDateStartsWith, removeDateEndWith);
        this.id = id1;
        this.productionYearStartsWith = productionYearStartsWith;
        this.productionYearEndWith = productionYearEndWith;
        this.purchaseDateStartsWith = purchaseDateStartsWith;
        this.purchaseDateEndWith = purchaseDateEndWith;
        this.tireStatus = tireStatus;
        this.createDateStartWith = createDateStartWith;
        this.createDateEndWith = createDateEndWith1;
        this.modifyDateStartWith = modifyDateStartWith;
        this.modifyDateEndWith = modifyDateEndWith1;
        this.vehicleId = vehicleId;
        this.brandId = brandId;
        this.brandName = brandName;
        this.modelId = modelId;
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public TireStatus getTireStatus() {
        return tireStatus;
    }

    public void setTireStatus(TireStatus tireStatus) {
        this.tireStatus = tireStatus;
    }

    public Instant getCreateDateStartWith() {
        return createDateStartWith;
    }

    public void setCreateDateStartWith(Instant createDateStartWith) {
        this.createDateStartWith = createDateStartWith;
    }

    @Override
    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    @Override
    public void setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
    }

    public Instant getModifyDateStartWith() {
        return modifyDateStartWith;
    }

    public void setModifyDateStartWith(Instant modifyDateStartWith) {
        this.modifyDateStartWith = modifyDateStartWith;
    }

    @Override
    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    @Override
    public void setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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
}
