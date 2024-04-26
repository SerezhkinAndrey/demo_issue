package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@Slf4j
@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class LongIOOperationController {

	private static final Logger log = LoggerFactory.getLogger(LongIOOperationController.class);

	@GetMapping("/long_io_operation")
	public String handleReqDefResult() {
		log.info("Received async-deferredresult request");

		try {
			for (int i = 0; i < 30; i++) {
				log.info("long_io_operation log " + i + " " + Thread.currentThread().getName());
				TimeUnit.MILLISECONDS.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "long_io_operation";
	}

	@GetMapping("/just_log")
	String hello_just_log() {
		log.info("Just_log");
		return "Just_log";
	}

}
