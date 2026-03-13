package com.gjd.hospital_stock_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private boolean read = false;

    @Column(nullable = false)
    private Instant date;

    public Notification(String message, Instant date) {
        this.message = message;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof Notification that)) return false;
        return this.message != null && this.message.equals(that.getMessage())
                && this.date!=null && this.date.equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, date);
    }
}
