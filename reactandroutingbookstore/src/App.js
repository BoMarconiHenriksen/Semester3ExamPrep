import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  HashRouter,
  Route,
  Link,
  NavLink,
  Switch,
} from 'react-router-dom'
import './App.css';
import Header from './Header';
import Home from './Home';
import Product from './Product';
import Company from './Company';
import AddBook from './AddBook';

class App extends Component {
  render() {

    var allBooks = this.props.bookStore.books;
    //console.log(allBooks);
   
    return (
      <div className="App">

        <HashRouter >
          <div>
            <Header />
            <Switch>
              <Route exact path="/" render={() => <Home />} />
              <Route path="/products" render={(props) => <Product data={allBooks} {...props} />} />
              <Route path="/company" render={() => <Company />} />
              <Route path="/add_book" render={(props) => <AddBook data={allBooks} {...props} />} />
              <Route component={NoMatch} />
            </Switch>
          </div>
        </HashRouter>


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
