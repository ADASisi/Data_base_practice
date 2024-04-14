package com.example.data_base.DTO;

public class AirportDTO {
        private Long id;
        private String name;
        private String cityName;
        private String countryName;
        private String iataCode;
        private String icaoCode;
        private Double latitude;
        private Double longitude;

        public AirportDTO() {
        }

        public AirportDTO(Long id, String name, String cityName, String countryName, String iataCode, String icaoCode, Double latitude, Double longitude) {
            this.id = id;
            this.name = name;
            this.cityName = cityName;
            this.countryName = countryName;
            this.iataCode = iataCode;
            this.icaoCode = icaoCode;
            this.latitude = latitude;
            this.longitude = longitude;
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

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getIataCode() {
            return iataCode;
        }

        public void setIataCode(String iataCode) {
            this.iataCode = iataCode;
        }

        public String getIcaoCode() {
            return icaoCode;
        }

        public void setIcaoCode(String icaoCode) {
            this.icaoCode = icaoCode;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
}

