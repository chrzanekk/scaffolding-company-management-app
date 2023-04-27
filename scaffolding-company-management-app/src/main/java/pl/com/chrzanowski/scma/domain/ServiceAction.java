package pl.com.chrzanowski.scma.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "service_action")
public class ServiceAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_mileage")
    @NotNull
    private Integer carMileage;
    @Column(name = "invoice_no")
    @NotNull
    private String invoiceNumber;
    @Column(name = "invoice_groos_value")
    @NotNull
    private BigDecimal grossValue;
    @Column(name = "tax_value")
    @NotNull
    private BigDecimal taxValue;
    @Column(name = "invoice_net_value")
    @NotNull
    private BigDecimal netValue;
    @Column(name = "tax_rate")
    @NotNull
    private BigDecimal taxRate;
    @Column(name = "service_date")
    @NotNull
    private LocalDate serviceDate;
    @Column(name = "description", length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    @NotNull
    private Workshop workshop;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @NotNull
    private Vehicle vehicle;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    private Instant createDate;
    @Column(name = "modify_date", columnDefinition = "DATETIME")
    private Instant modifyDate;
    @Column(name = "remove_date", columnDefinition = "DATETIME")
    private Instant removeDate;
}
