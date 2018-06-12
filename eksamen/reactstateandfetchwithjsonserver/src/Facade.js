// https://github.com/BoMarconiHenriksen/Semester3ExamPrep/tree/master/ReactStateandFetch/src
const URLCOUNTRIES = "http://localhost:3333/countries";
const URLLabels = "http://localhost:3333/labels";

class Facade {

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

}

function handleHttpErrors(res) {
    if (!res.ok) {
      throw Error(res.statusText);
    }
    console.log(res);
    return res.json();
  }
  
  export default new CountryFactory();