import React, { Component } from 'react';
import BookStore from './BookStore';

class AddBook extends Component {
    constructor(props) {
    super(props);
    this.state = {
        title: "",
        info: "",
      };
    }


    onChange = (evt) => {
        this.setState({ [evt.target.id]: evt.target.value });
    }

    onSubmit = (evt) => {
        evt.preventDefault();

        let book = {title: this.state.title, info: this.state.info};

        BookStore.addBook(book);
    }

    render() {

        var allBooks = this.props.data;
        //console.log(allBooks);

        //Show state
        var title = this.state.title;
        var info = this.state.info;
        console.log(title);
        console.log(info);

        return (
            <div>
                <h1>Add Book</h1>

                <form onSubmit={this.onSubmit} onChange={this.onChange} >
                    <div id="search">
                        <input placeholder="Title" id="title" />
                        <br />
                        <input placeholder="Info" id="info" />
                        <br />
                        <button>Save</button>
                    </div>

                </form>

            </div>
        );
    }
}

export default AddBook;
