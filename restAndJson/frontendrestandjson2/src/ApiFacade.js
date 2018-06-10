

const URL = 'http://localhost:8084/restAndJson/api/';


class ApiFacade {

  //Fetch the users from backend
  async fetchAllUsers() {
    const personFetch = 'persons';

    const result = await fetch(URL + personFetch).then(response => response.json());

    return result;
  }

  async fetchNumberOfPersons(number) {
    const numberOfPersons = "persons/lesspersons/";
    console.log(URL + numberOfPersons + number);
    if (number == 0) {
      console.log('0');
    } else {
      const result = await fetch(URL + numberOfPersons + number).then(response => response.json());
      return result;
    }
    
  }

}

const facade = new ApiFacade();

export default facade;