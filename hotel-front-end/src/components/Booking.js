import React from "react";
import "../App.css";
import Container from "react-bootstrap/Container";
import { Row, Col } from "react-bootstrap";
import NavBar from "./NavBar";
import AddBookingForm from "./AddBookingForm";
import AvailableRoomList from "./AvailableRoomList";
import axios from "axios";

class Booking extends React.Component {
  state = {
    rooms: [],
    selectedRooms: []
  }

  componentDidMount() {
    this.getRooms();
  }

  getRooms = () => {
    axios.get("http://localhost:8080/api/rooms/", {
      headers: {
        Authorization:
          "Bearer " + localStorage.getItem("access-token").replace(/"/g, ""),
      },
    }).then((res) => {
      this.setState({
        rooms: res.data.map((room) => {
          return {
            ...room,
            selected: false
          };
        }),
      }).catch((error) => console.log(error));
    });
  }

  addRoom = (room) => {
    room.selected = true;
    let { selectedRooms } = this.state;
    if(selectedRooms && selectedRooms.length > 0){
      selectedRooms = [
        ...this.state.selectedRooms.filter(aRoom => aRoom.roomNumber !== room.roomNumber),
        room
      ]
    } else {
      selectedRooms = [room]
    }
    this.setState({
      selectedRooms,
      rooms: [
        room,
        ...this.state.rooms.filter(aRoom => aRoom.roomNumber !== room.roomNumber)
      ]
    })
  }

  removeRoom = (room) => {
    room.selected = false;
    this.setState({
      selectedRooms : [
          ...this.state.selectedRooms.filter(aRoom => aRoom.roomNumber !== room.roomNumber),
      ],
      rooms: [
        room,
        ...this.state.rooms.filter(aRoom => aRoom.roomNumber !== room.roomNumber)
      ]
    })
  }
  render() {
    const { rooms, selectedRooms } = this.state;
    return (
      <div id="booking">
        <NavBar />
        <Container fluid>
        <Row>
        <Col>
              <div id="image-div" style={{"margin":"0 auto 1rem"}}>
                <p className="welcome" style={{ "textAlign": "center"}}>
                  Welcome To Our World, Book With Us And Enjoy Your Stay..
                </p>
                <img style={{
                  "height" : "200px",
                  "margin" : "0 auto",
                  "display" : "block"
                }} src="/hotel.jpg" height="530" width="660" alt=""></img>
              </div>
            </Col>
        </Row>
          <Row>
            <Col>
              <AddBookingForm rooms={selectedRooms} />
            </Col>
            <Col>
              {rooms.length > 0 ? 
              <AvailableRoomList 
                rooms={this.state.rooms} 
                addRoom={this.addRoom} 
                removeRoom={this.removeRoom} /> 
              : <>No Rooms available</>}
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Booking;
