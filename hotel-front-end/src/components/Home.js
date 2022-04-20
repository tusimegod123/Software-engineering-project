import React from "react";
import "../App.css";
import Container from "react-bootstrap/Container";
import { Row, Col } from "react-bootstrap";
import NavBar from "./NavBar";

class Home extends React.Component {
  render() {
    return (
      <div id="container">
        {/* <Navbar className="nav-custom" expand="lg">
          <Container>
            <Navbar.Brand id="try" href="#home">
              Maharishi Hotel
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link href="#home">Contact Us</Nav.Link>
                <Nav.Link href="#link">Link</Nav.Link>
                <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                  <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                  <NavDropdown.Item href="#action/3.2">
                    Another action
                  </NavDropdown.Item>
                  <NavDropdown.Item href="#action/3.3">
                    Something
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#action/3.4">
                    Separated link
                  </NavDropdown.Item>
                </NavDropdown>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar> */}

        <NavBar />
        <br></br>
        <Container fluid>
          <Row>
            <Col></Col>
            <Col></Col>
            <Col></Col>
            <Col className="welcome">Welcome To Maharishi Hotel</Col>
          </Row>
        </Container>
        <Container style={{ marginTop: 365 }} fluid>
          <Row>
            <Col className="reserve">
              Would You Like To Make Reservations With Us? Click{" "}
              <span>
                <a href="http://localhost:3000/signup">Here </a>
              </span>{" "}
              To Continue.
            </Col>
            <Col></Col>
            <Col></Col>
          </Row>
        </Container>
        <Container fluid>
          <Row>
            <Col></Col>
            <Col></Col>
            <Col></Col>
            <Col></Col>
            <Col className="rights">All Rights Reserved</Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Home;
