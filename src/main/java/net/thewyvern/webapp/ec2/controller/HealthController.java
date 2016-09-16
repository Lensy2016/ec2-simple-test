package net.thewyvern.webapp.ec2.controller;

//import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.thewyvern.webapp.ec2.controller.BaseController;

@Controller
public class HealthController extends BaseController {

	/**
	 * Checks to see if we're able to create new HTTP Session. If we are, just return status 200, otherwise 503.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<String> getApplicationStatus(HttpServletRequest request) {

	//	String now = LocalDateTime.now().toString();
		String logMessage;
		String responseMessage;
		HttpStatus responseStatus;

		HttpSession session = request.getSession(true);
		if (session == null) {
			logMessage = "NGPP service not available at: ";// + now;
			responseMessage = logMessage;
			responseStatus = HttpStatus.SERVICE_UNAVAILABLE;
		} else {
			session.invalidate();
			logMessage = "NGPP Status OK as of: ";// + now;
			responseMessage = logMessage;
			responseStatus = HttpStatus.OK;
		}
		return new ResponseEntity<>(responseMessage, responseStatus);
	}

}
