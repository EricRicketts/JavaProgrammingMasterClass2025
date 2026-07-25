package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class UtilityLineTest {

    List<Mappable> utilities = new ArrayList<>();
    UtilityLine utility;

    @BeforeEach
    public void setUp() {
        utilities.add(new UtilityLine("College Street", UtilityType.FIBER_OPTIC));
        utilities.add(new UtilityLine("Olympic Boulevard", UtilityType.WATER));
        utilities.add(new UtilityLine("Main Street", UtilityType.ELECTRICAL));
        utility = (UtilityLine) utilities.getFirst();
    }

    
}
