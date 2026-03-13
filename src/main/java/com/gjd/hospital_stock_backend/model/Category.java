package com.gjd.hospital_stock_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@Audited
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;

        if (!(o instanceof Category category)) return false;
        return name != null && name.equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
