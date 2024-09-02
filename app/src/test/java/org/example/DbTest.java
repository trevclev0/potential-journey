package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class DbTest {
    Db db;

    @BeforeEach
    void setUp() {
        db = new Db();
    }

    @Test
    void dbSimpleGetAndDelete() {
        // Arrange
        String namespaceA = "Users";
        String keyA = "name";
        String valA = "Trevor";
        String namespaceB = "Cars";
        String keyB = "name";
        String valB = "Trevor";
        // Assert the database does not contain data to begin with
        assertNull(db.get(namespaceA, keyA));
        // Act by setting the expected data into the database
        db.set(namespaceA, keyA, valA);
        db.set(namespaceB, keyB, valB);
        // Assert the expected data in database is correct
        assertEquals(valA, db.get(namespaceA, keyA));
        // Act by removing the value in the database
        db.delete(namespaceA, keyA);
        // Assert the data is removed (null) as expected
        assertNull(db.get(namespaceA, keyA));

        assertEquals(valB, db.get(namespaceB, keyB));
    }

    // void dbGetAll() {
    // String namespaceInsect = "Insects";
    // String keyName = "name";
    // String valBeetle = "Beetle";
    // assertNull(db.get(namespaceInsect, keyName));
    // db.

    // }
}
