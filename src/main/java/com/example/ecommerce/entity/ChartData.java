package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ChartData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> labels;

    @ElementCollection
    private List<Integer> values;

    // Constructors, getters, and setters

    public ChartData() {}

    public ChartData(List<String> labels, List<Integer> values) {
        this.labels = labels;
        this.values = values;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
