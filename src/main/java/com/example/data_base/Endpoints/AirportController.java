package com.example.data_base.Endpoints;

import com.example.data_base.DTO.AirportDTO;
import com.example.data_base.DTO.CityDTO;
import com.example.data_base.DTO.CountryDTO;
import com.example.data_base.Models.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomAirportService {

    private final AirportRepository customAirportRepository;

    @Autowired
    public CustomAirportService(AirportRepository customAirportRepository) {
        this.customAirportRepository = customAirportRepository;
    }

    public List<AirportDTO> findFilteredAirports(boolean countryAsRoot, AirportFilter airportFilter, int pageNumber, int pageSize) {
        Page<Airport> airportPage;
        if (countryAsRoot) {
            airportPage = filterWithCountryAsRoot(airportFilter, pageNumber, pageSize);
        } else {
            airportPage = filterWithAirportAsRoot(airportFilter, pageNumber, pageSize);
        }
        return airportPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private Page<Airport> filterWithCountryAsRoot(AirportFilter airportFilter, int pageNumber, int pageSize) {
        List<Airport> filteredAirports = new ArrayList<>();

        for (String countryIso2Code : airportFilter.getCountryIso2Codes()) {
            Country country = CountryRepository.findByIso2CountryCode(countryIso2Code);
            if (country != null) {
                for (City city : country.getCities()) {
                    for (Airport airport : city.getAirports()) {
                        if (applyFilters(airport, airportFilter)) {
                            filteredAirports.add(airport);
                        }
                    }
                }
            }
        }

        return sliceList(filteredAirports, pageNumber, pageSize);
    }


    private Page<Airport> filterWithAirportAsRoot(AirportFilter airportFilter, int pageNumber, int pageSize) {
        List<Airport> filteredAirports = new ArrayList<>();

        for (Airport airport : customAirportRepository.findAll()) {
            if (applyFilters(airport, airportFilter)) {
                filteredAirports.add(airport);
            }
        }

        return sliceList(filteredAirports, pageNumber, pageSize);
    }

    private Page<Airport> sliceList(List<Airport> airports, int pageNumber, int pageSize) {
        int start = Math.min(pageNumber * pageSize, airports.size());
        int end = Math.min((pageNumber + 1) * pageSize, airports.size());
        return new PageImpl<>(airports.subList(start, end), PageRequest.of(pageNumber, pageSize), airports.size());
    }

    private boolean applyFilters(Airport airport, AirportFilter airportFilter) {
        boolean matchesCountry = airportFilter.getCountryIso2Codes().isEmpty() || airportFilter.getCountryIso2Codes().contains(airport.getCity().getCountry().getIso2CountryCode());
        boolean matchesCity = airportFilter.getCityIds().isEmpty() || airportFilter.getCityIds().contains(airport.getCity().getId());
        boolean matchesAirportIcao = airportFilter.getAirportIcaoCodes().isEmpty() || airportFilter.getAirportIcaoCodes().contains(airport.getIcaoCode());
        boolean matchesAirportName = airportFilter.getAirportNames().isEmpty() || airportFilter.getAirportNames().contains(airport.getName());
        return matchesCountry && matchesCity && matchesAirportIcao && matchesAirportName;
    }

    private AirportDTO convertToDTO(Airport airport) {
        AirportDTO dto = new AirportDTO();
        dto.setId(airport.getId());
        dto.setName(airport.getName());
        dto.setIataCode(airport.getIataCode());
        dto.setIcaoCode(airport.getIcaoCode());
        dto.setLatitude(airport.getLatitude());
        dto.setLongitude(airport.getLongitude());

        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(airport.getCity().getId());
        cityDTO.setName(airport.getCity().getName());

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(airport.getCity().getCountry().getName());
        countryDTO.setIso2CountryCode(airport.getCity().getCountry().getIso2CountryCode());
        countryDTO.setIso3CountryCode(airport.getCity().getCountry().getIso3CountryCode());

        cityDTO.setCountry(countryDTO);
        dto.setCity(cityDTO);

        return dto;
    }
}
