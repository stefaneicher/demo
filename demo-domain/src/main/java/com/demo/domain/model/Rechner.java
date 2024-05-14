package com.demo.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_rechner")
public class Rechner extends VersionedBaseEntity {

    public static final int MAX_LENGTH_FIELD = 13;
    public static final int UUID_LENGTH = 10;

    @Id
    @Column(name = "id", nullable = false, length = UUID_LENGTH)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "tbd"))
    private UUID uuid;

    @Column(name = "beratungsId", length = MAX_LENGTH_FIELD, unique = true, nullable = false)
    private UUID beratungsId;

    @Column(name = "a", length = MAX_LENGTH_FIELD, unique = true, nullable = false)
    private String a;
    @Column(name = "a", length = MAX_LENGTH_FIELD, unique = true, nullable = false)
    private String b;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @SortNatural
    @Fetch(FetchMode.SELECT)
    private List<Person> personen = new ArrayList<>();


}
