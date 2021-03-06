package com.wellsfargo.fsd.its.controller;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.AttendeeModel;
import com.wellsfargo.fsd.its.model.InterviewModel;
import com.wellsfargo.fsd.its.model.UserModel;
import com.wellsfargo.fsd.its.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewRestController {

	@Autowired
	private InterviewService interviewService;

	@GetMapping("/getAllInterviews")
	public ResponseEntity<Set<InterviewModel>> getAllInterviews() {
		return new ResponseEntity<Set<InterviewModel>>(interviewService.getAllInterviewDetails(), HttpStatus.OK);
	}

	@GetMapping("/getCountOfInterviews")
	public ResponseEntity<String> getCountOfInterviews() {
		return new ResponseEntity<>(interviewService.getCountOfInterviews(), HttpStatus.OK);
	}

	@GetMapping("/showAttendee/{id}")
	public ResponseEntity<Set<UserModel>> showAttendees(@PathVariable("id") int interviewId) throws ITSException {
		return new ResponseEntity<>(interviewService.showUsers(interviewId), HttpStatus.OK);
	}

	@GetMapping("/searchInterviews/{InterviewName}/{InterviewerName}")
	public ResponseEntity<Set<InterviewModel>> searchInterviews(@PathVariable("InterviewName") String interviewName,
			@PathVariable("InterviewerName") String interviewerName) {
		ResponseEntity<Set<InterviewModel>> resp = null;
		Set<InterviewModel> interview = interviewService.searchInterviews(interviewName, interviewerName);

		if (interview != null) {
			resp = new ResponseEntity<>(interview, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return resp;
	}

	@PostMapping
	public ResponseEntity<InterviewModel> addInterview(@RequestBody @Valid InterviewModel interview,
			BindingResult result) throws ITSException {
		if (result.hasErrors()) {
			throw new ITSException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewService.addInterview(interview), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInterview(@PathVariable("id") int interviewId) throws ITSException {
		interviewService.deleteInterview(interviewId);
		return new ResponseEntity<>("Interview Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/addAttendee")
	public ResponseEntity<String> addAttendee(@RequestBody @Valid AttendeeModel attendee, BindingResult result)
			throws ITSException {
		if (result.hasErrors()) {
			throw new ITSException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewService.addAttendee(attendee), HttpStatus.OK);
	}

	@PutMapping("/updateStatusOfInterview/{interviewid}/{status}")
	public ResponseEntity<InterviewModel> updateStatusOfInterview(@PathVariable("interviewid") int interviewId,
			@PathVariable("status") String status) throws ITSException {
		return new ResponseEntity<>(interviewService.updateStatusOfInterview(interviewId, status), HttpStatus.OK);
	}
}
