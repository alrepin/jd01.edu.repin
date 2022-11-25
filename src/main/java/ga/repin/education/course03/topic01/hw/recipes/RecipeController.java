package ga.repin.education.course03.topic01.hw.recipes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ga.repin.education.common.exceptions.ErrorMessage;
import ga.repin.education.common.exceptions.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static ga.repin.education.course03.topic01.hw.HwConstants.HW_ENDPOINT;

@CrossOrigin
@RequestMapping(HW_ENDPOINT)
@RestController
public class RecipeController {
    private final RecipeService recipeService;
    
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage() + " - thrown with Exception " + exception.getClass().toString()));
    }
    
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorMessage> handleException(HttpException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorMessage(exception.getHttpStatus(), exception.getMessage() + " - thrown with Exception " + exception.getClass().toString()));
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public String index(HttpSession session) {
        return recipeService.index(session.getId());
    }
    
    
    @PostMapping()
    public String postRecipePlainText(@RequestParam String txtRecipe) {
        return txtRecipe;
    }
    
    @GetMapping(path = "/reference_sample")
    public String reference() {
        
        return recipeService.getReference();

    }
}
