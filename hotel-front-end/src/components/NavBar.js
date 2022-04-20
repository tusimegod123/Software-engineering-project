import React from "react";
import "../App.css";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Container from "react-bootstrap/Container";
import NavDropdown from "react-bootstrap/NavDropdown";

class NavBar extends React.Component {
  render() {
    return (
      <div>
        <Navbar className="nav-custom" expand="lg">
          <Container>
            <Navbar.Brand id="try" href="/">
              Maharishi Hotel
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto" style={{ color: "white" }}>
                <Nav.Link href="/booking" style={{ color: "white" }}>
                  Make A Reservation
                </Nav.Link>
                <Nav.Link href="/rooms" style={{ color: "white" }}>
                  Rooms Management
                </Nav.Link>
                <NavDropdown title="More Actions" id="basic-nav-dropdown">
                  <NavDropdown.Item href="/bookings">Bookings</NavDropdown.Item>
                  <NavDropdown.Item href="/myreservations">
                    My Reservation
                  </NavDropdown.Item>
                </NavDropdown>
              </Nav>
              <Nav.Link href="/login" style={{ color: "white" }}>
                Login
              </Nav.Link>
              <Nav.Link style={{ color: "white" }}>Username</Nav.Link>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <br></br>
      </div>
    );
  }
}
export default NavBar;
