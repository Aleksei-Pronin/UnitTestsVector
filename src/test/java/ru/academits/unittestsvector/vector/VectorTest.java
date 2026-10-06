package ru.academits.unittestsvector.vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VectorTest {
    @Test
    void constructorWithSizeAndCoordinatesShouldCreateVector() {
        double[] coordinates = {1, 2, 3};

        Vector vector = new Vector(3, coordinates);

        assertEquals(3, vector.getSize());
        assertEquals(1, vector.getCoordinate(0));
        assertEquals(2, vector.getCoordinate(1));
        assertEquals(3, vector.getCoordinate(2));
    }

    @Test
    void constructorWithSizeAndCoordinatesShouldFillRemainingCoordinatesWithZeros() {
        double[] coordinates = {1, 2};

        Vector vector = new Vector(4, coordinates);

        assertEquals(4, vector.getSize());
        assertEquals(1, vector.getCoordinate(0));
        assertEquals(2, vector.getCoordinate(1));
        assertEquals(0, vector.getCoordinate(2));
        assertEquals(0, vector.getCoordinate(3));
    }

    @Test
    void constructorWithSizeAndCoordinatesShouldTrimCoordinatesIfSizeIsSmaller() {
        double[] coordinates = {1, 2, 3};

        Vector vector = new Vector(2, coordinates);

        assertEquals(2, vector.getSize());
        assertEquals(1, vector.getCoordinate(0));
        assertEquals(2, vector.getCoordinate(1));
    }

    @Test
    void constructorWithSizeAndCoordinatesShouldThrowExceptionForZeroOrNegativeSize() {
        double[] coordinates = {1, 2, 3};

        assertThrows(
                IllegalArgumentException.class,
                () -> new Vector(0, coordinates)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new Vector(-1, coordinates)
        );
    }

    @Test
    void addSameSizeVectorsShouldAddCoordinates() {
        Vector firstVector = new Vector(new double[]{1, 2, 3});
        Vector secondVector = new Vector(new double[]{4, 5, 6});

        firstVector.add(secondVector);

        assertEquals(5, firstVector.getCoordinate(0));
        assertEquals(7, firstVector.getCoordinate(1));
        assertEquals(9, firstVector.getCoordinate(2));
    }

    @Test
    void addLargerSizeVectorShouldIncreaseSizeAndAddCoordinates() {
        Vector firstVector = new Vector(new double[]{1, 2});
        Vector secondVector = new Vector(new double[]{3, 4, 5});

        firstVector.add(secondVector);

        assertEquals(3, firstVector.getSize());
        assertEquals(4, firstVector.getCoordinate(0));
        assertEquals(6, firstVector.getCoordinate(1));
        assertEquals(5, firstVector.getCoordinate(2));
    }

    @Test
    void addSmallerSizeVectorShouldAddCoordinates() {
        Vector firstVector = new Vector(new double[]{1, 2, 3});
        Vector secondVector = new Vector(new double[]{4, 5});

        firstVector.add(secondVector);

        assertEquals(3, firstVector.getSize());
        assertEquals(5, firstVector.getCoordinate(0));
        assertEquals(7, firstVector.getCoordinate(1));
        assertEquals(3, firstVector.getCoordinate(2));
    }
}