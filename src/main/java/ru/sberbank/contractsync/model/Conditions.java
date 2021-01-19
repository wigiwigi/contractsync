package ru.sberbank.contractsync.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conditions {

    private Tariff tariff;
    private String individualTariffOptions;
}