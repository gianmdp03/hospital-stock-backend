package com.gjd.hospital_stock_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "inventoryitems")
@Getter
@Setter
@NoArgsConstructor
@Audited
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private LocalDate expireDate;

    public InventoryItem(Product product, int stock, LocalDate expireDate){
        this.product = product;
        this.stock = stock;
        this.expireDate=expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof InventoryItem that)) return false;

        InventoryItem other = (InventoryItem) o;
        return this.product != null &&
                this.product.equals(other.getProduct()) &&
                this.expireDate != null &&
                this.expireDate.equals(other.getExpireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, expireDate);
    }
}
