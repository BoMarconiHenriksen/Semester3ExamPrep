import React from 'react';
import { Link, Route, NavLink } from 'react-router-dom';
import Details from './Details';
import data from "./data/Data.json";

// https://www.sitepoint.com/react-router-v4-complete-guide/

const All = ({ match }) => {
     
        var usersData = data.users;
        console.log(usersData);
        console.log(match.url);
   var linkList = usersData.map( (user) => {
     return(
       <li key={user.email}>
        <Link to={`${match.url}/${user.email}`}> {/* match url returns en string med den matchende url. Bruges ved nested <Link>s.  */}
           {user.first} {user.last}
         </Link>
       </li>
       )
          
     });
  
   return(
     <div>
      <div style={{ display: 'block',  justifyContent: "space-between" }}>
       <div style={{
         float:'left',
         padding: '10px',
         width: '30%',
         background: '#f0f0f0',
         marginLeft:'auto' }}>
 
         <h3> Users</h3>
         <ul  style={{ listStyleType: 'none', padding: 0, fontSize:'15px' }}> {linkList} </ul>
       </div>
     </div>
     {/* Pass usersdata og props videre til Details komponenten. */}
     <Route path={`${match.url}/:userEmail`} render={ (props) => <Details data= {usersData} {...props} />}/>
     <Route exact path={match.url} 
       render={() => (
         <div style={{ textAlign:'left'}}>Please select a user.</div>
     )}/>
 
     </div>
 
   )
 }
 
export default All;