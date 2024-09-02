package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DbTest {
    @Test
    void dbSimpleGetAndDelete() {
        String namespace = "Users";
        String key = "name";
        String val = "Trevor";

        Db db = new Db();
        assertNull(db.get(namespace, key));

        db.set(namespace, key, val);
        assertEquals(val, db.get(namespace, key));

        db.delete(namespace, key);
        assertNull(db.get(namespace, key));
    }
}
