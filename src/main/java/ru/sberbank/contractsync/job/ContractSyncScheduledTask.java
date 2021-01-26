package ru.sberbank.contractsync.job;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sberbank.contractsync.entity.ContractSyncEntity;
import ru.sberbank.contractsync.repository.ContractSyncRepository;


@Component
//@EnableJpaRepositories("ru.sberbank.contractsync.repository")
public class ContractSyncScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ContractSyncScheduledTask.class);

    ContractSyncRepository contractSyncRepository;

    public ContractSyncScheduledTask(ContractSyncRepository contractSyncRepository) {
        this.contractSyncRepository = contractSyncRepository;
    }

    @Scheduled(cron = "${cron.expression}")
    public void processDataFromDB() {

        ContractSyncEntity contractReadyForProcessing = contractSyncRepository.getContractReadyForProcessing();

        if(contractReadyForProcessing != null) {
            System.out.println(">>>>>> processing record ID=" + contractReadyForProcessing.getID());


//            throw new RuntimeException("exited");
        }
        else System.out.println(">>>>>> no records to process");

    }

}
