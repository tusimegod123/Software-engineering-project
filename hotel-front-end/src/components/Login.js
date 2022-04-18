import React from "react";
import "../App.css";
import axios from "axios";
import Container from "react-bootstrap/Container";
import { Row, Col, Form, Button } from "react-bootstrap";
import NavBar from "./NavBar";
class Login extends React.Component {
  state = {
    email: "",
    password: "",
  };

  changeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  submitHandler = (event) => {
    event.preventDefault();
    let temp = { ...this.state };
    axios
      .post("http://localhost:8080/authenticate", temp)
      .then((res) => {
        console.log(res);
        localStorage.setItem("access-token", JSON.stringify(res.data));
        // window.location = "/booking";
      })
      .catch((err) => console.log(err));
  };
  render() {
    return (
      <div id="signup">
        <NavBar />
        <Container fluid>
          <Row>
            <Col>
              <Form id="form" onSubmit={this.submitHandler}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Label>Email address or Username</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter email"
                    name="email"
                    onChange={this.changeHandler}
                  />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Password"
                    onChange={this.changeHandler}
                    name="password"
                  />
                </Form.Group>
                <Button id="button" type="submit">
                  Login
                </Button>
              </Form>
            </Col>
            <Col></Col>
            <Col></Col>
            <Col>
              <p id="signupp">Welcome To Our World, Get Ready By Signing Up</p>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Login;
