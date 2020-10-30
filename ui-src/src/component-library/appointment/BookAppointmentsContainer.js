import React from "react";
import { connect } from "react-redux";
import { getAppointments } from "../../actions";
import {transform, formatDate } from "../../utils/utils"

class BookAppointmentsContainer extends React.Component {
  
  componentDidMount() {
    this.props.getAppointments(formatDate(new Date()));
  }
  render() {
    const data= transform(this.props.data.appointmentsData)
    return (
    
      <React.Fragment>
        
        <div class="col" style={{ "max-width": "70%" }}>
          {data.length>0 &&
            data.map((el) => {
              return (<div class="row">
                
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
                              <button
                                class="btn btn-primary"
                                type="button"
                                style={{
                                  "margin-left": "15%",
                                  "padding-left": "12px",
                                }}
                              >
                                Book
                              </button>
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>)
            })}
        </div>
      </React.Fragment>
    );
  }
}

const mapStateToProps = (state) => {
  return { data: state };
};
export default connect(mapStateToProps, { getAppointments })(
  BookAppointmentsContainer
);
