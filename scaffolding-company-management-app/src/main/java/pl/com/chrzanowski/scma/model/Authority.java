package pl.com.chrzanowski.scma.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "authorities")
public class Authority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDateTime;

    @Column(name = "modify_date")
    private LocalDateTime modifyDateTime;

    @Column(name = "remove_date")
    private LocalDateTime removeDateTime;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();

    public Authority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(LocalDateTime modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public LocalDateTime getRemoveDateTime() {
        return removeDateTime;
    }

    public void setRemoveDateTime(LocalDateTime removeDateTime) {
        this.removeDateTime = removeDateTime;
    }
}
