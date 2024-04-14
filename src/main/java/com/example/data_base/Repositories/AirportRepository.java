package com.example.data_base.Repositories;

import com.example.data_base.Models.Airport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository {
    public Optional<Airport> findByName(String name);
    public Optional<Airport> findByIataCode(String code);
    public Optional<Airport> findIcaoCode(String code);
}