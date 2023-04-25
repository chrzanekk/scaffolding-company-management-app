package pl.com.chrzanowski.scma.service.filter.vehicletire;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.*;
import pl.com.chrzanowski.scma.domain.enumeration.*;
import pl.com.chrzanowski.scma.service.filter.tire.TireSpecification;

import javax.persistence.criteria.Join;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class VehicleTireSpecification extends TireSpecification {
    private static final String ID = "id";
    private static final String PRODUCTION_YEAR = "productionYear";
    private static final String PURCHASE_DATE = "purchaseDate";
    private static final String TIRE_STATUS = "tireStatus";

    private static final String VEHICLE = "vehicle";
    private static final String VEHICLE_BRAND = "vehicleBrand";
    private static final String VEHICLE_MODEL = "vehicleModel";
    private static final String NAME = "name";
    private static final String REGISTRATION_NUMBER = "registrationNumber";
    private static final String CREATE_DATE = "createDate";
    private static final String MODIFY_DATE = "modifyDate";

    private static final String TIRE = "tire";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String WIDTH = "width";
    private static final String PROFILE = "profile";
    private static final String DIAMETER = "diameter";
    private static final String TYPE = "type";
    private static final String TIRE_REINFORCED_INDEX = "tireReinforcedIndex";
    private static final String SPEED_INDEX = "speedIndex";
    private static final String CAPACITY_INDEX = "capacityIndex";
    private static final String TIRE_SEASON_TYPE = "tireSeasonType";
    private static final String RUN_ON_FLAT = "runOnFlat";

    public static Specification<VehicleTire> create(VehicleTireFilter filter) {
        Specification<VehicleTire> specification = Specification.where(null);
        if (filter != null) {
            if (filter.getId() != null) {
                specification = specification.and(hasId(filter.getId()));
            }
            if (filter.getProductionYearStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartWith(filter.getProductionYearStartsWith()
                ));
            }
            if (filter.getProductionYearEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWith(filter.getProductionYearEndWith()));
            }
            if (filter.getPurchaseDateStartsWith() != null) {
                specification = specification.and(hasDateStartWith(filter.getPurchaseDateStartsWith()));
            }
            if (filter.getPurchaseDateEndWith() != null) {
                specification = specification.and(hasDateEndWith(filter.getPurchaseDateEndWith()));
            }
            if (filter.getTireStatus() != null) {
                specification = specification.and(hasTireStatus(filter.getTireStatus()));
            }
            if (filter.getBrand() != null) {
                specification = specification.and(hasStringTypeOnTire(filter.getBrand(), BRAND));
            }
            if (filter.getModel() != null) {
                specification = specification.and(hasStringTypeOnTire(filter.getModel(), MODEL));
            }
            if (filter.getWidthStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartsWithOnTire(filter.getWidthStartsWith(), WIDTH));
            }
            if (filter.getWidthEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWithOnTire(filter.getWidthEndWith(), WIDTH));
            }
            if (filter.getProfileStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartsWithOnTire(filter.getProfileStartsWith(),
                        PROFILE));
            }
            if (filter.getProfileEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWithOnTire(filter.getProfileEndWith(),
                        PROFILE));
            }
            if (filter.getDiameterStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartsWithOnTire(filter.getDiameterStartsWith(),
                        DIAMETER));
            }
            if (filter.getDiameterEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWithOnTire(filter.getDiameterEndWith(),
                        DIAMETER));
            }
            if (filter.getType() != null) {
                specification = specification.and(hasTireTypeOnTire(filter.getType()));
            }
            if (filter.getReinforcedIndex() != null) {
                specification = specification.and(hasReinforcedIndexOnTire(filter.getReinforcedIndex()));
            }
            if (filter.getSpeedIndex() != null) {
                specification = specification.and(hasSpeedIndexOnTire(filter.getSpeedIndex()));
            }
            if (filter.getLoadCapacityIndex() != null) {
                specification = specification.and(hasLoadCapacityIndexOnTire(filter.getLoadCapacityIndex()));
            }
            if (filter.getSeasonType() != null) {
                specification = specification.and(hasSeasonTypeOnTire(filter.getSeasonType()));
            }
            if (filter.getRunOnFlat() != null) {
                specification = specification.and(hasRunOnFlat(filter.getRunOnFlat()));
            }
            if (filter.getBrandId() != null) {
                specification = specification.and(hasBrandIdOnVehicle(filter.getBrandId()));
            }
            if (filter.getBrandName() != null) {
                specification = specification.and(hasBrandNameOnVehicle(filter.getBrandName()));
            }
            if (filter.getModelId() != null) {
                specification = specification.and(hasModelIdOnVehicle(filter.getModelId()));
            }
            if (filter.getModelName() != null) {
                specification = specification.and(hasModelNameOnVehicle(filter.getModelName()));
            }
            if (filter.getRegistrationNumber() != null) {
                specification = specification.and(hasRegistrationNumberOnVehicle(filter.getRegistrationNumber()));
            }
            if (filter.getCreateDateStartWith() != null) {
                specification = specification.and(hasInstantDateStartWith(filter.getCreateDateStartWith(), CREATE_DATE));
            }
            if (filter.getCreateDateEndWith() != null) {
                specification = specification.and(hasInstantDateEndWith(filter.getCreateDateEndWith(), CREATE_DATE));
            }
            if (filter.getModifyDateStartWith() != null) {
                specification = specification.and(hasInstantDateStartWith(filter.getModifyDateStartWith(), MODIFY_DATE));
            }
            if (filter.getModifyDateEndWith() != null) {
                specification = specification.and(hasInstantDateEndWith(filter.getModifyDateEndWith(), MODIFY_DATE));
            }
        }
        return specification;
    }

    private static Specification<VehicleTire> hasId(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Long>get(ID), id);
    }

    private static Specification<VehicleTire> hasInstantDateStartWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasInstantDateEndWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasDateStartWith(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(PURCHASE_DATE),
                date);
    }

    private static Specification<VehicleTire> hasDateEndWith(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(PURCHASE_DATE),
                date);
    }

    private static Specification<VehicleTire> hasIntegerTypeStartWith(Integer dimension) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(PRODUCTION_YEAR), dimension);
    }

    private static Specification<VehicleTire> hasIntegerTypeEndWith(Integer dimension) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(PRODUCTION_YEAR), dimension);
    }


    private static Specification<VehicleTire> hasIntegerTypeStartsWithOnTire(Integer integer, String fieldType) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.greaterThanOrEqualTo(tireVehicleTireJoin.get(fieldType), integer);
        };
    }

    private static Specification<VehicleTire> hasIntegerTypeEndWithOnTire(Integer integer, String fieldType) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.greaterThanOrEqualTo(tireVehicleTireJoin.get(fieldType), integer);
        };
    }

    private static Specification<VehicleTire> hasStringTypeOnTire(String string, String fieldType) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.like(tireVehicleTireJoin.get(fieldType), "%" + string + "%");
        };
    }

    private static Specification<VehicleTire> hasTireStatus(TireStatus tireStatus) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TIRE_STATUS), tireStatus);
    }

    private static Specification<VehicleTire> hasTireTypeOnTire(TireType tireType) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(TYPE), tireType);
        };
    }

    private static Specification<VehicleTire> hasReinforcedIndexOnTire(TireReinforcedIndex tireReinforcedIndex) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(TIRE_REINFORCED_INDEX), tireReinforcedIndex);
        };
    }

    private static Specification<VehicleTire> hasSpeedIndexOnTire(TireSpeedIndex tireSpeedIndex) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(SPEED_INDEX), tireSpeedIndex);
        };
    }

    private static Specification<VehicleTire> hasLoadCapacityIndexOnTire(TireLoadCapacityIndex tireLoadCapacityIndex) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(CAPACITY_INDEX), tireLoadCapacityIndex);
        };
    }

    private static Specification<VehicleTire> hasSeasonTypeOnTire(TireSeasonType tireSeasonType) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(TIRE_SEASON_TYPE), tireSeasonType);
        };
    }

    private static Specification<VehicleTire> hasRunOnFlat(Boolean runOnFlat) {
        return (root, query, criteriaBuilder) -> {
            Join<Tire, VehicleTire> tireVehicleTireJoin = root.join(TIRE);
            return criteriaBuilder.equal(tireVehicleTireJoin.get(RUN_ON_FLAT), runOnFlat);
        };
    }

    private static Specification<VehicleTire> hasBrandIdOnVehicle(Long id) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleVehicleTireJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelVehicleJoin = vehicleVehicleTireJoin.join(VEHICLE_MODEL);
            Join<VehicleBrand, VehicleModel> vehicleBrandVehicleModelJoin = vehicleModelVehicleJoin.join(VEHICLE_BRAND);
            return criteriaBuilder.equal(vehicleBrandVehicleModelJoin.get(ID), id);
        };
    }

    private static Specification<VehicleTire> hasBrandNameOnVehicle(String brandName) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleVehicleTireJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelVehicleJoin = vehicleVehicleTireJoin.join(VEHICLE_MODEL);
            Join<VehicleBrand, VehicleModel> vehicleBrandVehicleModelJoin = vehicleModelVehicleJoin.join(VEHICLE_BRAND);
            return criteriaBuilder.like(vehicleBrandVehicleModelJoin.get(NAME), "%" + brandName + "%");
        };
    }

    private static Specification<VehicleTire> hasModelIdOnVehicle(Long id) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleVehicleTireJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelVehicleJoin = vehicleVehicleTireJoin.join(VEHICLE_MODEL);
            return criteriaBuilder.equal(vehicleModelVehicleJoin.get(ID), id);
        };
    }

    private static Specification<VehicleTire> hasModelNameOnVehicle(String modelName) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleVehicleTireJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelVehicleJoin = vehicleVehicleTireJoin.join(VEHICLE_MODEL);
            return criteriaBuilder.like(vehicleModelVehicleJoin.get(NAME), "%" + modelName + "%");
        };
    }

    private static Specification<VehicleTire> hasRegistrationNumberOnVehicle(String text) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleVehicleTireJoin = root.join(VEHICLE);
            return criteriaBuilder.like(vehicleVehicleTireJoin.get(REGISTRATION_NUMBER), "%" + text + "%");
        };
    }


}
