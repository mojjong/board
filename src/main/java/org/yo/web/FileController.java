package org.yo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs/*")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
}
