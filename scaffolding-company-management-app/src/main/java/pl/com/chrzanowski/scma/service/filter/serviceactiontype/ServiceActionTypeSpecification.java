package pl.com.chrzanowski.scma.service.filter.serviceactiontype;

import org.springframework.data.jpa.domain.Specification;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.service.filter.SearchCriteria;
import pl.com.chrzanowski.scma.service.filter.SearchOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ServiceActionTypeSpecification implements Specification<ServiceActionType> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATE_DATE = "createDate";
    public static final String MODIFY_DATE = "modifyDate";
    public static final String REMOVE_DATE = "removeDate";

    private final ServiceActionTypeFilter serviceActionTypeFilter;

    public ServiceActionTypeSpecification(ServiceActionTypeFilter serviceActionTypeFilter) {
        this.serviceActionTypeFilter = new ServiceActionTypeFilter();
    }

    private ServiceActionTypeSpecification(Builder builder) {
        serviceActionTypeFilter = builder.serviceActionTypeFilter;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Predicate toPredicate(Root<ServiceActionType> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        List<SearchCriteria> searchCriteria = createSearchCriteria(serviceActionTypeFilter);
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

    private List<SearchCriteria> createSearchCriteria(ServiceActionTypeFilter serviceActionTypeFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (serviceActionTypeFilter != null) {
            if (serviceActionTypeFilter.getId() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(ID)
                        .value(serviceActionTypeFilter.getId())
                        .operation(SearchOperation.EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(NAME)
                        .value(serviceActionTypeFilter.getName())
                        .operation(SearchOperation.MATCH_START)
                        .build());
            }
            if (serviceActionTypeFilter.getCreateDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(serviceActionTypeFilter.getCreateDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getCreateDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(CREATE_DATE)
                        .value(serviceActionTypeFilter.getCreateDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getModifyDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(serviceActionTypeFilter.getModifyDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getModifyDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(MODIFY_DATE)
                        .value(serviceActionTypeFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getRemoveDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(serviceActionTypeFilter.getRemoveDateStartWith())
                        .operation(SearchOperation.GREATER_THAN_EQUAL)
                        .build());
            }
            if (serviceActionTypeFilter.getRemoveDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder()
                        .key(REMOVE_DATE)
                        .value(serviceActionTypeFilter.getModifyDateEndWith())
                        .operation(SearchOperation.LESS_THAN_EQUAL)
                        .build());
            }
        }
        return searchCriteria;
    }

    @Override
    public Specification<ServiceActionType> and(Specification<ServiceActionType> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<ServiceActionType> or(Specification<ServiceActionType> other) {
        return Specification.super.or(other);
    }


    public static final class Builder {
        private ServiceActionTypeFilter serviceActionTypeFilter;

        private Builder() {
        }

        public Builder serviceActionTypeFilter(ServiceActionTypeFilter serviceActionTypeFilter) {
            this.serviceActionTypeFilter = serviceActionTypeFilter;
            return this;
        }

        public ServiceActionTypeSpecification build() {
            return new ServiceActionTypeSpecification(this);
        }
    }
}
