import React, { Component } from "react"

import Provinces from './Provinces'
import Territories from './Territories'
import Covid19 from "./Covid19"

import './App.css';


class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      selectedMenu: 'p'
    }
  }

  render() {
    return (
      <div className="App">
        <h1>Hello Canada</h1>
        <img alt="Canada's Flag" width={125} src="https://upload.wikimedia.org/wikipedia/commons/d/d9/Flag_of_Canada_%28Pantone%29.svg" />

        <div className="menu">
          <p className="menu-item" onClick={() => this.setState({ selectedMenu: 'p' })}>Provinces</p>
          <p className="menu-item" onClick={() => this.setState({ selectedMenu: 't' })}>Territories</p>
          <p className="menu-item" onClick={() => this.setState({ selectedMenu: 'c' })}>Covid-19</p>
        </div>

        {this.state.selectedMenu === 'p' ?
          <Provinces />
          :
          this.state.selectedMenu === 't' ?
            <Territories />
            :
            <Covid19 />
        }
      </div>
    );
  }
}


export default App;
