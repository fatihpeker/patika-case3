package tr.softtech.patika.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import tr.softtech.patika.enums.RoleType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String user_id;

    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Email
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "phone_number",unique = true,nullable = false)
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",length = 30)
    private RoleType roleType;

    @OneToMany(mappedBy = "ownerUser",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> commentSet = new HashSet<>();
}
