package pl.com.chrzanowski.scma.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "vehicle_model", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class VehicleModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull
    @NotBlank
    private String name;

    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_brand")
    private VehicleBrand vehicleBrand;

    public VehicleModel(Long id,
                        String name,
                        Instant createDate,
                        Instant modifyDate,
                        Instant removeDate,
                        VehicleBrand vehicleBrand) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
        this.vehicleBrand = vehicleBrand;
    }

    public VehicleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
    }

    public VehicleBrand getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(VehicleBrand vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleModel that = (VehicleModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDate, that.createDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(removeDate, that.removeDate) && Objects.equals(vehicleBrand, that.vehicleBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, modifyDate, removeDate, vehicleBrand);
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                ", vehicleBrand=" + vehicleBrand +
                '}';
    }
}
