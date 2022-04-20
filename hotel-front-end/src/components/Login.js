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
      .post("http://localhost:8080/api/authenticate", temp)
      .then((res) => {
        console.log(res);
        localStorage.setItem("access-token", JSON.stringify(res.data));
        window.location = "/booking";
      })
      .catch((err) => console.log(err));
  };
  render() {
    return (
      <div id="signup">
        <NavBar />
        <Container fluid>
          <Row>
            <Col md={2}></Col>
            <Col>
              <Form id="form" onSubmit={this.submitHandler}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Label>Email address or Username</Form.Label>
                  <Form.Control
                    size="lg"
                    type="text"
                    placeholder="Enter email"
                    name="email"
                    onChange={this.changeHandler}
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control
                    size="lg"
                    type="password"
                    placeholder="Password"
                    onChange={this.changeHandler}
                    name="password"
                  />
                </Form.Group>
                <br></br>
                <Button id="button" type="submit" size="lg">
                  Login
                </Button>
                <br></br>
                <br></br>
                <h1 style={{ textAlign: "center" }}>OR</h1>
                <br></br>
                <Button
                  style={{
                    backgroundColor: "#C8BFBA",
                    fontSize: "1.2rem",
                    width: "45%",
                  }}
                >
                  <img
                    src="/google.png"
                    style={{ width: "40px", padding: "5px" }}
                    alt=""
                  />
                  Google
                </Button>
                {"      "}

                <Button
                  style={{
                    backgroundColor: "#fff",
                    color: "#000",
                    fontSize: "1.2rem",
                    width: "50%",
                  }}
                >
                  <img
                    src="/apple.png"
                    style={{ width: "40px", padding: "5px" }}
                    alt="Apple"
                  />
                  Apple
                </Button>
              </Form>
            </Col>

            <Col>
              <p id="Loginn">Login to your account</p>
              <p
                style={{
                  color: "white",
                  fontFamily: "Avenir",
                  fontSize: "1.3rem",
                  paddingTop: "150px",
                  fontStyle: "italic",
                }}
              >
                Have an account? <a href="/signup">Sign up</a>
              </p>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Login;
