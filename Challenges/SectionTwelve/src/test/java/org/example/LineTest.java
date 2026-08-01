package org.example;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    public void testLineEnforcesPrecisionOnConstruction() {
        Point p1 = new Point(new BigDecimal("1.23456"), new BigDecimal("2.34567"), 5);
        ArrayList<Point> points = new ArrayList<>(List.of(p1));
        
        // Line with precision 2
        Line line = new Line(points, 2);
        
        // The point inside the line should now have precision 2
        assertEquals(new BigDecimal("1.23"), line.getPoints().get(0).getX());
        assertEquals(new BigDecimal("2.35"), line.getPoints().get(0).getY());
    }

    @Test
    public void testLineEnforcesPrecisionOnAddPoint() {
        Line line = new Line(new ArrayList<>(), 2);
        Point p1 = new Point(new BigDecimal("1.23456"), new BigDecimal("2.34567"), 5);
        
        line.addPoint(p1);
        
        assertEquals(new BigDecimal("1.23"), p1.getX());
        assertEquals(new BigDecimal("2.35"), p1.getY());
    }

    @Test
    public void testLineEnforcesPrecisionOnSetPrecision() {
        Point p1 = new Point(new BigDecimal("1.23456"), new BigDecimal("2.34567"), 2);
        ArrayList<Point> points = new ArrayList<>(List.of(p1));
        Line line = new Line(points, 2);
        
        assertEquals(new BigDecimal("1.23"), p1.getX());
        
        line.setPrecision(4);
        
        // Note: setScale(4) on 1.23 will be 1.2300
        assertEquals(new BigDecimal("1.2300"), p1.getX());
        
        // If we set a new coordinate via Line (indirectly or directly if we had a method)
        // But here we test that setPrecision re-rounds existing points.
        // Let's test a value that has more decimals but was rounded down.
        p1.setX(new BigDecimal("1.23456"), 4); 
        assertEquals(new BigDecimal("1.2346"), p1.getX());
    }
    
    @Test
    public void testLineRenderUsesCorrectPrecision() {
        Point p1 = new Point(new BigDecimal("1.23456"), new BigDecimal("2.34567"), 5);
        Line line = new Line(new ArrayList<>(List.of(p1)), 2);
        
        List<List<BigDecimal>> rendered = line.render();
        
        assertEquals(new BigDecimal("1.23"), rendered.get(0).get(0));
        assertEquals(new BigDecimal("2.35"), rendered.get(0).get(1));
    }

    @Test
    public void testLineRendersTwoPointsUsesCorrectPrecision() {
        Point p1 = new Point(new BigDecimal("1.234567"), new BigDecimal("2.345678"), 5);
        Point p2 = new Point(new BigDecimal("3.456789"), new BigDecimal("4.567812"), 5);

        Line line = new Line(new ArrayList<>(List.of(p1, p2)), 4);

        List<List<BigDecimal>> rendered = line.render();

        assertEquals(new BigDecimal("1.2346"), rendered.get(0).get(0));
        assertEquals(new BigDecimal("2.3457"), rendered.get(0).get(1));
        assertEquals(new BigDecimal("3.4568"), rendered.get(1).get(0));
        assertEquals(new BigDecimal("4.5678"), rendered.get(1).get(1));
    }

    @Test
    public void testGetLinePrecision() {
        Point p1 = new Point(new BigDecimal("1.234567"), new BigDecimal("2.345678"), 5);
        Point p2 = new Point(new BigDecimal("3.456789"), new BigDecimal("4.567812"), 5);

        Line line = new Line(new ArrayList<>(List.of(p1, p2)), 4);

        assertEquals(4, line.getPrecision());
    }
}
