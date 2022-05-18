package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    @Test
    void nepar() {
        int mas [] =new int[]{1,-1,3,4,-2};
        assertEquals(2,Main.Nepar(mas));
    }
}
