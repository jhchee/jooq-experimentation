/*
 * This file is generated by jOOQ.
 */
package github.jhchee.jooqexperimentation.tables.records;


import github.jhchee.jooqexperimentation.tables.LogDefault;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogDefaultRecord extends UpdatableRecordImpl<LogDefaultRecord> implements Record3<Long, OffsetDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.log_default.id</code>.
     */
    public LogDefaultRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.log_default.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.log_default.created_at</code>.
     */
    public LogDefaultRecord setCreatedAt(OffsetDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.log_default.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(1);
    }

    /**
     * Setter for <code>public.log_default.content</code>.
     */
    public LogDefaultRecord setContent(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.log_default.content</code>.
     */
    public String getContent() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<OffsetDateTime, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, OffsetDateTime, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, OffsetDateTime, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return LogDefault.LOG_DEFAULT.ID;
    }

    @Override
    public Field<OffsetDateTime> field2() {
        return LogDefault.LOG_DEFAULT.CREATED_AT;
    }

    @Override
    public Field<String> field3() {
        return LogDefault.LOG_DEFAULT.CONTENT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public OffsetDateTime component2() {
        return getCreatedAt();
    }

    @Override
    public String component3() {
        return getContent();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public OffsetDateTime value2() {
        return getCreatedAt();
    }

    @Override
    public String value3() {
        return getContent();
    }

    @Override
    public LogDefaultRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public LogDefaultRecord value2(OffsetDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public LogDefaultRecord value3(String value) {
        setContent(value);
        return this;
    }

    @Override
    public LogDefaultRecord values(Long value1, OffsetDateTime value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LogDefaultRecord
     */
    public LogDefaultRecord() {
        super(LogDefault.LOG_DEFAULT);
    }

    /**
     * Create a detached, initialised LogDefaultRecord
     */
    public LogDefaultRecord(Long id, OffsetDateTime createdAt, String content) {
        super(LogDefault.LOG_DEFAULT);

        setId(id);
        setCreatedAt(createdAt);
        setContent(content);
    }
}
