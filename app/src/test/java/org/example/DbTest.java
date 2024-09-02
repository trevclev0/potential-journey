package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DbTest {
    @Test
    void dbSimpleGetAndDelete() {
        // Arrange
        String namespace = "Users";
        String key = "name";
        String val = "Trevor";
        Db db = new Db();
        // Assert the database does not contain data to begin with
        assertNull(db.get(namespace, key));
        // Act by setting the expected data into the database
        db.set(namespace, key, val);
        // Assert the expected data in database is correct
        assertEquals(val, db.get(namespace, key));
        // Act by removing the value in the database
        db.delete(namespace, key);
        // Assert the data is removed (null) as expected
        assertNull(db.get(namespace, key));
    }
}
