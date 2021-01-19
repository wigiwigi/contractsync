package ru.sberbank.contractsync.schedulingtasks;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sberbank.contractsync.entity.ContractSyncEntity;
import ru.sberbank.contractsync.repository.ContractSyncRepository;

import javax.persistence.StoredProcedureQuery;


@Component
@EnableJpaRepositories("ru.sberbank.contractsync.repository")
public class ContractsyncScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ContractsyncScheduledTask.class);

    @Autowired
    ContractSyncRepository contractSyncRepository;

    @Scheduled(cron = "${cron.expression}")//(cron="*/5 * * * * *")
    public void processDataFromDB() {

        //ContractSyncEntity contractReadyForProcessing = contractSyncRepository.getContractReadyForProcessing();
        ContractSyncEntity contractReadyForProcessing = contractSyncRepository.getContractReadyForProcessing();
        if(contractReadyForProcessing != null)
            System.out.println(">>>>>> processing record ID=" + contractReadyForProcessing.getID());
        else System.out.println(">>>>>> no records to process");
        //System.out.println(">>>" + contractSyncRepository.findAll());
        //next: обработка полученной записи
    }

}
