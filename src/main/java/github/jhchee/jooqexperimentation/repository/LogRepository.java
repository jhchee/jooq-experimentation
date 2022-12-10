package github.jhchee.jooqexperimentation.repository;

import github.jhchee.jooqexperimentation.tables.Log;
import github.jhchee.jooqexperimentation.tables.records.LogRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Experiment with composite key table.
 */
@Repository
@Transactional
public class LogRepository {
    @Autowired
    private DSLContext dsl;

    public LogRecord insert(LogRecord record) {
        return dsl.insertInto(Log.LOG).set(record).returning().fetchOne();
    }

    public void update(LogRecord record) {
        // you can write using dsl
        dsl.update(Log.LOG)
                .set(record)
                .where(Log.LOG.CREATED_AT.eq(record.getCreatedAt()), Log.LOG.ID.eq(record.getId()))
                .execute();
        // or just using store method
        record.store();
    }

    public void upsert(LogRecord record) {
        // supporting upsert
        dsl.insertInto(Log.LOG)
                .columns(Log.LOG.fields())
                .onDuplicateKeyUpdate()
                .set(Log.LOG.CONTENT, record.getContent())
                .execute();
    }
}
