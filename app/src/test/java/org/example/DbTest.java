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

    @Test
    void dbGetAll() {
        // Arrange
        String namespaceInsect = "Insects";
        String keyName = "name";
        String keySize = "size";
        String valBig = "big";
        String valSmall = "small";
        String valBeetle = "Beetle";
        String valAnt = "Ant";
        String expectedString = "[{\"name\":\"Ant\",\"size\":\"small\"},{\"name\":\"Beetle\",\"size\":\"big\"}]";
        // Verify db is empty
        assertNull(db.get(namespaceInsect, keyName));
        // Act by setting the expected data into the database
        db.set(namespaceInsect, keyName, valBeetle);
        db.set(namespaceInsect, keyName, valAnt);
        db.set(namespaceInsect, keySize, valSmall);
        db.set(namespaceInsect, keySize, valBig);
        // Assert correct string output
        assertEquals(expectedString, db.getAll(namespaceInsect));
    }
}
