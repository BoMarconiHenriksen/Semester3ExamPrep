var lastId;

document.getElementById("svg2").addEventListener("click", mapInfo);

function mapInfo(e) {
    //Får det id, som der er trykket på.
    id = e.target.id;
    
    document.getElementById(id).style.fill = "red";
    
    //Hvis der er et lastId, så ændres farven til grå.
    if (lastId) {
        document.getElementById(lastId).style.fill = "#c0c0c0";
    }
    
    //Her laves urlen, som skal bruges til at finde landet.
    baseUrl = "http://restcountries.eu/rest/v1/alpha?codes=";
    url = baseUrl + id;
    
        fetch(url) //returner objekt som promise
            .then(response => {
                if (response.ok) {
                    return response.json(); 
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar
                //Laver rækken
                const rows = data.map(country => `<tr>
                                                <td>${country.name}</td>
                                                <td>${country.capital}</td>
                                                <td>${country.population}</td>
                                                <td>${country.borders}</td></tr>`).join("\n");
                //Her laves det som skal udskrives på htmlsiden                                
                const htmlTable = `<table class="table">
                    <thead>
                        <tr>
                            <th>Country</th>
                            <th>Capital</th>
                            <th>Population</th>
                            <th>Borders</th>
                        </tr>
                    </thead
                    <tbody>
                    ${rows}
                    </tbody>
                </table>
        `
                document.getElementById("countryInfo").innerHTML = htmlTable;
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });

    //Id sættes nu til lastId, så næste gang der trykkes på et land, så ændres farven tilbage til grå.
    lastId = id;
    
}


