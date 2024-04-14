package com.example.data_base.DTO;

public class CountryDTO {
        private String name;
        private String iso2CountryCode;
        private String iso3CountryCode;

        public CountryDTO() {
        }

        public CountryDTO(String name, String iso2CountryCode, String iso3CountryCode) {
            this.name = name;
            this.iso2CountryCode = iso2CountryCode;
            this.iso3CountryCode = iso3CountryCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso2CountryCode() {
            return iso2CountryCode;
        }

        public void setIso2CountryCode(String iso2CountryCode) {
            this.iso2CountryCode = iso2CountryCode;
        }

        public String getIso3CountryCode() {
            return iso3CountryCode;
        }

        public void setIso3CountryCode(String iso3CountryCode) {
            this.iso3CountryCode = iso3CountryCode;
        }
}

