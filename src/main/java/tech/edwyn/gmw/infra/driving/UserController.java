package tech.edwyn.gmw.infra.driving;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.edwyn.gmw.domain.UserHandlerApi;
import tech.edwyn.gmw.domain.model.User;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserHandlerApi userHandlerApi;

    @GetMapping("/verify/{name}")
    public Boolean verifyName(@PathVariable String name) {
        return userHandlerApi.hasAlreadyName(name);
    }

    @PostMapping("/{name}")
    public User add(@PathVariable String name) {
        return userHandlerApi.add(name);
    }

    @GetMapping("/{name}/score")
    public Integer getScore(@PathVariable String name) {
        return userHandlerApi.getScore(name);
    }
}
