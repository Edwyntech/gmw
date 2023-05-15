package tech.edwyn.gmw.infra.driving;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.edwyn.gmw.domain.UserHandlerApi;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.infra.driving.model.AddUserRequest;
import tech.edwyn.gmw.infra.driving.model.ScoreResponse;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserHandlerApi userHandlerApi;

    @GetMapping("/verify/{email}")
    public Boolean verifyEmail(@PathVariable String email) {
        return userHandlerApi.hasAlreadyName(email);
    }

    @PostMapping
    public User add(@RequestBody AddUserRequest request) {
        return userHandlerApi.add(request.getFirstName(), request.getLastName(), request.getEmail());
    }

    @GetMapping("/{name}/score")
    public ScoreResponse getScore(@PathVariable String name, @RequestParam Long quizId) {
        return userHandlerApi.getScore(name, quizId);
    }
}
