package github.jhchee.jooqexperimentation.repository;

import github.jhchee.jooqexperimentation.tables.Product;
import github.jhchee.jooqexperimentation.tables.records.CustomerRecord;
import github.jhchee.jooqexperimentation.tables.records.ProductRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductRepository {
    @Autowired
    private DSLContext dsl;

    public void batchInsert(List<ProductRecord> records) {
        dsl.batchInsert(records).execute();
    }

    public void batchUpdate(List<ProductRecord> records) {
        dsl.batchUpdate(records).execute();
    }

    public Result<ProductRecord> getProductsByRecord(CustomerRecord customerRecord) {
        return dsl.selectFrom(Product.PRODUCT)
                .where(Product.PRODUCT.CUSTOMER_ID.eq(customerRecord.getId()))
                .fetch();
    }
}
