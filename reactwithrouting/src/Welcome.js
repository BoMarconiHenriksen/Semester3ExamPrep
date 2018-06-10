import React from 'react';

// Stateless component er letvægt at render og fb har lovet bedre performence for stateless komponenter i fremtiden.
//Så hver gang du ikke bruger state, refs og lifecycle methods så brug stateless components.

const Welcome = () => (
    <div>
        <h1>Welcome to our friends site</h1>
    </div>
);

export default Welcome;
