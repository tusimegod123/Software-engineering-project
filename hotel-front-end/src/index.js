import React from "react";
//import ReactDOM from "react-dom";
import "./index.css";
import Signup from "./components/Signup";
import Login from "./components/Login";
import ProductComponent from "./components/ProductCompnent";
import Booking from "./components/Booking";
import reportWebVitals from "./reportWebVitals";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import { render } from "react-dom";
//import { BrowserRouter } from "react-router-dom";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<ProductComponent />}></Route>
      <Route path="/signup" element={<Signup />} />
      <Route path="/login" element={<Login />} />
      <Route path="/booking" element={<Booking />} />
    </Routes>
  </BrowserRouter>,
  rootElement
);
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
