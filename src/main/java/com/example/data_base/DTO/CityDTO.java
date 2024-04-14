package com.example.data_base.DTO;
import java.util.HashSet;
import java.util.Set;

public class CityDTO {
        private Long id;
        private String name;
        private String countryName;
        private String timezone;
        private Set<AirportDTO> airports = new HashSet<>();

        public CityDTO() {
        }

        public CityDTO(Long id, String name, String countryName, String timezone, Set<AirportDTO> airports) {
            this.id = id;
            this.name = name;
            this.countryName = countryName;
            this.timezone = timezone;
            this.airports = airports;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Set<AirportDTO> getAirports() {
            return airports;
        }

        public void setAirports(Set<AirportDTO> airports) {
            this.airports = airports;
        }
}

