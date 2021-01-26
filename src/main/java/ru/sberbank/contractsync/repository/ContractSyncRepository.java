package ru.sberbank.contractsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.sberbank.contractsync.entity.ContractSyncEntity;

//@Repository
//@Component
public interface ContractSyncRepository extends JpaRepository<ContractSyncEntity, Long> {

    //не работает почему-то
//    @Procedure("ContractSyncEntity.getContractReadyForProcessing")
//    ContractSyncEntity getContractReadyForProcessing();

    @Query(value = "syncContractsGet;", nativeQuery = true)
    ContractSyncEntity getContractReadyForProcessing();

}
