import org.junit.*;
import static org.junit.Assert.*;
import java.time.*;

public class DinoToysTest {

  @Test
  public void dinoToy_instantiatesCorrectly() {
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    assertEquals(true, testDino instanceof DinoToys);
  }

  @Test
  public void dinoToy_testGetters() {
    DinoToys testDino = new DinoToys("Brontausarus", 60, "medium rare","new", "LocalDate.now()", 400);
    assertEquals("Brontausarus", testDino.getType());
    assertEquals(60, testDino.getSize());
    assertEquals("medium rare", testDino.getRarity());
    assertEquals("new", testDino.getCondition());
    assertEquals("LocalDate.now()", testDino.getManufactured());
    assertEquals(400, testDino.getPrice());
    assertEquals(1, testDino.getId());

  }
}
