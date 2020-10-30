import {combineReducers} from 'redux'
import { reducer as formReducer } from 'redux-form';
 export const appointmentsData=(state={},action)=>{
     if(action.type==='APPOINTMENTS_DATA'){
         return {...state,...action.payload}
     }
     return state;

 }
 
export const testData=(state={},action)=>{
    
    
    return state;
}

const reducers=combineReducers({testData,formReducer,appointmentsData})

export default reducers;