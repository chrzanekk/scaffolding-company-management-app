package pl.com.chrzanowski.scma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


}
