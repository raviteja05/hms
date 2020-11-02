import {combineReducers} from 'redux'
import { reducer as formReducer } from 'redux-form';
 export const appointmentsData=(state={},action)=>{
     if(action.type==='APPOINTMENTS_DATA'){
         var data=action.payload
         return {...state,data}
     }
     return state;

 }

 export const myAppointments=(state={},action)=>{
    if(action.type==='MY_APPOINTMENTS'){
        var data=action.payload
        return {...state,data}
    }
    return state;

}

 export const doctors=(state={},action)=>{
    if(action.type==='DOCTORS_LIST'){
        return {...state,...action.payload}
    }
    return state;

}
export const spinner=(state={},action)=>{
    if(action.type==='LOAD_SPINNER'){
        return {...state,spinner:action.payload}
    }
    
    return state;
}

 
export const testData=(state={},action)=>{
    
    
    return state;
}

const reducers=combineReducers({testData,formReducer,doctors,myAppointments,appointmentsData,spinner})

export default reducers;