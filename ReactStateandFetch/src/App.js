import React, {Component} from 'react';
import CountryTable from "./CountryTable";
import './App.css';

class App extends Component {
  
  constructor(props){
    super(props);
    this.state = {
      countries: [], 
      err:"",
      labels: []
    
    } 
  }

  async componentDidMount() {
    try {
      var data = await this.props.factory.getCountries(); //factory se index.js
      this.setState({ countries: data, err: ""});


      var labelsData = await this.props.factory.getLabels();
      this.setState({ labels: labelsData, err: ""}); 
    } catch (err) {
      
    }
  }

  render() {
    return (
      <div>
        <div className="App-header">
          <h2>React, State, Fetch and Mobx</h2>
        </div>
        <div className="App-intro">
          <p>Your initial task is to fetch data from the server (see exercise for how to start it),
           and create a table below, with these data</p>          
          <CountryTable
            countries={this.state.countries}
            labels={this.state.labels}
          />
        </div>
      </div>
    );
  }
}

export default App;
