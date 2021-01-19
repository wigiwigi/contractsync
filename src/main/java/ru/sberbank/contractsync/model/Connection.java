package ru.sberbank.contractsync.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Connection {

    private Long epkId;

    private ConnectionType connectionType;

}
