package pl.com.chrzanowski.scma.service.filter.vehicle;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.Vehicle;

import java.time.Instant;
import java.time.LocalDate;

@Component
public class VehicleSpecification {
    private static final String ID = "id";
    private static final String BRAND_ID = "brandId";
    private static final String BRAND_NAME = "brandName";
    private static final String MODEL_ID = "modelId";
    private static final String MODEL_NAME = "modelName";
    private static final String REGISTRATION_NUMBER = "registrationNumber";
    private static final String VIN = "vin";
    private static final String PRODUCTION_YEAR = "productionYear";
    private static final String FIRST_REGISTRATION_DATE = "firstRegistrationDate";
    private static final String FREE_PLACES_FOR_TECH_INSPECTION = "freePlacesForTechInspection";
    private static final String FUEL_TYPE_ID = "fuelTypeId";
    private static final String FUEL_TYPE_NAME = "fuelTypeName";
    private static final String VEHICLE_TYPE_ID = "vehicleTypeId";
    private static final String VEHICLE_TYPE_NAME = "vehicleTypeName";
    private static final String LENGTH = "length";
    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String CREATE_DATE = "createDate";
    private static final String MODIFY_DATE = "modifyDate";

    public static Specification<Vehicle> createSpecification(VehicleFilter filter) {
        Specification<Vehicle> specification = Specification.where(null);
        if (filter != null) {
            if (filter.getId() != null) {
                specification = specification.and(hasId(filter.getId(), ID));
            }
            if (filter.getBrandId() != null) {
                specification = specification.and(hasId(filter.getId(), BRAND_ID));
            }
            if (filter.getModelId() != null) {
                specification = specification.and(hasId(filter.getId(), MODEL_ID));
            }
            if (filter.getFuelTypeId() != null) {
                specification = specification.and(hasId(filter.getId(), FUEL_TYPE_ID));
            }
            if (filter.getVehicleTypeId() != null) {
                specification = specification.and(hasId(filter.getId(), VEHICLE_TYPE_ID));
            }
            if (filter.getBrandName() != null) {
                specification = specification.and(hasString(filter.getBrandName(), BRAND_NAME));
            }
            if (filter.getModelName() != null) {
                specification = specification.and(hasString(filter.getModelName(), MODEL_NAME));
            }
            if (filter.getFuelTypeName() != null) {
                specification = specification.and(hasString(filter.getFuelTypeName(), FUEL_TYPE_NAME));
            }
            if (filter.getVehicleTypeName() != null) {
                specification = specification.and(hasString(filter.getVehicleTypeName(), VEHICLE_TYPE_NAME));
            }
            if (filter.getRegistrationNumber() != null) {
                specification = specification.and(hasString(filter.getRegistrationNumber(), REGISTRATION_NUMBER));
            }
            if (filter.getVin() != null) {
                specification = specification.and(hasString(filter.getVin(), VIN));
            }
            if (filter.getProductionYearStartWith() != null) {
                specification = specification.and(hasShortTypeGreaterOrEqual(filter.getProductionYearStartWith(),
                        PRODUCTION_YEAR));
            }
            if (filter.getProductionYearEndWith() != null) {
                specification = specification.and(hasShortTypeLesserOrEqual(filter.getProductionYearEndWith(),
                        PRODUCTION_YEAR));
            }
            if (filter.getFreePlacesForTechInspectionStartWith() != null) {
                specification = specification.and(hasShortTypeGreaterOrEqual(filter.getFreePlacesForTechInspectionStartWith(),
                        FREE_PLACES_FOR_TECH_INSPECTION));
            }
            if (filter.getFreePlacesForTechInspectionEndWith() != null) {
                specification = specification.and(hasShortTypeLesserOrEqual(filter.getFreePlacesForTechInspectionEndWith(),
                        FREE_PLACES_FOR_TECH_INSPECTION));
            }
            if (filter.getFirstRegistrationDateStartWith() != null) {
                specification = specification.and(hasDateStartWith(filter.getFirstRegistrationDateStartWith(),
                        FIRST_REGISTRATION_DATE));
            }
            if (filter.getFirstRegistrationDateEndWith() != null) {
                specification = specification.and(hasDateEndWith(filter.getFirstRegistrationDateEndWith(),
                        FIRST_REGISTRATION_DATE));
            }
            if (filter.getHeightStartWith() != null) {
                specification = specification.and(hasDimensionStartWith(filter.getHeightStartWith(), HEIGHT));
            }
            if (filter.getHeightEndWith() != null) {
                specification = specification.and(hasDimensionEndWith(filter.getHeightEndWith(), HEIGHT));
            }
            if (filter.getLengthStartWith() != null) {
                specification = specification.and(hasDimensionStartWith(filter.getLengthStartWith(), LENGTH));
            }
            if (filter.getLengthEndWith() != null) {
                specification = specification.and(hasDimensionEndWith(filter.getLengthEndWith(), LENGTH));
            }
            if (filter.getWidthStartWith() != null) {
                specification = specification.and(hasDimensionStartWith(filter.getWidthStartWith(), WIDTH));
            }
            if (filter.getWidthEndWith() != null) {
                specification = specification.and(hasDimensionEndWith(filter.getWidthEndWith(), WIDTH));
            }
            if (filter.getCreateDateStartWith() != null) {
                specification = specification.and(hasDateStartWith(filter.getCreateDateStartWith(), CREATE_DATE));
            }
            if (filter.getCreateDateEndWith() != null) {
                specification = specification.and(hasDateEndWith(filter.getCreateDateEndWith(), CREATE_DATE));
            }
            if (filter.getModifyDateStartWith() != null) {
                specification = specification.and(hasDateStartWith(filter.getModifyDateStartWith(), MODIFY_DATE));
            }
            if (filter.getModifyDateEndWith() != null) {
                specification = specification.and(hasDateEndWith(filter.getModifyDateEndWith(), MODIFY_DATE));
            }
        }
        return specification;
    }

    private static Specification<Vehicle> hasId(Long id, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Long>get(fieldType), id);
    }

    private static Specification<Vehicle> hasString(String text, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(fieldType), "%" + text + "%");
    }

    private static Specification<Vehicle> hasDateStartWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<Vehicle> hasDateEndWith(Instant date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<Vehicle> hasDateStartWith(LocalDate date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<Vehicle> hasDateEndWith(LocalDate date, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType),
                date);
    }

    private static Specification<Vehicle> hasDimensionStartWith(Float dimension, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType), dimension);
    }

    private static Specification<Vehicle> hasDimensionEndWith(Float dimension, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType), dimension);
    }

    private static Specification<Vehicle> hasShortTypeGreaterOrEqual(Short aShort, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(fieldType), aShort);
    }

    private static Specification<Vehicle> hasShortTypeLesserOrEqual(Short aShort, String fieldType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(fieldType), aShort);
    }
}
