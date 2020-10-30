import axios from "axios";

export const getAppointments = (date) => {
    
  return (dispatch) => {
    return axios
      .get("/app/ws/get-appointments?date=" + date)
      .then((res) =>
        dispatch({
          type: "APPOINTMENTS_DATA",
          payload: res.data,
        })).catch((err) => console.log(err));
  };
};
