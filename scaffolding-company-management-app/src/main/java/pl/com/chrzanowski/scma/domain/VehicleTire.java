package pl.com.chrzanowski.scma.domain;

import pl.com.chrzanowski.scma.domain.enumeration.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "vehicle_tires")
public class VehicleTire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    @NotNull
    @NotBlank
    private String brand;

    @Column(name = "model")
    @NotNull
    @NotBlank
    private String model;

    @Column(name = "width")
    @NotNull
    @NotBlank
    private Integer width;

    @Column(name = "profile")
    @NotNull
    @NotBlank
    private Integer profile;

    @Column(name = "diameter")
    @NotNull
    @NotBlank
    private Integer diameter;
    @Column(name = "type")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TireType type;

    @Column(name = "reinforced_index")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TireReinforcedIndex tireReinforcedIndex;
    @Column(name = "speed_index")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TireSpeedIndex speedIndex;

    @Column(name = "capacity_index")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TireLoadCapacityIndex capacityIndex;
    @Column(name = "season_type")
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TireSeasonType tireSeasonType;

    @Column(name = "run_on_flat")
    @NotNull
    @NotBlank
    private Boolean runOnFlat;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;


    public VehicleTire(Long id,
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
                       Vehicle vehicle,
                       Instant createDate,
                       Instant modifyDate,
                       Instant removeDate) {
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
        this.vehicle = vehicle;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    public VehicleTire() {
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

    public Vehicle getVehicle() {
        return vehicle;
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

    public VehicleTire setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleTire setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public VehicleTire setModel(String model) {
        this.model = model;
        return this;
    }

    public VehicleTire setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public VehicleTire setProfile(Integer profile) {
        this.profile = profile;
        return this;
    }

    public VehicleTire setDiameter(Integer diameter) {
        this.diameter = diameter;
        return this;
    }

    public VehicleTire setType(TireType type) {
        this.type = type;
        return this;
    }

    public VehicleTire setTireReinforcedIndex(TireReinforcedIndex tireReinforcedIndex) {
        this.tireReinforcedIndex = tireReinforcedIndex;
        return this;
    }

    public VehicleTire setSpeedIndex(TireSpeedIndex speedIndex) {
        this.speedIndex = speedIndex;
        return this;
    }

    public VehicleTire setCapacityIndex(TireLoadCapacityIndex capacityIndex) {
        this.capacityIndex = capacityIndex;
        return this;
    }

    public VehicleTire setTireSeasonType(TireSeasonType tireSeasonType) {
        this.tireSeasonType = tireSeasonType;
        return this;
    }

    public VehicleTire setRunOnFlat(Boolean runOnFlat) {
        this.runOnFlat = runOnFlat;
        return this;
    }

    public VehicleTire setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public VehicleTire setCreateDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public VehicleTire setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public VehicleTire setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleTire that = (VehicleTire) o;

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
        if (!Objects.equals(vehicle, that.vehicle)) return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(modifyDate, that.modifyDate)) return false;
        return Objects.equals(removeDate, that.removeDate);
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
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTire{" +
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
                ", vehicle=" + vehicle +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }
}
