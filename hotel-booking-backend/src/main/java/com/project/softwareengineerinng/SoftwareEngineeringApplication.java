package com.project.softwareengineerinng;

//import com.project.softwareengineerinng.repository.ReservationRepository;
import com.project.softwareengineerinng.repository.RoomRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {
//	@Autowired
//	private ReservationRepository reservationRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public void run(String... args) throws Exception {
		//  Room ro1=new Room(2,"Double",30.0,"Small",2,2,false,"wifi Available",false);
		//  Room ro2=new Room(3,"Double",50.0,"King",3,2,false,"wifi Available",false);

		//  ro1=roomRepository.save(ro1);
		//  ro2=roomRepository.save(ro2);
//		 Reservation r1=new Reservation(101,
//		 LocalDate.of(2022,4,19),LocalDate.of(2022,4,25),300.0,2);
//		// Room room = roomRepository.findAll().get(2);
//		 //r1.addRoom(ro1);
//		 r1 = reservationRepository.save(r1);
//		// ro2.setReservation(r1);
//		 r1.addRoom(ro1);
//		 r1.addRoom(ro2);
//		 reservationRepository.save(r1);
	}

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
