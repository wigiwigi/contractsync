package ru.sberbank.contractsync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.sberbank.contractsync.repository.ContractSyncRepository;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class ContractsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractsyncApplication.class, args);
    }

}
