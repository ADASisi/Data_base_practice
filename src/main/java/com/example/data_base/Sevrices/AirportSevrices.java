package com.example.data_base.Sevrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

        @Autowired
        private AirportRepository airportRepository;

        public List<AirportDTO> getAllAirports() {
            return airportRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
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
}
