import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import BookStore from './BookStore';
import { HashRouter } from 'react-router-dom';

ReactDOM.render(
    <HashRouter>
        <App bookStore={BookStore} />
    </HashRouter>
    , document.getElementById('root'));

registerServiceWorker();
