@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "JWT_TOKEN";
    }
}
