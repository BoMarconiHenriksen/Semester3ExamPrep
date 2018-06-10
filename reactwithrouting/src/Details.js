import React from 'react';

const Details = ({ match, data }) => {
    // find bruges til at søge  arrayet for matchende email adresse, så man kan finde brugeren.
    var user = data.find(u => u.email === match.params.userEmail);
    //console.log(user);
    var userData;

    if (user)
        userData = <div>
            <h3> {user.first} {user.last} </h3>
            <hr />
            <p>{user.gender}</p>
            <p>{user.street}</p>
            <p>{user.city}</p>
            <p>{user.state}</p>
            <h4>{user.email}</h4>  
            <img src={user.picture.large} />
            </div>;
            
    else
        userData = <h2> Sorry. User doesnt exist </h2>;

    return (
        <div style={{ display: 'flex' }}>
            <div style={{
                padding: '0 10% 0 10%',
                width: '80%',
                margin: 'auto',
                background: '#ffffff'
            }}>

                {userData}
            </div>
        </div>
    )
}

export default Details;