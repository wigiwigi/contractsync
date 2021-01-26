package ru.sberbank.contractsync.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@AllArgsConstructor
@XmlRootElement(name = "connection")
public class Connection {

    private Long epkId;

    private ConnectionType connectionType;

}
