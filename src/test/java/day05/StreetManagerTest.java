package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreetManagerTest {

    Path path= Paths.get("src/test/resources/streets.txt");

    List<Integer>numberKossuth=Arrays.asList(2,4,1,3,5,7);

    List<Integer> numberPetofi= Arrays.asList(1,2,4,3,6);

    StreetManager streetManager=new StreetManager();

    @Test
    void testRead(){
        streetManager.read(path).get(0);
        assertEquals("Kossuth 0",streetManager.read(path).get(0));
    }

    @Test
    void testTransform(){
        streetManager.read(path);
        streetManager.changeString(path);
        streetManager.transform(path);

        assertEquals(numberKossuth,streetManager.transform(path).get("Kossuth"));
        assertEquals(numberPetofi,streetManager.transform(path).get("Petofi"));
    }
}