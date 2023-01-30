package pl.com.chrzanowski.scma.model;

import java.util.Objects;

public class RoleDTO {
    private long id;
    private String name;

    public RoleDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO() {
    }

    private RoleDTO(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return id == roleDTO.id && Objects.equals(name, roleDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public static final class Builder {
        private long id;
        private String name;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public RoleDTO build() {
            return new RoleDTO(this);
        }
    }
}
