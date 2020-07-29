package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.State} entity. This class is used
 * in {@link gov.naco.soch.web.rest.StateResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /states?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class StateCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter alternateName;

    private StringFilter name;

    public StateCriteria() {
    }

    public StateCriteria(StateCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.alternateName = other.alternateName == null ? null : other.alternateName.copy();
        this.name = other.name == null ? null : other.name.copy();
    }

    @Override
    public StateCriteria copy() {
        return new StateCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(StringFilter alternateName) {
        this.alternateName = alternateName;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final StateCriteria that = (StateCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(alternateName, that.alternateName) &&
            Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        alternateName,
        name
        );
    }

    @Override
    public String toString() {
        return "StateCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (alternateName != null ? "alternateName=" + alternateName + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
            "}";
    }

}
