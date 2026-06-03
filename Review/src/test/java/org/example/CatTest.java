package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    private static final boolean DEFAULT_DECLAWED = false;

    private Cat cat;
    private Cat baseCat;
    private Cat customCat;

    @BeforeEach
    public void setUp() {
        baseCat = new Cat();
        cat = new Cat("Siamese");
        customCat = new Cat("American Shorthair", Animal.Size.MEDIUM, DEFAULT_DECLAWED);
    }

    @Nested
    @DisplayName("test cat two argument constructor validates name")
    class TestCatTwoArgumentConstructorRejectsInvalidName {

        @Test
        public void testCatTwoArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Cat(null, Animal.Size.SMALL, DEFAULT_DECLAWED)
            );
        }

        @Test
        public void TestCatTwoArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Cat("", Animal.Size.MEDIUM, DEFAULT_DECLAWED)
            );
        }

        @Test
        public void testCatTwoArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Cat(" ", Animal.Size.LARGE, DEFAULT_DECLAWED)
            );
        }
    }

    @Nested
    @DisplayName("test cat single argument constructor validates name")
    class TestCatSingleArgumentConstructorRejectsInvalidName {

        @Test
        public void testCatSingleArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Cat(null)
            );
        }

        @Test
        public void testCatSingleArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Cat("")
            );
        }

        @Test
        public void testCatSingleArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Cat(" ")
            );
        }
    }

    @Nested
    @DisplayName("test no argument cat constructor getters")
    class TestCatNoArgumentConstructorGetters {

        @Test
        public void testCatNoArgumentConstructorGetName() {
            assertEquals("Unknown Name", baseCat.getName());
        }

        @Test
        public void testCatNoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, baseCat.getSize());
        }
    }

    @Nested
    @DisplayName("test single argument cat constructor getters")
    class TestCatSingleArgumentConstructorGetters {

        @Test
        public void testCatSingleArgumentConstructorGetName() {
            assertEquals("Siamese", cat.getName());
        }

        @Test
        public void testCatSingleArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, cat.getSize());
        }
    }

    @Nested
    @DisplayName("test two argument cat constructor getters")
    class TestCatTwoArgumentConstructorGetters {

        @Test
        public void testCatTwoArgumentConstructorGetName() {
            assertEquals("American Shorthair", customCat.getName());
        }

        @Test
        public void testCatTwoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, customCat.getSize());
        }
    }

    @Nested
    @DisplayName("test cat no argument constructor setters")
    class TestCatNoArgumentConstructorSetters {

        @Test
        public void testCatNoArgumentConstructorSetName() {
            assertEquals("Unknown Name", baseCat.getName());
            baseCat.setName("New name");

            assertEquals("New name", baseCat.getName());
        }

        @Test
        public void testCatNoArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, baseCat.getSize());
            baseCat.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, baseCat.getSize());
        }
    }

    @Nested
    @DisplayName("test cat single argument constructor setters")
    class TestCatSingleArgumentConstructorSetters {

        @Test
        public void testCatSingleArgumentConstructorSetName() {
            assertEquals("Siamese", cat.getName());
            cat.setName("Main Coon");

            assertEquals("Main Coon", cat.getName());
        }

        @Test
        public void testCatSingleArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, cat.getSize());
            cat.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, cat.getSize());
        }
    }

    @Nested
    @DisplayName("test cat two argument constructor setters")
    class TestCatTwoArgumentConstructorSetters {

        @Test
        public void testCatTwoArgumentConstructorSetName() {
            assertEquals("American Shorthair", customCat.getName());
            customCat.setName("Domestic Shorthair");

            assertEquals("Domestic Shorthair", customCat.getName());
        }

        @Test
        public void testCatTwoArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, customCat.getSize());
            customCat.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, customCat.getSize());
        }
    }

    @Nested
    @DisplayName("test cat setter rejects invalid name")
    class TestCatSetterRejectsInvalidName {

        @Test
        public void testCatSetterRejectsNullName() {
            assertEquals("Siamese", cat.getName());
            assertThrows(
                NullPointerException.class,
                () -> cat.setName(null)
            );

            assertEquals("Siamese", cat.getName());
        }

        @Test
        public void testCatSetterRejectsEmptyName() {
            assertEquals("Siamese", cat.getName());
            assertThrows(
                IllegalArgumentException.class,
                () -> cat.setName("")
            );

            assertEquals("Siamese", cat.getName());
        }

        @Test
        public void testCatSetterRejectsBlankName() {
            assertEquals("Siamese", cat.getName());
            assertThrows(
                IllegalArgumentException.class,
                () -> cat.setName(" ")
            );

            assertEquals("Siamese", cat.getName());
        }
    }

    @Nested
    @DisplayName("test cat make sound and trained status")
    class TestCatMakeSoundAndTrainedStatus {

        @Test
        public void testCatMakeSound() {
            assertEquals("Meow!!", cat.makeSound());
        }

        @Test
        public void testCatGetTrainedStatus() {
            assertFalse(customCat.isDeClawed());
        }

        @Test
        public void testCatSetTrainedStatus() {
            assertFalse(customCat.isDeClawed());
            customCat.setDeClawed(true);

            assertTrue(customCat.isDeClawed());
        }
    }
}