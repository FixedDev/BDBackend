package me.fixeddev.basededatos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.fixeddev.basededatos.models.Role;
import me.fixeddev.basededatos.models.User;
import me.fixeddev.basededatos.repositories.RoleRepository;
import me.fixeddev.basededatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class AuthController {

    private UserRepository repository;
    private RoleRepository roleRepository;

    private ObjectMapper mapper;

    @Autowired
    public AuthController(UserRepository repository, RoleRepository roleRepository, ObjectMapper mapper) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String loginController(@RequestBody LoginBody body) {
        Optional<User> user = repository.findByEmail(body.email);

        ObjectNode node = mapper.createObjectNode();

        if (user.isEmpty()) {
            node.put("error", "User not found");
            return node.toString();
        }

        User userObj = user.get();

        if (userObj.getPassword().equals(body.password)) {
            node.put("response", true);
            node.put("data", mapper.valueToTree(userObj));

            return node.toString();
        }

        node.put("response", false);

        return node.toString();
    }

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String signup(@RequestBody RegisterBody body) {
        Optional<User> optUser = repository.findByEmail(body.email);

        ObjectNode node = mapper.createObjectNode();

        if (optUser.isPresent()) {
            node.put("response", false);
            node.put("error", "User already exists");

            return node.toString();
        }

        Optional<Role> optionalRole = roleRepository.findById(body.roleId);

        if (optionalRole.isEmpty()) {
            node.put("response", false);
            node.put("error", "Role not found");

            return node.toString();
        }

        Role role = optionalRole.get();

        User user = new User();
        user.setFirstName(body.firstName);
        user.setLastNamePaternal(body.lastNamePaternal);
        user.setLastNameMaternal(body.lastNameMaternal);
        user.setEmail(body.email);
        user.setPassword(body.password);
        user.setRole(role);

        user = repository.save(user);

        node.put("response", true);
        node.put("data", mapper.valueToTree(user));

        return node.toString();
    }


    public static class LoginBody {
        private String email;
        private String password;

        public LoginBody(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public LoginBody() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "LoginBody{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


    public record RegisterBody(
            String firstName,
            String lastNamePaternal,
            String lastNameMaternal,
            String email,
            String password,
            long roleId
    ) {
    }
}
