import axios from "axios";

export const getAppointments = (date,doc) => {
    
  return (dispatch) => {
    return axios
      .get("/app/ws/get-appointments?date=" + date+"&doctor="+doc)
      .then((res) =>
        dispatch({
          type: "APPOINTMENTS_DATA",
          payload: res.data,
        })).catch((err) => console.log(err));
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
        })).catch((err) => console.log(err));
  };
};