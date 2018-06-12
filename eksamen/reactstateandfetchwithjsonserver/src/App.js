import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      countries: [],
      err: "",
      labels: []

    }
  }

  async componentDidMount() {
    try {
      var data = await this.props.factory.getCountries(); //factory se index.js
      this.setState({ countries: data, err: "" });


      var labelsData = await this.props.factory.getLabels();
      this.setState({ labels: labelsData, err: "" });
    } catch (err) {

    }
  }

  render() {
    return (
      <div className="App">

        <CountryTable
          countries={this.state.countries}
          labels={this.state.labels}
        />

      </div>
    );
  }
}

export default App;
