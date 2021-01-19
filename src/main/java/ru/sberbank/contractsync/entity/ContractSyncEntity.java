package ru.sberbank.contractsync.entity;

import lombok.*;
import org.apache.openjpa.persistence.jdbc.Strategy;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dbo", name = "syncContracts")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getContractReadyForProcessing",
                procedureName = "syncContractsGet",
                resultClasses = { ContractSyncEntity.class }
//                ,parameters = {
//                        @StoredProcedureParameter(
//                                name = "p_year",
//                                type = Integer.class,
//                                mode = ParameterMode.IN) }
                                )
})
public class ContractSyncEntity {
    @Id
    private int ID;
    //private char SyncStatus; //R - ready, P - processing, C - completed, E - error
    private SyncStatus SyncStatus;
    private boolean IsNewContract;
    @Persistent
    @Strategy("org.apache.openjpa.xmlmapping.XmlValueHandler")
    private String ContractData;
    private String ErrorMes;

}
