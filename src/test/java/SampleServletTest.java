import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
public class SampleServletTest {
    @Test
    @DisplayName("Greeting Test")
    public void testGreeting() {
        SampleServlet mySampleServlet = new SampleServlet();
        assertEquals("Hello World!", mySampleServlet.greeting(), "all good");
    }
}
