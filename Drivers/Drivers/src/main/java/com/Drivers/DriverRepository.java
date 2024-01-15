package com.Drivers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository <DriverDTO,Long> {

    public DriverDTO findByName(String name);
}
