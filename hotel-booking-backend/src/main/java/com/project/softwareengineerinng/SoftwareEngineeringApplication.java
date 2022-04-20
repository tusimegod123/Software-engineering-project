package com.project.softwareengineerinng;

import com.project.softwareengineerinng.model.*;
import com.project.softwareengineerinng.repository.ReservationRepository;
import com.project.softwareengineerinng.repository.RoomRepository;
import com.project.softwareengineerinng.repository.StayRepository;
import com.project.softwareengineerinng.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private StayRepository stayRepository;

	@Override
	public void run(String... args) throws Exception {
		// Room ro1=new Room(2,"Double",30.0,"Small",2,2,false,"wifi Available",false);
		// Room ro2=new Room(3,"Double",50.0,"King",3,2,false,"wifi Available",false);
		//
		// ro1=roomRepository.save(ro1);
		// ro2=roomRepository.save(ro2);
		// Reservation r1=new Reservation(101,
		// LocalDate.of(2022,4,19),LocalDate.of(2022,4,25),300.0,2);
		//// Room room = roomRepository.findAll().get(2);
		// //r1.addRoom(ro1);
		// r1 = reservationRepository.save(r1);
		//// ro2.setReservation(r1);
		// r1.addRoom(ro1);
		// r1.addRoom(ro2);
		// reservationRepository.save(r1);
		Stay s1=new Stay(LocalDate.of(2022,4,19),LocalDate.of(2022,4,25),2,30.0,true);
		ServiceReceived se1=new ServiceReceived(LocalDate.of(2022,04,19),"wifi",20.0);
		List<ServiceReceived> list=new ArrayList<>();
		list.add(se1);
		s1.setServiceReceived(list);
		stayRepository.save(s1);

	}

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
