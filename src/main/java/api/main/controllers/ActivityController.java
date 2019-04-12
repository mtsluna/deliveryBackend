package api.main.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(path = "api/v1/activity")
public class ActivityController {

	@GetMapping("/")
	public ResponseEntity getAll() {
		
		return ResponseEntity.status(200).body("{ \"Status\": \"SERVER ON.\" }");
		
	}
	
}
