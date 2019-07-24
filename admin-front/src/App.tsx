import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { Button, Select } from "antd";

const App: React.FC = () => {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <Button type="primary">https://reactjs.org</Button>
      </header>
    </div>
  );
};

export default App;
