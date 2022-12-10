package github.jhchee.jooqexperimentation;

import github.jhchee.jooqexperimentation.repository.CustomerRepository;
import github.jhchee.jooqexperimentation.repository.ProductRepository;
import github.jhchee.jooqexperimentation.tables.records.CustomerRecord;
import github.jhchee.jooqexperimentation.tables.records.ProductRecord;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootApplication
public class JooqExperimentationApplication {

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository, ProductRepository productRepository) {
        return args -> {
            // create new instance
            String email = "test@domain.com";
            CustomerRecord customer = new CustomerRecord();
            customer.setId(UUID.randomUUID());
            customer.setMetadata("insert");
            customer.setEmail(email);

            // insert
            customerRepository.upsert(customer);

            // update
            customer.setMetadata("update");
            customerRepository.upsert(customer);

            // fetch one or more by email field
            CustomerRecord customerWithEmail = customerRepository.getAnyByEmail(email);
            Result<CustomerRecord> customersWithEmail = customerRepository.getAllByEmail(email);

            // batch insert product
            List<ProductRecord> productRecords = new ArrayList<>();
            customerRepository.getAll().forEach(cr -> IntStream.range(1, 10).forEach(i -> {
                ProductRecord pr = new ProductRecord();
                pr.setCustomerId(cr.getId());
                pr.setSku("sku " + i);
                productRecords.add(pr);
            }));
            productRepository.batchInsert(productRecords);

            // get product record of customer
            Result<ProductRecord> productsByCustomer = productRepository.getProductsByRecord(customer);

            // works with customer-product graph
            Map<CustomerRecord, Result<ProductRecord>> customerProductGraph = customerRepository.fetchCustomerProducts(customer);
            customerProductGraph.forEach((cr, pr) -> {
                System.out.println(cr);
                System.out.println(pr);
            });

        };
    }

//    @Bean
//    CommandLineRunner runner(LogRepository logRepository) {
//        return args -> {
//            LogRecord logRecord1 = new LogRecord();
//            logRecord1.setCreatedAt(Instant.now().atOffset(ZoneOffset.UTC));
//            logRecord1.setContent("Hello mars!");
//            LogRecord logRecordInserted = logRepository.insert(logRecord1);
//            logRecordInserted.setContent("Hello moon!");
//
//            LogRecord logRecord2 = new LogRecord();
//            logRecord2.setCreatedAt(Instant.now().atOffset(ZoneOffset.UTC));
//            logRepository.upsert(logRecordInserted);
//            logRepository.upsert(logRecord2);
//            logRepository.update(logRecord2);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(JooqExperimentationApplication.class, args);
    }

}
