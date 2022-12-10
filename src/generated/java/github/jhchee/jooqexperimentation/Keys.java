/*
 * This file is generated by jOOQ.
 */
package github.jhchee.jooqexperimentation;


import github.jhchee.jooqexperimentation.tables.Customer;
import github.jhchee.jooqexperimentation.tables.Log;
import github.jhchee.jooqexperimentation.tables.LogDefault;
import github.jhchee.jooqexperimentation.tables.Product;
import github.jhchee.jooqexperimentation.tables.records.CustomerRecord;
import github.jhchee.jooqexperimentation.tables.records.LogDefaultRecord;
import github.jhchee.jooqexperimentation.tables.records.LogRecord;
import github.jhchee.jooqexperimentation.tables.records.ProductRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CustomerRecord> CUSTOMER_PKEY = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("customer_pkey"), new TableField[] { Customer.CUSTOMER.ID }, true);
    public static final UniqueKey<LogRecord> LOG_PKEY = Internal.createUniqueKey(Log.LOG, DSL.name("log_pkey"), new TableField[] { Log.LOG.CREATED_AT, Log.LOG.ID }, true);
    public static final UniqueKey<LogDefaultRecord> LOG_DEFAULT_PKEY = Internal.createUniqueKey(LogDefault.LOG_DEFAULT, DSL.name("log_default_pkey"), new TableField[] { LogDefault.LOG_DEFAULT.CREATED_AT, LogDefault.LOG_DEFAULT.ID }, true);
    public static final UniqueKey<ProductRecord> PRODUCT_PKEY = Internal.createUniqueKey(Product.PRODUCT, DSL.name("product_pkey"), new TableField[] { Product.PRODUCT.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ProductRecord, CustomerRecord> PRODUCT__PRODUCT_CUSTOMER_ID_FKEY = Internal.createForeignKey(Product.PRODUCT, DSL.name("product_customer_id_fkey"), new TableField[] { Product.PRODUCT.CUSTOMER_ID }, Keys.CUSTOMER_PKEY, new TableField[] { Customer.CUSTOMER.ID }, true);
}