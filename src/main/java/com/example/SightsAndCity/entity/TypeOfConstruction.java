package com.example.SightsAndCity.entity;

public enum TypeOfConstruction {
        МУЗЕЙ("Музей"),
        ЗДАНИЕ("Здание"),
        ПАМЯТНИК("Памятник");

        private final String type;

        TypeOfConstruction(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }

}




