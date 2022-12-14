/*
 * This file is generated by jOOQ.
 */
package github.jhchee.jooqexperimentation.tables.records;


import github.jhchee.jooqexperimentation.tables.Customer;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerRecord extends UpdatableRecordImpl<CustomerRecord> implements Record3<UUID, String, JSONB> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.customer.id</code>.
     */
    public CustomerRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.customer.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.customer.email</code>.
     */
    public CustomerRecord setEmail(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.customer.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.customer.metadata</code>.
     */
    public CustomerRecord setMetadata(JSONB value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.customer.metadata</code>.
     */
    public JSONB getMetadata() {
        return (JSONB) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, JSONB> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, JSONB> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Customer.CUSTOMER.ID;
    }

    @Override
    public Field<String> field2() {
        return Customer.CUSTOMER.EMAIL;
    }

    @Override
    public Field<JSONB> field3() {
        return Customer.CUSTOMER.METADATA;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public JSONB component3() {
        return getMetadata();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public JSONB value3() {
        return getMetadata();
    }

    @Override
    public CustomerRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public CustomerRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public CustomerRecord value3(JSONB value) {
        setMetadata(value);
        return this;
    }

    @Override
    public CustomerRecord values(UUID value1, String value2, JSONB value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerRecord
     */
    public CustomerRecord() {
        super(Customer.CUSTOMER);
    }

    /**
     * Create a detached, initialised CustomerRecord
     */
    public CustomerRecord(UUID id, String email, JSONB metadata) {
        super(Customer.CUSTOMER);

        setId(id);
        setEmail(email);
        setMetadata(metadata);
    }
}
