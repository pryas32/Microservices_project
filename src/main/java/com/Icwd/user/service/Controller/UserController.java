package com.Icwd.user.service.Controller;

import com.Icwd.user.service.entities.User;
import com.Icwd.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // Create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveuser(user); // Saving user in the database and getting the same one
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    @GetMapping("/{userId}")
   /// @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod="ratingHotelFallback")

    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get Single User handler:UserController");
       // logger.info("Retry count: {}",retryCount);

        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // Fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        //logger.info("Fallback is executed because service is down: {}", ex.getMessage());

        ex.printStackTrace();

        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created as a dummy because some service is down")
                .userId("31221")
                .build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);//return type of both the method should be same and also the field in fallback should match the above one.
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
