package com.hst.learninghub.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@GetMapping("/echo/{message}")
	public String greeting(@PathVariable String message) {
		return message;
	}

}
