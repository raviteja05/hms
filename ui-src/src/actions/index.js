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

export const spinner = (flag) => {
  return { type: "LOAD_SPINNER", payload: flag };
};
