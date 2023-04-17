package pl.com.chrzanowski.scma.service.filter.vehicletire;

import org.springframework.data.jpa.domain.Specification;
import pl.com.chrzanowski.scma.domain.Vehicle;
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.domain.VehicleModel;
import pl.com.chrzanowski.scma.domain.VehicleTire;
import pl.com.chrzanowski.scma.domain.enumeration.*;

import javax.persistence.criteria.Join;
import java.time.Instant;
import java.time.LocalDate;

public class VehicleTireSpecification {

    private static final String ID = "id";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String WIDTH = "width";
    private static final String PROFILE = "profile";
    private static final String TYPE = "type";
    private static final String TIRE_REINFORCED_INDEX = "tireReinforcedIndex";
    private static final String SPEED_INDEX = "speedIndex";
    private static final String CAPACITY_INDEX = "capacityIndex";
    private static final String TIRE_SEASON_TYPE = "tireSeasonType";
    private static final String RUN_ON_FLAT = "runOnFlat";
    private static final String VEHICLE = "vehicle";
    private static final String VEHICLE_ID = "vehicleId";
    private static final String VEHICLE_BRAND_ID = "vehicleBrandId";
    private static final String VEHICLE_MODEL_ID = "vehicleModelId";
    private static final String VEHICLE_BRAND_NAME = "vehicleBrandName";
    private static final String VEHICLE_MODEL_NAME = "vehicleModelName";
    private static final String PRODUCTION_YEAR = "productionYear";
    private static final String PURCHASE_DATE = "purchaseDate";
    private static final String CREATE_DATE = "createDate";
    private static final String MODIFY_DATE = "modifyDate";
    private static final String VEHICLE_BRAND = "vehicleBrand";
    private static final String VEHICLE_MODEL = "vehicleModel";

    public static Specification<VehicleTire> create(VehicleTireFilter filter) {
        Specification<VehicleTire> specification = Specification.where(null);
        if (filter != null) {
            if (filter.getId() != null) {
                specification = specification.and(hasId(filter.getId(), ID));
            }
            if (filter.getBrand() != null) {
                specification = specification.and(hasString(filter.getBrand(), BRAND));
            }
            if (filter.getModel() != null) {
                specification = specification.and(hasString(filter.getModel(), MODEL));
            }
            if (filter.getVehicleId() != null) {
                specification = specification.and(hasVehicleId(filter.getVehicleId()));
            }
            if (filter.getVehicleModelId() != null) {
                specification = specification.and(hasModelId(filter.getVehicleModelId()));
            }
            if (filter.getVehicleModelName() != null) {
                specification = specification.and(hasModelName(filter.getVehicleModelName()));
            }
            if (filter.getVehicleBrandId() != null) {
                specification = specification.and(hasBrandId(filter.getVehicleBrandId()));
            }
            if (filter.getVehicleBrandName() != null) {
                specification = specification.and(hasBrandName(filter.getVehicleBrandName()));
            }
            if (filter.getWidthStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartWith(filter.getWidthStartsWith(), WIDTH));
            }
            if (filter.getWidthEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWith(filter.getWidthEndWith(), WIDTH));
            }
            if (filter.getProfileStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartWith(filter.getProfileStartsWith(), PROFILE));
            }
            if (filter.getProfileEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWith(filter.getProfileEndWith(), PROFILE));
            }
            if (filter.getType() != null) {
                specification = specification.and(hasTireType(filter.getType()));
            }
            if (filter.getReinforcedIndex() != null) {
                specification = specification.and(hasReinforcedIndex(filter.getReinforcedIndex()));
            }
            if (filter.getSpeedIndex() != null) {
                specification = specification.and(hasSpeedIndex(filter.getSpeedIndex()));
            }
            if (filter.getLoadCapacityIndex() != null) {
                specification = specification.and(hasLoadCapacityIndex(filter.getLoadCapacityIndex()));
            }
            if (filter.getSeasonType() != null) {
                specification = specification.and(hasSeasonType(filter.getSeasonType()));
            }
            if (filter.getRunOnFlat() != null) {
                specification = specification.and(hasRunOnFlat(filter.getRunOnFlat()));
            }
            if (filter.getProductionYearStartsWith() != null) {
                specification = specification.and(hasIntegerTypeStartWith(filter.getProductionYearStartsWith(), PRODUCTION_YEAR));
            }
            if (filter.getProductionYearEndWith() != null) {
                specification = specification.and(hasIntegerTypeEndWith(filter.getProductionYearEndWith(), PRODUCTION_YEAR));
            }
            if (filter.getPurchaseDateStartsWith() != null) {
                specification = specification.and(hasDateStartWith(filter.getPurchaseDateStartsWith(), PURCHASE_DATE));
            }
            if (filter.getPurchaseDateEndWith() != null) {
                specification = specification.and(hasDateEndWith(filter.getPurchaseDateEndWith(), PURCHASE_DATE));
            }
            if(filter.getCreateDateStartsWith() != null)


        }
        return specification;
    }

    private static Specification<VehicleTire> hasId(Long id, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Long>get(fieldType), id);
    }

    private static Specification<VehicleTire> hasString(String text, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(fieldType), "%" + text + "%");
    }

    private static Specification<VehicleTire> hasInstantDateStartWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasInstantDateEndWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasDateStartWith(LocalDate date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasDateEndWith(LocalDate date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<VehicleTire> hasIntegerTypeStartWith(Integer dimension, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType), dimension);
    }

    private static Specification<VehicleTire> hasIntegerTypeEndWith(Integer dimension, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType), dimension);
    }

    private static Specification<VehicleTire> hasTireType(TireType tireType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TYPE), tireType);
    }

    private static Specification<VehicleTire> hasReinforcedIndex(TireReinforcedIndex tireReinforcedIndex) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TIRE_REINFORCED_INDEX), tireReinforcedIndex);
    }

    private static Specification<VehicleTire> hasSpeedIndex(TireSpeedIndex tireSpeedIndex) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(SPEED_INDEX), tireSpeedIndex);
    }

    private static Specification<VehicleTire> hasLoadCapacityIndex(TireLoadCapacityIndex tireLoadCapacityIndex) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CAPACITY_INDEX), tireLoadCapacityIndex);
    }

    private static Specification<VehicleTire> hasSeasonType(TireSeasonType tireSeasonType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(TIRE_SEASON_TYPE), tireSeasonType);
    }

    private static Specification<VehicleTire> hasRunOnFlat(Boolean runOnFlat) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(RUN_ON_FLAT), runOnFlat);
    }

    private static Specification<VehicleTire> hasVehicleId(Long id) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleJoin = root.join(VEHICLE);
            return criteriaBuilder.equal(vehicleJoin.get(ID), id);
        };
    }

    private static Specification<VehicleTire> hasModelId(Long id) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelJoin = vehicleJoin.join(VEHICLE_MODEL);
            return criteriaBuilder.equal(vehicleModelJoin.get(ID), id);
        };
    }

    private static Specification<VehicleTire> hasModelName(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelJoin = vehicleJoin.join(VEHICLE_MODEL);
            return criteriaBuilder.like(vehicleModelJoin.get(VEHICLE_MODEL_NAME), "%" + name + "%");
        };
    }

    private static Specification<VehicleTire> hasBrandId(Long id) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelJoin = vehicleJoin.join(VEHICLE_MODEL);
            Join<VehicleBrand, VehicleModel> vehicleBrandVehicleModelJoin = vehicleModelJoin.join(VEHICLE_BRAND);
            return criteriaBuilder.equal(vehicleBrandVehicleModelJoin.get(ID), id);
        };
    }

    private static Specification<VehicleTire> hasBrandName(String name) {
        return (root, query, criteriaBuilder) -> {
            Join<Vehicle, VehicleTire> vehicleJoin = root.join(VEHICLE);
            Join<VehicleModel, Vehicle> vehicleModelJoin = vehicleJoin.join(VEHICLE_MODEL);
            Join<VehicleBrand, VehicleModel> vehicleBrandVehicleModelJoin = vehicleModelJoin.join(VEHICLE_BRAND);
            return criteriaBuilder.like(vehicleBrandVehicleModelJoin.get(VEHICLE_BRAND_NAME), "%" + name + "%");
        };
    }
}
