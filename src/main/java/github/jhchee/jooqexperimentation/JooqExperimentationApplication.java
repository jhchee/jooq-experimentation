package github.jhchee.jooqexperimentation;

import github.jhchee.jooqexperimentation.repository.LogRepository;
import github.jhchee.jooqexperimentation.tables.records.LogRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.ZoneOffset;

@SpringBootApplication
public class JooqExperimentationApplication {

//    @Bean
//    CommandLineRunner runner(CustomerRepository customerRepository, ProductRepository productRepository) {
//        return args -> {
//            UUID uuid = UUID.randomUUID();
//            String email = "test@domain.com";
//            CustomerRecord customer = new CustomerRecord();
//            customer.setId(uuid);
//            customer.setMetadata("insert");
//            customer.setEmail(email);
//
//            customerRepository.upsert(customer);
//            customer.setMetadata("update");
//            customerRepository.upsert(customer);
//
//
//            CustomerRecord customerWithEmail = customerRepository.getAnyByEmail(email);
//            Result<CustomerRecord> customersWithEmail = customerRepository.getAllByEmail(email);
//
//            List<ProductRecord> productRecords = new ArrayList<>();
//            customerRepository.getAll().forEach(cr -> IntStream.range(1, 10).forEach(i -> {
//                ProductRecord pr = new ProductRecord();
//                pr.setCustomerId(cr.getId());
//                pr.setSku("sku " + i);
//                productRecords.add(pr);
//            }));
//
//            productRepository.batchInsert(productRecords);
//
//            Result<ProductRecord> productsByCustomer = productRepository.getProductsByRecord(customer);
//        };

    @Bean
    CommandLineRunner runner(LogRepository logRepository) {
        return args -> {
            LogRecord logRecord1 = new LogRecord();
            logRecord1.setCreatedAt(Instant.now().atOffset(ZoneOffset.UTC));
            logRecord1.setContent("Hello mars!");
            LogRecord logRecordInserted = logRepository.insert(logRecord1);
            logRecordInserted.setContent("Hello moon!");

            LogRecord logRecord2 = new LogRecord();
            logRecord2.setCreatedAt(Instant.now().atOffset(ZoneOffset.UTC));
            logRepository.upsert(logRecordInserted);
            logRepository.upsert(logRecord2);
            logRepository.update(logRecord2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JooqExperimentationApplication.class, args);
    }

}