import axios from "axios";

export const myAppointments = (user, role) => {
  var endPoint = "";
  if (role === "CUSTOMER") {
    endPoint = "/app/ws/my-appointments?custId=";
  } else if (role === "DOCTOR") {
    endPoint = "/doc/ws/my-appointments?docId=";
  }
  return (dispatch) => {
    return axios
      .post(endPoint + user)
      .then((res) => dispatch({ type: "MY_APPOINTMENTS", payload: res.data }));
  };
};

export const prescription=(id,role)=>{
  var endPoint = "";
  if (role === "CUSTOMER") {
    endPoint = "/app/ws/get-prescription?prescriptionId=";
  } else if (role === "DOCTOR") {
    endPoint = "/doc/ws/get-prescription?prescriptionId=";
  }
  return (dispatch) => {
    return axios
      .post(endPoint + id)
      .then((res) => dispatch({ type: "VIEW_PRESCRIPTION", payload: res.data }));
  };
}
export const appointmentsHistory = (user) => {      
  return (dispatch) => {
    return axios
      .post("/doc/ws/get-appointmentshistory?custId=" + user)
      .then((res) => dispatch({ type: "APPOINTMENTS_HISTORY", payload: res.data }));
  };
};

export const viewAppointment = (appId) => {
  return (dispatch) => {
    return axios
      .post("/doc/ws/get-customerdetails?appId=" + appId)
      .then((res) => dispatch({ type: "VIEW_APPOINTMENT", payload: res.data }));
  };
};
export const indexIncrement = (index) => {
  return { type: "INDEX", payload: index };
};

export const getPrescriptionsList = (user, role) => {
  var endPoint = "";
  if (role === "CUSTOMER") {
    endPoint = "/app/ws/get-prescriptions?custId=";
  } else if (role === "DOCTOR") {
    endPoint = "/doc/ws/get-prescriptions?custId=";
  }
  return (dispatch) => {
    return axios
      .post(endPoint + user)
      .then((res) => dispatch({ type: "PRESCRIPTIONS", payload: res.data }))
      .catch((err) => console.log(err));
  };
};
export const getAppointments = (date, doc) => {
  return (dispatch) => {
    return axios
      .get("/app/ws/get-appointments?date=" + date + "&doctor=" + doc)
      .then((res) =>
        dispatch({
          type: "APPOINTMENTS_DATA",
          payload: res.data,
        })
      )
      .catch((err) => console.log(err));
  };
};

export const getDoctors = () => {
  return (dispatch) => {
    return axios
      .get("/app/ws/list-doctors")
      .then((res) =>
        dispatch({
          type: "DOCTORS_LIST",
          payload: res.data,
        })
      )
      .catch((err) => console.log(err));
  };
};

export const addAppointmentNotes=(appointmentViewData)=>{
  
  
  return (dispatch) => {
    return axios
      .post("/doc/ws/update-appointmentnotes",appointmentViewData)
      .then((res) =>
        dispatch({
          type: "APPOINTMENT_NOTES",
          payload: res.data,
        })
      )
      .catch((err) => console.log(err));
  };
}

export const spinner = (flag) => {
  return { type: "LOAD_SPINNER", payload: flag };
};

export const error=(error)=>{
  return {type:"ERROR",payload:error} 
}

export const profileData=(role)=>{
  var endPoint = "";
  if (role === "CUSTOMER") {
    endPoint = "/app/ws/get-pat-profile";
  } else if (role === "DOCTOR") {
    endPoint = "/doc/ws/get-doc-profile";
  }
  return (dispatch)=>{
    return axios.post(endPoint).then((res)=>{
      dispatch({type:"PROFILE",payload:res.data})
    }).catch((err)=>console.log(err))
  }
}

export const message=(data)=>{
  return {type:'MESSAGE',payload:data}
}


export const loadProfile=(data)=>{
  return {type:"LOAD_PROFILE",payload:data}
}