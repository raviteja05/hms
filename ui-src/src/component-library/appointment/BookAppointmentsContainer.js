import React from "react";
import { connect } from "react-redux";
import { getAppointments,spinner } from "../../actions";
import { transform, formatDate } from "../../utils/utils";
import Axios from "axios";

class BookAppointmentsContainer extends React.Component {
  componentDidMount() {
    this.props.getAppointments(formatDate(new Date()),this.props.doctor);
    this.props.spinner(false);
  }
  click(user, doctor, date,time) {
    
    this.props.spinner(true);
    Axios.post(
      "/app/ws/book-appointment?doctorId=" +
        doctor +
        "&customerId=" +
        user +
        "&date=" +
        formatDate(new Date(date))+" "+time
    ).then(res=>{window.location.replace("/app/booking-success")});
    
  }
  
  render() {
    const data = this.props.data.appointmentsData.data?transform(this.props.data.appointmentsData.data):[];
    const user = window.data.auth.user;
    const urlParams = new URLSearchParams(window.location.search);
    const doctor = urlParams.get("doctor");
    
    return (
      <React.Fragment>

      <div class="col" style={{ "max-width": "70%" }}>
        {this.props.data.spinner&&this.props.data.spinner.spinner&&<div class="spinner-border text-primary" style={{"width": "75px","height": "75px","margin": "0px","margin-top": "70px","margin-left": "150px"}} role="status">
  <span class="sr-only">Please wait...</span>
</div>}
      {this.props.data.spinner&&!this.props.data.spinner.spinner&&
          data.length > 0 &&
            data.map((el) => {
              return (
                <div class="row">
                  {el.map((el) => (
                    <div
                      class="col"
                      style={{ "max-width": "25%", height: "300px" }}
                    >
                      <div
                        class="card border-white"
                        style={{ "max-width": "25%" }}
                      >
                        <div
                          class="card-body border rounded shadow-none"
                          style={{
                            "padding-top": "20px",
                            "margin-bottom": "20px",
                            "padding-bottom": "20px",
                            width: "175px",
                            height: "270px",
                          }}
                        >
                          <div class="row">
                            <div
                              class="col offset-0"
                              style={{
                                "max-width": "100%",
                                padding: "30px",
                                "padding-top": "5px",
                                "padding-left": "0px",
                              }}
                            >
                              <i
                                class="fa fa-calendar-times-o"
                                style={{
                                  "font-size": "72px",
                                  "padding-left": "35px",
                                  color: "rgb(59,153,224)",
                                }}
                              ></i>
                              <h2
                                class="text-center text-muted mb-2"
                                style={{
                                  "padding-top": "15px",
                                  "font-size": "12px",
                                  color: "rgb(59,153,224)",
                                  "max-width": "100%",
                                }}
                              >
                                <strong>{el.appointmentTime}</strong>
                              </h2>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col">
                              <p style={{ "font-size": "16px" }}>
                                
                                  {el.available&&<button
                                  class="btn btn-primary"
                                  type="button"
                                  style={{
                                    "margin-left": "15%",
                                    "padding-left": "12px",
                                  }}
                                  onClick={(ev) =>
                                    this.click(
                                      user,
                                      doctor,
                                      el.date,
                                      el.appointmentTime
                                    )
                                  }
                                >
                                  Book
                                </button>}
                                {!el.available&&<button
                                  class="btn btn-secondary"
                                  type="button"
                                  style={{
                                    "margin-left": "15%",
                                    "padding-left": "12px",
                                  }}
                                  disabled
                                >
                                  Book
                                </button>}
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  ))}
                </div>
              );
            })}
        </div>
      </React.Fragment>
    );
  }
}

const mapStateToProps = (state) => {
  const urlParams = new URLSearchParams(window.location.search);
    const doctor = urlParams.get("doctor");
  return { data: state,doctor:doctor };
};
export default connect(mapStateToProps, { getAppointments,spinner })(
  BookAppointmentsContainer
);
