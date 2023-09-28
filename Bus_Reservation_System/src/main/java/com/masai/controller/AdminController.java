package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Bus;
import com.masai.model.Route;
import com.masai.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController("/admin")
@EnableWebSecurity
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	//service realated to bus------------------------------->
	
	@PostMapping("/buses")
	public ResponseEntity<Bus>addNewBus(@Valid @RequestBody Bus bus){
		
		return new ResponseEntity<Bus>(adminService.addNewBus(bus), HttpStatus.CREATED);
	}
	
	@PutMapping("/buses")
	public ResponseEntity<Bus>updateBus(@Valid @RequestBody Bus bus){
		
		return new ResponseEntity<Bus>(adminService.updateBus(bus), HttpStatus.OK);
	}
	
	@DeleteMapping("/buses/{busId}")
	public ResponseEntity<Bus>deleteBus(@PathVariable Integer busId){
		
		return new ResponseEntity<Bus>(adminService.deleteBus(busId), HttpStatus.CREATED);
	}
	
	@GetMapping("/buses/{busId}")
	public ResponseEntity<Bus>getBusById(@PathVariable Integer busId){
		
		return new ResponseEntity<Bus>(adminService.getBusById(busId), HttpStatus.OK);
	}
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>>getAllBuses(){
		
		return new ResponseEntity<List<Bus>>(adminService.getAllBuses(), HttpStatus.OK);
	}
	
	@GetMapping("/buses/{busType}")
	public ResponseEntity<List<Bus>>getAllBusesByType(@PathVariable String busType){
		
		return new ResponseEntity<List<Bus>>(adminService.getAllBusesByType(busType), HttpStatus.OK);
	}
	
	//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	
	
	@PostMapping("/routes")
	public ResponseEntity<Route>addNewRoute(@Valid @RequestBody Route route){
		
		return new ResponseEntity<Route>(adminService.addNewRoute(route), HttpStatus.CREATED);
	}
	
	@PutMapping("/routes")
	public ResponseEntity<Route>updateRoute(@Valid @RequestBody Route route){
		
		return new ResponseEntity<Route>(adminService.updateRoute(route), HttpStatus.OK);
	}
	
	@DeleteMapping("/routes/{routeId}")
	public ResponseEntity<Route>deleteRoute(@PathVariable Integer routeId){
		
		return new ResponseEntity<Route>(adminService.deleteRoute(routeId), HttpStatus.OK);
	}
	
	@GetMapping("/routes/{routeId}")
	public ResponseEntity<Route>getRouteById(@PathVariable Integer routeId){
		
		return new ResponseEntity<Route>(adminService.getRouteById(routeId), HttpStatus.OK);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>>getAllRoute(){
		
		return new ResponseEntity<List<Route>>(adminService.getAllRoute(), HttpStatus.OK);
	}
}
