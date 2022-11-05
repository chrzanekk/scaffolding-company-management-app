package pl.com.chrzanowski.scma.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "authorities")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private Set<User> users;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Authority [name=").append(name).append("]").append("id=[").append(id).append("]");
        return builder.toString();
    }
}
