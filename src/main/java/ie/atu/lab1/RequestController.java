package ie.atu.lab1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RequestController {
    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name){
        return "Hello" + name + "!" ;
    }
    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam int age){
        return "Name: " + name + " Age: " + age;
    }
    @GetMapping("/person")
    public Person getPerson(){
        return new Person("Paul",25);
    }
    @GetMapping("calculate")
    public String calculate(@RequestParam int num1,@RequestParam int num2,@RequestParam String Calctype){


        switch (Calctype) {
            case "Addition":
                return "Addition: " + num1 + " + " + num2 + " = " + (num1 + num2);

            case "Subtraction":
                return "Subtraction: " + num1 + " - " + num2 + " = " + (num1 - num2);

            case "Multiplication":
                return "Multiplication: " + num1 + " * " + num2 + " = " + (num1 * num2);

            case "Division":
                if (num2 <= 0){
                    return "Calculation Error";
                }
                else {
                    return "Division: " + num1 + " / " + num2 + " = " + (num1 / num2);
                }

            default: return "Error";
        }
    }

}
