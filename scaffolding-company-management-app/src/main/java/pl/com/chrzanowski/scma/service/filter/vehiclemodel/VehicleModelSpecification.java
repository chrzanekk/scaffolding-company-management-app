package pl.com.chrzanowski.scma.service.filter.vehiclemodel;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleModel;
import pl.com.chrzanowski.scma.service.filter.SearchCriteria;
import pl.com.chrzanowski.scma.service.filter.SearchOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Component
public class VehicleModelSpecification implements Specification<VehicleModel> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String BRAND_ID = "vehicleBrandId";
    public static final String BRAND_NAME = "vehicleBrandName";
    public static final String CREATE_DATE = "createDate";
    public static final String MODIFY_DATE = "modifyDate";
    public static final String REMOVE_DATE = "removeDate";

    private final VehicleModelFilter vehicleModelFilter;

    public VehicleModelSpecification() {
        this.vehicleModelFilter = new VehicleModelFilter();
    }

    private VehicleModelSpecification(Builder builder) {
        vehicleModelFilter = builder.vehicleModelFilter;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Predicate toPredicate(Root<VehicleModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<SearchCriteria> searchCriteria = createSearchCriteria(vehicleModelFilter);

        List<Predicate> predicates = new ArrayList<>();
        searchCriteria.forEach(criteria -> {
            if (criteria.getOperation()
                    .equals(SearchOperation.GREATER_THAN)) {
                predicates.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue()
                        .toString()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.LESS_THAN)) {
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue()
                        .toString()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue()
                        .toString()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue()
                        .toString()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.EQUAL)) {
                predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.MATCH)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), "%" + criteria.getValue()
                        .toString()
                        .toLowerCase() + "%"));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.MATCH_END)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), criteria.getValue()
                        .toString()
                        .toLowerCase() + "%"));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.MATCH_START)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), "%" + criteria.getValue()
                        .toString()
                        .toLowerCase()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.IN)) {
                predicates.add(criteriaBuilder.in(root.get(criteria.getKey()))
                        .value(criteria.getValue()));
            } else if (criteria.getOperation()
                    .equals(SearchOperation.NOT_IN)) {
                predicates.add(criteriaBuilder.not(root.get(criteria.getKey()))
                        .in(criteria.getValue()));
            }
        });

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private List<SearchCriteria> createSearchCriteria(VehicleModelFilter vehicleModelFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (vehicleModelFilter != null) {
            if (vehicleModelFilter.getId() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(ID)
                        .value(vehicleModelFilter.getId())
                        .operation(SearchOperation.EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(NAME)
                        .value(vehicleModelFilter.getName())
                        .operation(SearchOperation.MATCH_START)
                        .build());
            }
            if (vehicleModelFilter.getVehicleBrandId() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(BRAND_ID)
                        .value(vehicleModelFilter.getId())
                        .operation(SearchOperation.EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(BRAND_NAME)
                        .value(vehicleModelFilter.getName())
                        .operation(SearchOperation.MATCH_START)
                        .build());
            }
            if (vehicleModelFilter.getCreateDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(vehicleModelFilter.getCreateDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getCreateDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(vehicleModelFilter.getCreateDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getModifyDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(vehicleModelFilter.getModifyDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getModifyDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(vehicleModelFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getRemoveDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(vehicleModelFilter.getRemoveDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleModelFilter.getRemoveDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(vehicleModelFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
        }
        return searchCriteria;
    }

    @Override
    public Specification<VehicleModel> and(Specification<VehicleModel> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<VehicleModel> or(Specification<VehicleModel> other) {
        return Specification.super.or(other);
    }


    public static final class Builder {
        private VehicleModelFilter vehicleModelFilter;

        private Builder() {
        }

        public Builder vehicleModelFilter(VehicleModelFilter vehicleModelFilter) {
            this.vehicleModelFilter = vehicleModelFilter;
            return this;
        }

        public VehicleModelSpecification build() {
            return new VehicleModelSpecification(this);
        }
    }
}
