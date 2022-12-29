package ga.repin.education.navigation;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static ga.repin.education.navigation.NavigationConstants.*;

@RestController
@Tag(name = "⚙️ Peripheral endpoints", description = "")
public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_01)
    public String showIndexPage() {
        return indexService.course1Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_02)
    public String showCourse2Page() {
        return indexService.course2Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_03)
    public String showCourse3Page() {
        return indexService.course3Index();
    }
    
    @Hidden
    @GetMapping(path = ROOT_URL_04)
    public String showCourse4Page() {
        return indexService.course4Index();
    }
    
    @Hidden
    @GetMapping(path = "/exit")
    public String stopServer(@RequestParam(value = "pass", required = false) String pass) {
        return indexService.stopSpring(pass);
    }
    
    @Hidden
    @GetMapping(path = "/switchtheme")
    public String switchTheme() {
        return indexService.letSwitchTheme();
    }
    
    @GetMapping("/getPort")
    public ResponseEntity<String> getPort(){
        return ResponseEntity.status(HttpStatus.OK).body(indexService.getServerPort());
        //("Port, on which app started"));
    }
    
    @GetMapping("/task040504")
    public Map<String, String> task040504(){
        return indexService.task040504();
    }
    
}
