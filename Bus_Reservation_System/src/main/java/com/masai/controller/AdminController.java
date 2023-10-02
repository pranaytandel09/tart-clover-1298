package com.masai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Admin;
import com.masai.model.Bus;
import com.masai.model.Route;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@EnableWebSecurity
public class AdminController {

	private AdminService adminService;
	private PasswordEncoder passwordEncoder;

	public AdminController(AdminService adminService,PasswordEncoder passwordEncoder) {
		super();
		this.adminService = adminService;
		this.passwordEncoder =passwordEncoder;
	}
	
	//service related to admin----------------------------->
	
	
	
	//service realated to bus------------------------------->
	
	@PostMapping("/add_buses/{routeId}")
	public ResponseEntity<Bus>addNewBus(@PathVariable Integer routeId, @Valid @RequestBody Bus bus){
		
		return new ResponseEntity<Bus>(adminService.addNewBus(routeId, bus), HttpStatus.CREATED);
	}
	
	@PutMapping("/update_buses")
	public ResponseEntity<Bus>updateBus(@Valid @RequestBody Bus bus){
		
		return new ResponseEntity<Bus>(adminService.updateBus(bus), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_buses/{busId}")
	public ResponseEntity<Bus>deleteBus(@PathVariable Integer busId){
		
		return new ResponseEntity<Bus>(adminService.deleteBus(busId), HttpStatus.CREATED);
	}
	
	@GetMapping("/get_buses_by_busId/{busId}")
	public ResponseEntity<Bus>getBusById(@PathVariable Integer busId){
		
		return new ResponseEntity<Bus>(adminService.getBusById(busId), HttpStatus.OK);
	}
	
	@GetMapping("/get_buses")
	public ResponseEntity<List<Bus>>getAllBuses(){
		
		return new ResponseEntity<List<Bus>>(adminService.getAllBuses(), HttpStatus.OK);
	}
	
	@GetMapping("/get_buses_by_type/{busType}")
	public ResponseEntity<List<Bus>>getAllBusesByType(@PathVariable String busType){
		
		return new ResponseEntity<List<Bus>>(adminService.getAllBusesByType(busType), HttpStatus.OK);
	}
	
	//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	
	
	@PostMapping("/add_routes")
	public ResponseEntity<Route>addNewRoute(@Valid @RequestBody Route route){
		
		return new ResponseEntity<Route>(adminService.addNewRoute(route), HttpStatus.CREATED);
	}
	
	@PutMapping("/update_routes")
	public ResponseEntity<Route>updateRoute(@Valid @RequestBody Route route){
		
		return new ResponseEntity<Route>(adminService.updateRoute(route), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_routes/{routeId}")
	public ResponseEntity<Route>deleteRoute(@PathVariable Integer routeId){
		
		return new ResponseEntity<Route>(adminService.deleteRoute(routeId), HttpStatus.OK);
	}
	
	@GetMapping("/get_routes_by_routeId/{routeId}")
	public ResponseEntity<Route>getRouteById(@PathVariable Integer routeId){
		
		return new ResponseEntity<Route>(adminService.getRouteById(routeId), HttpStatus.OK);
	}
	
	@GetMapping("/get_routes")
	public ResponseEntity<List<Route>>getAllRoute(){
		
		return new ResponseEntity<List<Route>>(adminService.getAllRoute(), HttpStatus.OK);
	}
}
