import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link,
  NavLink,
  Switch,
} from 'react-router-dom'
import './App.css';
import Welcome from './Welcome';
import All from './All';
import Details from './Details';

class App extends Component {
  
  render() {
    //console.log(this.state.users);
    return (

      <Router>
        <div>
          <nav className="navbar navbar-light">
            <ul className="nav navbar-nav">
              <li className="nav-item"><Link to="/">Home</Link></li>
              <li className="nav-item"><Link to="/all">All Users</Link></li>
            </ul>
          </nav>

          <Switch> {/* Med switch renders kun den første child <Route> som matcher location.</Route> */}
            <Route exact path="/" component={Welcome} /> {/* exact gør at det er den exacte path der skal skrives for at se side. */}
            <Route path="/all" component={All} /> {/* path bruges til at identificer den del af urlen som router skal matche. */}
            <Route path="/details" component={Details} />
            <Route component={NoMatch} />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;

const NoMatch = () => (
  <div>
    <h1>404 Wrong url!</h1>
  </div>
);