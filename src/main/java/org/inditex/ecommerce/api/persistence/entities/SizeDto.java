package org.inditex.ecommerce.api.persistence.entities;

import lombok.*;
import org.iditex.ecommerce.model.entities.Size;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sizes")
public class SizeDto implements Serializable {

    @Id
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "back_soon")
    private boolean backSoon;

    private boolean special;

    @OneToOne
    @JoinColumn(name = "size_id")
    private StockDto stock;

    public Size toModel() {
        if (stock == null) return new Size(id, productId, backSoon, special);
        return new Size(id, productId, backSoon, special, stock.toModel());
    }
}
