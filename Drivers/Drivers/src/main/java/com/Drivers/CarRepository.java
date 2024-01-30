package com.Drivers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarRepository implements CrudRepository<CarDTO, Long> {
    @Override
    public <S extends CarDTO> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CarDTO> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CarDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CarDTO> findAll() {
        return null;
    }

    @Override
    public Iterable<CarDTO> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CarDTO entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CarDTO> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
