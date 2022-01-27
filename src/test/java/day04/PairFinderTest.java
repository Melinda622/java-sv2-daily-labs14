package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    PairFinder pairFinder=new PairFinder();

    int arr[]={7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
    int arr2[]={8, 1, 5, 2, 4, 3, 6, 7};

    @Test
    void testFindPairs(){
       assertEquals(4,pairFinder.findPairs(arr));
       assertEquals(0,pairFinder.findPairs(arr2));
    }
}