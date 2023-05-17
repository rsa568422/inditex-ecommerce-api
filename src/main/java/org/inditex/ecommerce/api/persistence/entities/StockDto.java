package org.inditex.ecommerce.api.persistence.entities;

import lombok.*;
import org.iditex.ecommerce.model.entities.Stock;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stocks")
public class StockDto implements Serializable {

    @Id
    @Column(name = "size_id")
    private Long sizeId;

    private Long quantity;

    public Stock toModel() {
        return new Stock(sizeId, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDto stockDto = (StockDto) o;
        return Objects.equals(sizeId, stockDto.sizeId) && Objects.equals(quantity, stockDto.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, quantity);
    }

}
