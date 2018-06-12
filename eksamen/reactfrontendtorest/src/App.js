import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      number: '',
      persons: []
    }
  }

  async componentDidMount() {
    //Fetch all persons
    //const resultFromFetch = await ApiFacade.fetchAllUsers();

    //Fetch a specific number of persons
    const resultFromFetch = await ApiFacade.fetchNumberOfPersons(this.state.number);

    this.setState({ persons: resultFromFetch });
  }

  render() {
    return (
      <div className="App">



      </div>
    );
  }
}

export default App;
