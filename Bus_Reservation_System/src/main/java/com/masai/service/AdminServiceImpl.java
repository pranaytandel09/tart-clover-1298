package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BusDoesNotExistException;
import com.masai.exception.RouteDoesNotExistException;
import com.masai.model.Bus;
import com.masai.model.Route;
import com.masai.repository.AdminRepository;
import com.masai.repository.BusRepository;
import com.masai.repository.RouteRepository;

import jakarta.validation.Valid;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	private BusRepository busRepository;
	private RouteRepository routeRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository,BusRepository busRepository,RouteRepository routeRepository) {
		
		this.adminRepository =adminRepository;
		this.busRepository =busRepository;
		this.routeRepository =routeRepository;
	}

	@Override
	public Bus addNewBus(@Valid Bus bus) {
		// TODO Auto-generated method stub
		
		Route route = bus.getRoute();
		List<Bus> busList = route.getBus();
		busList.add(bus);
		route.setBus(busList);
		
		return busRepository.save(bus);
	}

	@Override
	public Bus updateBus(@Valid Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}

	@Override
	public Bus deleteBus(Integer busId) {
		// TODO Auto-generated method stub
		Bus bus = busRepository.findById(busId).get();
		if(bus==null)throw new BusDoesNotExistException("Bus does not exist with given busId: "+busId);
		busRepository.deleteById(busId);
		return bus;
	}

	@Override
	public Bus getBusById(Integer busId) {
		// TODO Auto-generated method stub
		Optional<Bus> op = busRepository.findById(busId);
		
		return op.orElseThrow(()->new BusDoesNotExistException("Bus does not exist with given busId: "+busId));
	}

	@Override
	public List<Bus> getAllBuses() {
		// TODO Auto-generated method stub
		List<Bus> busList = busRepository.findAll();
		
		if(busList.size()==0)throw new BusDoesNotExistException("Bus does not exists!");
		
		return busList;
	}

	@Override
	public List<Bus> getAllBusesByType(String busType) {
		// TODO Auto-generated method stub
		List<Bus> busList = busRepository.findAllByType(busType);
		if(busList.size()==0)throw new BusDoesNotExistException("Bus does not exists!");
		
		return busList;
	}

	//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
	
	@Override
	public Route addNewRoute(@Valid Route route) {
		// TODO Auto-generated method stub
		return routeRepository.save(route);
	}

	@Override
	public Route updateRoute(@Valid Route route) {
		// TODO Auto-generated method stub
		return routeRepository.save(route);
	}

	@Override
	public Route deleteRoute(Integer routeId) {
		// TODO Auto-generated method stub
		Route route = routeRepository.findById(routeId).get();
		if(route==null)throw new RouteDoesNotExistException("Route does not exist with route id: "+routeId);
		
		routeRepository.deleteById(routeId);
		return route;
	}

	@Override
	public Route getRouteById(Integer routeId) {
		// TODO Auto-generated method stub
		Optional<Route> op = routeRepository.findById(routeId);
		return op.orElseThrow(()-> new RouteDoesNotExistException("Route does not exist with route id: "+routeId));
	}

	@Override
	public List<Route> getAllRoute() {
		// TODO Auto-generated method stub
		List<Route> list = routeRepository.findAll();
		if(list.size()==0)throw new RouteDoesNotExistException("Route does not exists!");
	
		return list;
	}
}
