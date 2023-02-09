package ga.repin.education.peripheral;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static ga.repin.education.peripheral.PeripheralConstants.*;

@RestController
@Tag(name = "⚙️ Peripheral endpoints", description = "")
public class PeripheralController {
    private final PeripheralService peripheralService;

    public PeripheralController(PeripheralService peripheralService) {
        this.peripheralService = peripheralService;
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_01)
    public String showIndexPage() {
        return peripheralService.course1Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_02)
    public String showCourse2Page() {
        return peripheralService.course2Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_03)
    public String showCourse3Page() {
        return peripheralService.course3Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_04)
    public String showCourse4Page() {
        return peripheralService.course4Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_05)
    public String showCourse5Page() {
        return peripheralService.course5Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_06)
    public String showCourse6Page() {
        return peripheralService.course6Index();
    }
    
    @Hidden
    @GetMapping(path = "/exit")
    public String stopServer(@RequestParam(value = "pass", required = false) String pass) {
        return peripheralService.stopSpring(pass);
    }
    
    @Hidden
    @GetMapping(path = "/switchtheme")
    public String switchTheme() {
        return peripheralService.letSwitchTheme();
    }
    
    @GetMapping("/getPort")
    public ResponseEntity<String> getPort(){
        return ResponseEntity.status(HttpStatus.OK).body(peripheralService.getServerPort());
        //("Port, on which app started"));
    }
    
    @GetMapping("/task040504")
    public Map<String, String> task040504(){
        return peripheralService.task040504();
    }
    
    @GetMapping("/task040601")
    public void task040601(){
        peripheralService.task040601();
    }
    
    @GetMapping("/task040602")
    public void task040602(){
        peripheralService.task040602();
    }
    
}
