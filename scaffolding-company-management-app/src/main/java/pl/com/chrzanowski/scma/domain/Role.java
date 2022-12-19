package pl.com.chrzanowski.scma.domain;

import lombok.*;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(ERole name) {
        this.name = name;
    }
}