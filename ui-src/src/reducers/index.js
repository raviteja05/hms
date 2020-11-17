import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import { addAppointmentNotes } from "../actions";
export const appointmentsData = (state = {}, action) => {
  if (action.type === "APPOINTMENTS_DATA") {
    var data = action.payload;
    return { ...state, data };
  }
  return state;
};
export const viewAppointment = (state = {}, action) => {
  if ((action.type === "VIEW_APPOINTMENT")) {
    return { ...state, appointment:action.payload };
  }
  return state;
};

export const prescriptionsList = (state = {}, action) => {
   
    if ((action.type === "PRESCRIPTIONS")) {
    
      return { ...state, prescriptionsList:action.payload };
    }
    return state;
  };
export const myAppointments = (state = {}, action) => {
  if (action.type === "MY_APPOINTMENTS") {
    var data = action.payload;
    return { ...state, data };
  }
  return state;
};
export const appointmentsHistory = (state = {}, action) => {
  if (action.type === "APPOINTMENTS_HISTORY") {
    var data = action.payload;
    return { ...state, data };
  }
  return state;
};

export const index = (state = {}, action) => {
  if (action.type === "INDEX") {
    return { ...state, index: action.payload };
  }
  return state;
};

export const doctors = (state = {}, action) => {
  if (action.type === "DOCTORS_LIST") {
    return { ...state, ...action.payload };
  }
  return state;
};
export const spinner = (state = {}, action) => {
  if (action.type === "LOAD_SPINNER") {
    return { ...state, spinner: action.payload };
  }

  return state;
};

export const message = (state = {}, action) => {
  if(action.type==='MESSAGE'){
    return {...state,data:action.payload}
  }
  return state;
};
export const prescription=(state={},action)=>{
  if(action.type==="VIEW_PRESCRIPTION"){
    var data = action.payload;
    return {...state,data}
  }
  return state;
}

export const error=(state={},action)=>{
  if(action.type==="ERROR"){
    
    return {...state,data:action.payload}
  }
  return state;
}
export const appointmentNotes=(state={},action)=>{
  if(action.type==="APPOINTMENT_NOTES"){
    var data = action.payload;
    return {...state,data}
  }
  return state;
}

export const profile=(state={},action)=>{
  if(action.type==='PROFILE'){
    return {...state,data:action.payload}
  }
  return state
}

export const loadProfile=(state={},action)=>{
  if(action.type==='LOAD_PROFILE'){
    return {...state,data:action.payload}
  }
  return state
}

const reducers = combineReducers({
  form:formReducer,
  myAppointments,
  doctors,
  appointmentsData,
  spinner,
  index,
  viewAppointment,
  prescriptionsList,
  appointmentsHistory,
  prescription,
  appointmentNotes,
  profile,
  loadProfile,
  message,
  error
});

export default reducers;
