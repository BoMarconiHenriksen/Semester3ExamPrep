import React, { Component } from 'react';
import './App.css';
import ApiFacade from './ApiFacade';

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

  onChange = (evt) => {
    this.setState({ [evt.target.id]: evt.target.value });
  }

  onSubmit = (evt) => {
    evt.preventDefault();

    this.componentDidMount();
  }

  render() {

    const rowPersons = this.state.persons && this.state.persons.map((person) => (
      <tr key={person.id}>
        <td>{person.id}</td>
        <td>{person.firstName}</td>
        <td>{person.lastName}</td>
        <td>{person.age}</td>
      </tr>
    ))

    return (

      <div className="App">

        <form onSubmit={this.onSubmit} onChange={this.onChange} >
          <div>
            <input placeholder="Number of Persons" id="number" />
            <button>search</button>
          </div>

          <div className="container" />
        </form>

        <table className="table">
          <thead><th>Id</th><th>First Name</th><th>Last Name</th><th>Age</th></thead>
          <tbody>
            {rowPersons}
          </tbody>
        </table>

      </div>
    );
  }
}

export default App;
