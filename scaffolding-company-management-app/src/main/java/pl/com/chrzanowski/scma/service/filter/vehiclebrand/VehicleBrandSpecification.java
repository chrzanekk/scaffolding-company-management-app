package pl.com.chrzanowski.scma.service.filter.vehiclebrand;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.service.filter.SearchCriteria;
import pl.com.chrzanowski.scma.service.filter.SearchOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Component
public class VehicleBrandSpecification implements Specification<VehicleBrand> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATE_DATE = "createDate";
    public static final String MODIFY_DATE = "modifyDate";
    public static final String REMOVE_DATE = "removeDate";

    private final VehicleBrandFilter vehicleBrandFilter;

    public VehicleBrandSpecification() {
        this.vehicleBrandFilter = new VehicleBrandFilter();
    }

    private VehicleBrandSpecification(Builder builder) {
        vehicleBrandFilter = builder.vehicleBrandFilter;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public Predicate toPredicate(Root<VehicleBrand> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        List<SearchCriteria> searchCriteria = createSearchCriteria(vehicleBrandFilter);
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

    private List<SearchCriteria> createSearchCriteria(VehicleBrandFilter vehicleBrandFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (vehicleBrandFilter != null) {
            if (vehicleBrandFilter.getId() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(ID)
                        .value(vehicleBrandFilter.getId())
                        .operation(SearchOperation.EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(NAME)
                        .value(vehicleBrandFilter.getName())
                        .operation(SearchOperation.MATCH_START)
                        .build());
            }
            if (vehicleBrandFilter.getCreateDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(vehicleBrandFilter.getCreateDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getCreateDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(vehicleBrandFilter.getCreateDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getModifyDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(vehicleBrandFilter.getModifyDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getModifyDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(vehicleBrandFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getRemoveDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(vehicleBrandFilter.getRemoveDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (vehicleBrandFilter.getRemoveDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(vehicleBrandFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
        }
        return searchCriteria;
    }

    @Override
    public Specification<VehicleBrand> and(Specification<VehicleBrand> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<VehicleBrand> or(Specification<VehicleBrand> other) {
        return Specification.super.or(other);
    }


    public static final class Builder {
        private VehicleBrandFilter vehicleBrandFilter;

        private Builder() {
        }

        public Builder vehicleBrandFilter(VehicleBrandFilter vehicleBrandFilter) {
            this.vehicleBrandFilter = vehicleBrandFilter;
            return this;
        }

        public VehicleBrandSpecification build() {
            return new VehicleBrandSpecification(this);
        }
    }
}
