package com.vikiner.w11.repository;

import com.vikiner.w11.model.SoccerEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends SoccerEntity> {
    protected List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<T> sort(Comparator<T> comparator) {
        return items.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
