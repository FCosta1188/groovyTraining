import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class HelloGroovyApplicationTests {
    @Test
    void contextLoads() {
    }
}

@RestController
class GreetingController {
    @RequestMapping("/{name}")
    String home(@PathVariable String name){
        "Hello $name"
    }
}