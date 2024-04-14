package com.example.data_base.Repositories;

import com.example.data_base.Models.City;

import java.util.Optional;

public interface CityRepository {
    Optional<City> findByName(String name);
}