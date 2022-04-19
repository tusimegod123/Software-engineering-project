import "./App.css";
import { Routes, Route } from "react-router-dom";
import Home from './components/Home';
import ProductComponent from "./components/ProductCompnent";
import Signup from "./components/Signup";
import Login from "./components/Login";
import Booking from "./components/Booking";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/">
          <Home />
        </Route>
        <Route path="/signup">
          <Signup />
        </Route>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="/booking">
          <Booking />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
