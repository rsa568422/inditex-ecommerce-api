package org.inditex.ecommerce.api.persistence.entities;

import lombok.*;
import org.iditex.ecommerce.model.entities.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sizes")
public class SizeDto implements Serializable {

    @Id
    @PrimaryKeyJoinColumn
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "back_soon")
    private boolean backSoon;

    private boolean special;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = StockDto.class)
    @JoinColumn(name = "id")
    private StockDto stock;

    public Size toModel() {
        if (stock == null) return new Size(id, productId, backSoon, special);
        return new Size(id, productId, backSoon, special, stock.toModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeDto dto = (SizeDto) o;
        return backSoon == dto.backSoon && special == dto.special && Objects.equals(id, dto.id) && Objects.equals(productId, dto.productId) && Objects.equals(stock, dto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, backSoon, special, stock);
    }

}
