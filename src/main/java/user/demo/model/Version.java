package user.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
/*@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter*/
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Version() {
    }

    public Version(String name) {
        this.name = name;
    }

    public Version(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
