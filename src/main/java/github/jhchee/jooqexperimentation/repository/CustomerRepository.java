package github.jhchee.jooqexperimentation.repository;

import github.jhchee.jooqexperimentation.tables.Customer;
import github.jhchee.jooqexperimentation.tables.Product;
import github.jhchee.jooqexperimentation.tables.records.CustomerRecord;
import github.jhchee.jooqexperimentation.tables.records.ProductRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


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

    public Map<CustomerRecord, Result<ProductRecord>> fetchCustomerProducts(CustomerRecord customerRecord) {
        return dsl.select()
                .from(Customer.CUSTOMER)
                .join(Product.PRODUCT)
                .on(Customer.CUSTOMER.ID.eq(Product.PRODUCT.CUSTOMER_ID))
                .where(Customer.CUSTOMER.ID.eq(customerRecord.getId()))
                .fetchGroups(Customer.CUSTOMER, Product.PRODUCT);
    }
}
