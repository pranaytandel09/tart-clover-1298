package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BusDoesNotExistException;
import com.masai.exception.RouteDoesNotExistException;
import com.masai.model.Admin;
import com.masai.model.Bus;
import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.Role;
import com.masai.model.Route;
import com.masai.repository.AdminRepository;
import com.masai.repository.BusRepository;
import com.masai.repository.RoleRepository;
import com.masai.repository.RouteRepository;

import jakarta.validation.Valid;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	private BusRepository busRepository;
	private RouteRepository routeRepository;
	private RoleRepository roleRepository;
	private RoleService roleService;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository,BusRepository busRepository,RouteRepository routeRepository,RoleRepository roleRepository,RoleService roleService) {
		
		this.adminRepository =adminRepository;
		this.busRepository =busRepository;
		this.routeRepository =routeRepository;
		this.roleRepository =roleRepository;
		this.roleService =roleService;
	}
	
	
//-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

	@Override
	public Bus addNewBus(Integer routeId,@Valid Bus bus) {
		// TODO Auto-generated method stub
		
		Optional<Route> routeOp = routeRepository.findById(routeId);
		
		if(!routeOp.isPresent())throw new RouteDoesNotExistException("route does not exist with given routeId: "+routeId);
		Route route = routeOp.get();
		
		bus.setRoute(route);
		
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
		Optional<Bus> busOp = busRepository.findById(busId);
		
		if(!busOp.isPresent())throw new BusDoesNotExistException("bus does not exist with given routeId: "+busId);
		Bus bus = busOp.get();
		
		List<Reservation> reservation = bus.getReservation();
		for(Reservation r:reservation) {
			r.setBus(null);
		}
		
		List<Feedback> feedback = bus.getFeedback();
		for(Feedback f: feedback) {
			f.setBus(null);
		}
		
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
		
		List<Bus> bus = route.getBus();
		for(Bus b:bus) {
			b.setRoute(null);
		}
		
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
