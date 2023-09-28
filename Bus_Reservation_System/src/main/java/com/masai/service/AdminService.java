package com.masai.service;

import java.util.List;

import com.masai.model.Admin;
import com.masai.model.Bus;
import com.masai.model.Route;

import jakarta.validation.Valid;

public interface AdminService {
	
	Admin addNewAdmin(@Valid Admin admin);
	
//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

	Bus addNewBus(@Valid Bus bus);

	Bus updateBus(@Valid Bus bus);

	Bus deleteBus(Integer busId);

	Bus getBusById(Integer busId);

	List<Bus> getAllBuses();

	List<Bus> getAllBusesByType(String busType);

//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	
	Route addNewRoute(@Valid Route route);

	Route updateRoute(@Valid Route route);

	Route deleteRoute(Integer routeId);

	Route getRouteById(Integer routeId);

	List<Route> getAllRoute();

	
}
