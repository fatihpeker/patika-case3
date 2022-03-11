package tr.softtech.patika.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import tr.softtech.patika.enums.Category;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends BaseEntity {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String product_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price",precision = 19,scale = 3)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 30)
    private Category category;

    @OneToMany(mappedBy = "ownerProduct",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> commentSet;


}
