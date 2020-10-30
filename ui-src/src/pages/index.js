import React from 'react';
import {Provider} from 'react-redux'
import {createStore,applyMiddleware} from 'redux'
import thunk from 'redux-thunk';
import reducers from '../reducers';
import App from '../App';



export const renderComponents=(components)=>{

import('react-dom').then((ReactDOM)=>ReactDOM.render(
    <Provider store={createStore(reducers,applyMiddleware(thunk))}><App components={components}/></Provider>,
     document.getElementById('root')
   ));
}

