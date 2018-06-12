import React, { Component } from 'react';
import Details from './Details';
import { Route, Link } from 'react-router-dom'

class Product extends Component {
    constructor(props) {
        super(props);

        this.state = {

        };
    }

    render() {

        const allBooks = this.props.data;

        const unOrderedList = allBooks.map(book => {
            return (
                <li key={book.id}> {book.title}  <Link to={`/products/${book.id}`}>details</Link> </li>
            )
        })

        return (
            <div>
                <h1>Product</h1>
                {unOrderedList}
                <br />

                <Route path={`/products/:id`} render={(props) => {
                    return (<Details {...props} allBooks={this.props.data} />)
                }} />
                
            </div>
        );
    }
}

//Hvis du passer med render til en funktion
/* const Product = ({ data }) => {

    const allBooks = data;

    const unOrderedList = allBooks.map(book => {
        return (
            <ul key={book.id}> {book.title} </ul>
        )
    })

    return (
        <div>
            <h1>Product</h1>
            {unOrderedList}

        </div>
    );
} */


export default Product;
