import org.junit.*;
import static org.junit.Assert.*;
import java.time.*;

public class ToyCollectionTest {

  @After
  public void tearDown() {
    ToyCollection.clear();
  }

  @Test
  public void toyCollection_instantiateTest() {
    ToyCollection newToy = new ToyCollection("Plant Eaters");
    assertEquals(true, newToy instanceof ToyCollection);
  }

  @Test
  public void testToyGetters() {
    ToyCollection newToy = new ToyCollection("Plant Eaters");
    assertEquals("Plant Eaters", newToy.getName());
    assertEquals(1, newToy.getId());
  }

  @Test
  public void newToy_addsToyToCollection_true() {
    ToyCollection testCollection = new ToyCollection("Plant Eaters");
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    testCollection.addDinoToy(testDino);
    assertTrue(testCollection.getDinoToys().contains(testDino));
  }

  @Test
  public void newToy_addsTwoToysToCollectionAndSizeIsTwo_true() {
    ToyCollection testCollection = new ToyCollection("Plant Eaters");
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    DinoToys testDino2 = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    testCollection.addDinoToy(testDino);
    testCollection.addDinoToy(testDino2);
    assertEquals(2, testCollection.getDinoToys().size());
  }

  @Test
  public void newToy_addsToysToTwoCollections_true() {
    ToyCollection testCollection = new ToyCollection("Plant Eaters");
    ToyCollection testCollection2 = new ToyCollection("Meat Eaters");
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    DinoToys testDino2 = new DinoToys("T-rex", 60, "Very rare","fair", "LocalDate.now()", 500);
    testCollection.addDinoToy(testDino);
    testCollection2.addDinoToy(testDino2);
    assertTrue(testCollection.getDinoToys().contains(testDino));
    assertTrue(testCollection2.getDinoToys().contains(testDino2));
  }

  @Test
  public void newToy_addsToysToTwoCollectionsOutOfOrder_true() {
    ToyCollection testCollection = new ToyCollection("Plant Eaters");
    ToyCollection testCollection2 = new ToyCollection("Meat Eaters");
    ToyCollection testCollection3 = new ToyCollection("Plant Eaters");
    ToyCollection testCollection4 = new ToyCollection("Meat Eaters");
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    DinoToys testDino2 = new DinoToys("T-rex", 60, "Very rare","fair", "LocalDate.now()", 500);
    DinoToys testDino3 = new DinoToys("Stegasaurus", 60, "rare","fair", "LocalDate.now()", 500);
    DinoToys testDino4 = new DinoToys("Veloiciraptor", 60, "Very rare","fair", "LocalDate.now()", 500);
    testCollection.addDinoToy(testDino);
    testCollection2.addDinoToy(testDino2);
    testCollection.addDinoToy(testDino3);
    testCollection2.addDinoToy(testDino4);
    assertEquals(2, testCollection.getDinoToys().size());
    assertEquals(2, testCollection2.getDinoToys().size());
  }
}
