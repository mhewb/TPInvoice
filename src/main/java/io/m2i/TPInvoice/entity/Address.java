package io.m2i.TPInvoice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetNumber; //Can be 1bis, 3ter, etc
    private String streetName; // "Rue des Lilas", "Avenue de l'Hotel Dieu"
    private String zipCode;
    private String city;

}
