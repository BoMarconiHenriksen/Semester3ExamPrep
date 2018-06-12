import React from 'react';

const Details = (props) => {
    let id = props.match.params.id;
    let a = props.allBooks;
    console.log(a);

    let book = props.allBooks.find((book) => book.id === Number(id));
    console.log(book);
    return(
        <div>

            <b>Book details for selected book will go here.</b>
            <br />
            <p>ID: {book.id}</p>
            <p>Info: {book.info}</p>
        </div>
    )
}

export default Details;