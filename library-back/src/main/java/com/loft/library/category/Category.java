package com.loft.library.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Category")
public class Category {

    private String code;
    private String label;

    public Category() {}

    public Category(String code, String label) {
        super();
        this.code = code;
        this.label = label;
    }

    @Id
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "LABEL", nullable = false)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getCode(), category.getCode()) && Objects.equals(getLabel(), category.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLabel());
    }
}
