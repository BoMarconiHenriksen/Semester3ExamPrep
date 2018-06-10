//Store the fetch data in a global variable.
var dataFetched = [];

//Opg 2
document.getElementById("btnsend").addEventListener("click", showUsers);
document.getElementById("btnsql").addEventListener("click", getSql);

function showUsers() {
    const URL = "http://uinames.com/api/?amount=25&region=denmark&gender=female";

    fetch(URL) //returner objekt som promise
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                //throw new Error("Noget gik galt med fetch metoden! " + response.status.text);
            })
            .then(data => { //nu er data klar
                //Gemmer fetched data i en global variabel.
                dataFetched = data;

                //Laver rækken
                const rows = data.map(user => `<tr>
                                                <td>${user.name}</td>
                                                <td>${user.surname}</td>
                                                <td>${user.gender}</td></tr>`).join("\n");

                document.getElementById("tblbody").innerHTML = rows;
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });
}

function getSql() {
    
    const sqlStatements = dataFetched.map(sqlStatement => `
        INSERT INTO names (name, surname, gender) VALUES ("${sqlStatement.name}", "${sqlStatement.surname}", "${sqlStatement.gender}");
        `).join("\n");

    document.getElementById("sql").value = sqlStatements;


}


