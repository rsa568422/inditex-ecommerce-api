package org.inditex.ecommerce.api.persistence.entities;

import lombok.*;
import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.entities.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductDto implements Serializable {

    @Id
    private Long id;

    private Long sequence;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<SizeDto> sizes;

    public Product toModel() {
        Set<Size> sizesModel = sizes.stream()
                .map(SizeDto::toModel)
                .collect(Collectors.toSet());
        return new Product(id, sequence, sizesModel);
    }

}
