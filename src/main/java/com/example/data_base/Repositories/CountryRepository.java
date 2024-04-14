package com.example.data_base.Repositories;

import com.example.data_base.Models.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository{
    List<Country> findByName(String name);

    List<Country> findByIso2CountryCode(String iso2CountryCode);

    List<Country> findByIso3CountryCode(String iso3CountryCode);

}
