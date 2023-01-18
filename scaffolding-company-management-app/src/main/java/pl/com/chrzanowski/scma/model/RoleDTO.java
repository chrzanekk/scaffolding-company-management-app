package pl.com.chrzanowski.scma.model;

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

        if (id != roleDTO.id) return false;
        return name != null ? name.equals(roleDTO.name) : roleDTO.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
