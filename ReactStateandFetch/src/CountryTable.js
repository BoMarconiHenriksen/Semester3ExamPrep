import React, { Component } from "react";
import countryFactory from './countryFactory';

class CountryTable extends Component {
  constructor(props){
    super(props);
    this.state = {
      lables: [],
      countries: [],
    }
  }

  /* async componentDidMount() {
    let resultFromFetchLabels = await countryFactory.getLabels();
    this.setState({ lables: resultFromFetchLabels });

    let fetchCountries = await countryFactory.getCountries();
    this.setState({ countries: fetchCountries });
  } */

  render() {

    //For the fetch via props.
    const { labels } = this.props;

    const tableHead = labels.map((label) => (
      <th>{label}</th>
    ));

    const { countries } = this.props;



    var tableRow = countries.map(country => {
      return (
        <tr key={country.name}><td>{country.name}</td><td>{country.capital}</td><td>{country.region}</td><td>{country.population}</td><td>{country.area}</td><td>{showFirstElement(country.timezones)}</td><td>{showFirstElement(country.borders)}</td><td>{showFirstElement(country.topLevelDomain)}</td><td>{showFirstElement(country.currencies)}</td><td>{showFirstElement(country.languages)}</td></tr>
      )
    })

    //For the fetch.
    /* const labels = this.state.lables;

    const tableHead = labels.map((label) => (
      <th>{label}</th>
    ));

    const tableRow = this.state.countries.map((country) => (
      <tr key={country.name}><td>{country.name}</td><td>{country.capital}</td><td>{country.region}</td><td>{country.population}</td><td>{country.area}</td><td>{showFirstElement(country.timezones)}</td><td>{showFirstElement(country.borders)}</td><td>{showFirstElement(country.topLevelDomain)}</td><td>{showFirstElement(country.currencies)}</td><td>{showFirstElement(country.languages)}</td></tr>
    )); */

    return (
      <table className="table">
        <thead>
          <tr>{tableHead}</tr>
        </thead>
        
        <tbody>
         <tr>{tableRow}</tr>
        </tbody>
      </table>
    );
  }
}

export default CountryTable;

function showFirstElement(array) {
  let lengtOfArray = array.length - 1;
  if (lengtOfArray !== 0) {
    return array[0] + " (+" + lengtOfArray + ")";
  } else {
    return array[0];
  }
}