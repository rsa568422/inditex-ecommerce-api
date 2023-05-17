package org.inditex.ecommerce.api.persistence.entities;

import lombok.*;
import org.iditex.ecommerce.model.entities.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
}
