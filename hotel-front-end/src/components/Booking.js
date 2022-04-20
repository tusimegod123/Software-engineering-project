import React from "react";
import "../App.css";
import Container from "react-bootstrap/Container";
import { Row, Col, Form, Button, Card } from "react-bootstrap";
import axios from "axios";
import NavBar from "./NavBar";

class Booking extends React.Component {
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
      <div id="booking">
        <NavBar />
        <br></br>
        <Container fluid>
          <Row>
            <Col>
              <Form id="booking-form" onSubmit={this.submitHandler}>
                <h3 style={{ textAlign: "center" }}>Make Your Reservation</h3>
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
                <div>
                  <Card style={{ width: "14rem" }}>
                    <Card.Body>
                      <Card.Title style={{ color: "black" }}>
                        Card Title
                      </Card.Title>
                      <Card.Text style={{ color: "black" }}>
                        Some quick example text to build on the card title and
                        make up the bulk of the card's content.
                      </Card.Text>
                      <Button variant="primary">Remove</Button>
                    </Card.Body>
                  </Card>
                </div>
                <Button id="button" type="submit">
                  Submit
                </Button>
              </Form>
              <div>
                <Card style={{ width: "18rem" }}>
                  <Card.Img variant="top" src="holder.js/100px180" />
                  <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                      Some quick example text to build on the card title and
                      make up the bulk of the card's content.
                    </Card.Text>
                    <Button variant="primary">Go somewhere</Button>
                  </Card.Body>
                </Card>
              </div>
            </Col>

            <Col>
              <div id="image-div">
                <p className="welcome">
                  Welcome To Our World, Book With Us And Enjoy Your Stay..
                </p>
                <img src="/hotel.jpg" height="530" width="660" alt=""></img>
              </div>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Booking;
