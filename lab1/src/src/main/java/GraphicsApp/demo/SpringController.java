package GraphicsApp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.awt.Color;
import java.util.ArrayList;

@Controller
public class SpringController {

    ColorConverter converter=new ColorConverter();

    @GetMapping("/")
    public String displayColorForm() {

        return "color-form";
    }

}
