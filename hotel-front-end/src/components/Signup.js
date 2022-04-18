import React from "react";
import "../App.css";
import Container from "react-bootstrap/Container";
import { Row, Col, Form, Button } from "react-bootstrap";
import axios from "axios";
import NavBar from "./NavBar";

class Signup extends React.Component {
  state = {
    email: "",
    password: "",
    fullName: "",
  };

  changeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  submitHandler = (event) => {
    event.preventDefault();
    const myUserData = {
      fullName: this.state.fullName,
      email: this.state.email,
      password: this.state.password,
    };

    axios
      .post("http://localhost:8080/register", myUserData)
      .then((res) => {
        console.log(res);

        window.location = "/login";
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
                  <Form.Label>Full Name</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Enter name"
                    name="fullName"
                    onChange={this.changeHandler}
                  />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control
                    type="email"
                    placeholder="Enter email"
                    name="email"
                    onChange={this.changeHandler}
                  />
                  <Form.Text className="text-muted">
                    We'll never share your email with anyone else.
                  </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Password"
                    name="password"
                    onChange={this.changeHandler}
                  />
                </Form.Group>
                <Button id="button" type="submit">
                  Sign Up
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
export default Signup;
