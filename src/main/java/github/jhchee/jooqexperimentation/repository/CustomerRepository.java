package github.jhchee.jooqexperimentation.repository;

import github.jhchee.jooqexperimentation.tables.Customer;
import github.jhchee.jooqexperimentation.tables.records.CustomerRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CustomerRepository {
    @Autowired
    private DSLContext dsl;

    public CustomerRecord getAnyByEmail(String email) {
        return dsl.selectFrom(Customer.CUSTOMER)
                .where(Customer.CUSTOMER.EMAIL.eq(email))
                .fetchAny();
    }

    public Result<CustomerRecord> getAllByEmail(String email) {
        return dsl.selectFrom(Customer.CUSTOMER)
                .where(Customer.CUSTOMER.EMAIL.eq(email))
                .fetch();
    }

    public Result<CustomerRecord> getAll() {
        return dsl.selectFrom(Customer.CUSTOMER)
                .fetch();
    }

    public void upsert(CustomerRecord record) {
        dsl.insertInto(Customer.CUSTOMER)
                .set(record)
                .onConflict(Customer.CUSTOMER.ID)
                .doUpdate()
                .set(record)
                .execute();
    }

    public void truncate() {
        dsl.truncate(Customer.CUSTOMER)
                .restartIdentity()
                .cascade()
                .execute();
    }
}
