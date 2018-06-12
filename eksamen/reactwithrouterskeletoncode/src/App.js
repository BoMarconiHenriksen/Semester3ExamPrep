import React, { Component } from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  HashRouter,
  Route,
  Link,
  NavLink,
  Switch,
} from 'react-router-dom';

// https://github.com/BoMarconiHenriksen/Semester3ExamPrep/tree/master/reactwithrouting
// https://github.com/BoMarconiHenriksen/Semester3ExamPrep/tree/master/reactandroutingbookstore

class App extends Component {
  render() {
    return (
      <div className="App">
        


      </div>
    );
  }
}

export default App;

const NoMatch = () => (
  <div>
    <h1>404 Wrong url!</h1>
  </div>
);
