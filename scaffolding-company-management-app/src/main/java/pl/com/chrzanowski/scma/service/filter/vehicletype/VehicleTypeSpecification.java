package pl.com.chrzanowski.scma.service.filter.vehicletype;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleType;
import pl.com.chrzanowski.scma.service.filter.SearchCriteria;
import pl.com.chrzanowski.scma.service.filter.SearchOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Component
public class VehicleTypeSpecification implements Specification<VehicleType> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATE_DATE = "createDate";
    public static final String MODIFY_DATE = "modifyDate";
    public static final String REMOVE_DATE = "removeDate";

    private final VehicleTypeFilter vehicleTypeFilter;

    public VehicleTypeSpecification() {
        this.vehicleTypeFilter = new VehicleTypeFilter();
    }

    private VehicleTypeSpecification(Builder builder) {
        vehicleTypeFilter = builder.vehicleTypeFilter;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Predicate toPredicate(Root<VehicleType> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<SearchCriteria> searchCriteria = createSearchCriteria(vehicleTypeFilter);
        List<Predicate> predicates = new ArrayList<>();

        searchCriteria.forEach(criteria -> {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase()));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(criteriaBuilder.in(root.get(criteria.getKey())).value(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(criteriaBuilder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        });

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private List<SearchCriteria> createSearchCriteria(VehicleTypeFilter vehicleTypeFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (vehicleTypeFilter != null) {
            if (vehicleTypeFilter.getId() != null) {
                searchCriteria.add(SearchCriteria.builder().key(ID).value(vehicleTypeFilter.getId()).operation(SearchOperation.EQUAL).build());
            }
            if (vehicleTypeFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder().key(NAME).value(vehicleTypeFilter.getName()).operation(SearchOperation.MATCH_START).build());
            }
            if (vehicleTypeFilter.getCreateDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(CREATE_DATE).value(vehicleTypeFilter.getCreateDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (vehicleTypeFilter.getCreateDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(CREATE_DATE).value(vehicleTypeFilter.getCreateDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
            if (vehicleTypeFilter.getModifyDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(MODIFY_DATE).value(vehicleTypeFilter.getModifyDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (vehicleTypeFilter.getModifyDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(MODIFY_DATE).value(vehicleTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
            if (vehicleTypeFilter.getRemoveDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(REMOVE_DATE).value(vehicleTypeFilter.getRemoveDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (vehicleTypeFilter.getRemoveDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(REMOVE_DATE).value(vehicleTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
        }
        return searchCriteria;
    }

    @Override
    public Specification<VehicleType> and(Specification<VehicleType> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<VehicleType> or(Specification<VehicleType> other) {
        return Specification.super.or(other);
    }


    public static final class Builder {
        private VehicleTypeFilter vehicleTypeFilter;

        private Builder() {
        }

        public Builder vehicleTypeFilter(VehicleTypeFilter vehicleTypeFilter) {
            this.vehicleTypeFilter = vehicleTypeFilter;
            return this;
        }

        public VehicleTypeSpecification build() {
            return new VehicleTypeSpecification(this);
        }
    }
}
