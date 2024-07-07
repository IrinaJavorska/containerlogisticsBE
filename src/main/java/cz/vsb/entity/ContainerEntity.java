package cz.vsb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity(name = "containers")
@Getter
@Setter
public class ContainerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "size")
    private String size;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "contents")
    private String contents;

    @Column(name = "seal")
    private String seal;

    @Column(name = "customs")
    private String customs;

    @Column(name = "arrival")
    private LocalDate arrival;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;
}