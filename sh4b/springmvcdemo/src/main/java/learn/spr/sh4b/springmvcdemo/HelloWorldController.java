package learn.spr.sh4b.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processDataAndAddToModel(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        studentName = studentName.toUpperCase();
        String message = "Yo! " + studentName;
        model.addAttribute("message", message);
        return "helloworld";
    }
}
