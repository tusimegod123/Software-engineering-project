import React from "react";
import "../App.css";
import Container from "react-bootstrap/Container";
import { Row, Col, Form, Button, Card, Table } from "react-bootstrap";
import axios from "axios";
import NavBar from "./NavBar";

class RoomsComponent extends React.Component {
  state = {
    dateOfArrival: "",
    dateOfDeparture: "",
    numberOfRooms: "",
    otherReservations: "",
  };

  changeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  submitHandler = (event) => {
    event.preventDefault();
    const bookingDetails = {
      dateOfArrival: this.state.dateOfArrival,
      dateOfDeparture: this.state.dateOfDeparture,
      numberOfRooms: this.state.password,
      otherReservations: this.state.otherReservations,
    };

    axios
      .post("http://localhost:8080/booking", bookingDetails, {
        headers: {
          Authorization:
            "Bearer " + localStorage.getItem("access-token").replace(/"/g, ""),
        },
      })
      .then((res) => {
        console.log(res);
        //window.location = "/";
      })
      .catch((err) => console.log(err));
  };
  render() {
    return (
      <div id="rooms-div">
        <NavBar />

        <Container fluid>
          <Row>
            <div id="back">
              <a href="http://localhost:3000/" id="back">
                Back Home
              </a>
            </div>
            <Col>
              <Form id="room-form" onSubmit={this.submitHandler}>
                <Row className="mb-3">
                  <Form.Group
                    as={Col}
                    className="mb-3"
                    controlId="formBasicEmail"
                  >
                    <Form.Label>Date of Arrival</Form.Label>
                    <Form.Control
                      type="date"
                      name="dateOfArrival"
                      onChange={this.changeHandler}
                    />
                  </Form.Group>
                  <Form.Group as={Col} controlId="formBasicEmail">
                    <Form.Label>Date Of Departure</Form.Label>
                    <Form.Control
                      type="date"
                      name="dateOfDeparture"
                      onChange={this.changeHandler}
                    />
                  </Form.Group>
                </Row>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Label>Number of Rooms</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter Number of Rooms"
                    name="numberOfRooms"
                    onChange={this.changeHandler}
                  />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Other Reservations</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Other Reservations other than Rooms"
                    name="otherReservations"
                    onChange={this.changeHandler}
                  />
                </Form.Group>

                <Button id="button" type="submit">
                  Submit
                </Button>
              </Form>
            </Col>

            <Col>
              <div id="image-div">
                <p className="welcome">
                  Welcome To Our World, Book With Us And Enjoy Your Stay..
                </p>
                <img src="/hotel.jpg" height="500" width="660"></img>
              </div>
            </Col>
          </Row>
        </Container>
        <Container>
          <Row>
            <Col>
              <Table striped bordered hover size="sm">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td colSpan={2}>Larry the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </Table>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default RoomsComponent;
