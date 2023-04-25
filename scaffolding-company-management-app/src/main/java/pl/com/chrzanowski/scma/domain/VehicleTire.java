package pl.com.chrzanowski.scma.domain;

import pl.com.chrzanowski.scma.domain.enumeration.TireStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "vehicle_tires")
public class VehicleTire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private TireStatus tireStatus;

    @Column(name = "production_year")
    @NotNull
    @NotBlank
    private Integer productionYear;


    @Column(name = "purchase_date")
    @NotNull
    @NotBlank
    private LocalDate purchaseDate;

    @OneToOne
    @JoinColumn(name = "tires_id", referencedColumnName = "id")
    private Tire tire;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    public VehicleTire(Long id,
                       TireStatus tireStatus,
                       Integer productionYear,
                       LocalDate purchaseDate,
                       Tire tire,
                       Vehicle vehicle) {
        this.id = id;
        this.tireStatus = tireStatus;
        this.productionYear = productionYear;
        this.purchaseDate = purchaseDate;
        this.tire = tire;
        this.vehicle = vehicle;
    }

    public VehicleTire() {
    }

    public Long getId() {
        return id;
    }

    public TireStatus getTireStatus() {
        return tireStatus;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public Tire getTire() {
        return tire;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleTire setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleTire setTireStatus(TireStatus tireStatus) {
        this.tireStatus = tireStatus;
        return this;
    }

    public VehicleTire setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public VehicleTire setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public VehicleTire setTire(Tire tire) {
        this.tire = tire;
        return this;
    }

    public VehicleTire setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleTire that = (VehicleTire) o;

        if (!Objects.equals(id, that.id)) return false;
        if (tireStatus != that.tireStatus) return false;
        if (!Objects.equals(productionYear, that.productionYear))
            return false;
        if (!Objects.equals(purchaseDate, that.purchaseDate)) return false;
        if (!Objects.equals(tire, that.tire)) return false;
        return Objects.equals(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tireStatus != null ? tireStatus.hashCode() : 0);
        result = 31 * result + (productionYear != null ? productionYear.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (tire != null ? tire.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTire{" +
                "id=" + id +
                ", tireStatus=" + tireStatus +
                ", productionYear=" + productionYear +
                ", purchaseDate=" + purchaseDate +
                ", tire=" + tire +
                ", vehicle=" + vehicle +
                '}';
    }
}
