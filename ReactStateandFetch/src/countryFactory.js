const URLCOUNTRIES = "http://localhost:3333/countries";
const URLLabels = "http://localhost:3333/labels";

class CountryFactory {

  constructor() {
    this.labels = [];
    this.countries = [];
  }

  getLabels = async () => {
    let result = fetch(URLLabels).then(handleHttpErrors);
    this.labels = result;
    return this.labels;
  }

  getCountries = async () => {
    let result = fetch(URLCOUNTRIES).then(handleHttpErrors);
    this.countries = result;
    return this.countries;
  }

  /* async getLabels() {
   
   const result = await fetch(URLLabels).then(response => response.json());
   return result;
 }

 async getCountries() {
   
   const result = await fetch(URLCOUNTRIES).then(response => response.json());
  
   return result;
 } */

}

// Simple way to handle HTTP-errors which otherwise does not throw an exception with the fetch-API
function handleHttpErrors(res) {
  if (!res.ok) {
    throw Error(res.statusText);
  }
  console.log(res);
  return res.json();
}

export default new CountryFactory();