package application.controller.api;

import application.authen.MySQLUserDetailsService;
import application.jwt.JwtUtil;
import application.model.api.Response;
import application.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticateApiController {

    @Autowired
    private MySQLUserDetailsService mySQLUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception( "BadCredentialsException" + e);
        }

        final UserDetails userDetails = mySQLUserDetailsService.loadUserByUsername(userDTO.getUserName());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new Response(jwt));
    }
}
