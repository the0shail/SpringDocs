package the.zero.shail.sender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import the.zero.shail.sender.models.UserModel;
import the.zero.shail.sender.services.UserService;
import the.zero.shail.sender.util.ServerResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ServerResponse<List<UserModel>>> findAll() {
        return new ResponseEntity<>(
                new ServerResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.toString(),
                        userService.findAll(),
                        LocalDateTime.now()
                ), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServerResponse<UserModel>> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(
                new ServerResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.toString(),
                        userService.findById(id),
                        LocalDateTime.now()
                ), HttpStatus.OK
        );
    }
}
