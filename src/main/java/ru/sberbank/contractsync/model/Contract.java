package ru.sberbank.contractsync.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract{

    private Long id;

    private Long version;

    private String number;

    private OwnerType ownerType;

    private LocalDate date;

    private ContractType type;

    private List<Connection> connections;

    Conditions conditions;

}