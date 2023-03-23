package com.agsdashboard.get.agsAggController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agsdashboard.get.agsAggEntity.agsAggEntity;
import com.agsdashboard.get.agsAggEntity.queryPagePosition;
import com.agsdashboard.get.agsAggService.agsAggService;

@CrossOrigin("*")
@RestController
public class agsAggController {

	@Autowired
	private agsAggService agsService;

	@GetMapping("/getEntry")
	public List<agsAggEntity> findAll() {
		return agsService.getAllEntries();
	}

	@GetMapping("/getByDate")
	public List<agsAggEntity> findByDate(@RequestParam String startDate) {
		return agsService.getEntryByDate(startDate);
	}

	@GetMapping("/getByQuery")
	public List<agsAggEntity> findByQuery(@RequestParam String query) {
		return agsService.getEntryByQuery(query);
	}

	@GetMapping("/getByPage")
	public List<agsAggEntity> findByPage(@RequestParam String page) {
		return agsService.getEntryByPage(page);
	}

	@GetMapping("/getPageCount")
	public int findEntryperpage(@RequestParam String page) {
		return agsService.getEntryCountbyPage(page);
	}

	@GetMapping("/getPagePositionforKeyword")
	public List<queryPagePosition> findCurrentSERPostion(@RequestParam String query, @RequestParam String page) {
		return agsService.getPositionByKeyword(query, page);
	}

	@GetMapping("/getAgsEntry")
	public List<agsAggEntity> findEntryByCustomSearch(@RequestParam String query, @RequestParam String page,
			@RequestParam String startDate, @RequestParam String endDate) {
		return agsService.getEntryByCustomSearch(query, page, startDate, endDate);
	}

}
