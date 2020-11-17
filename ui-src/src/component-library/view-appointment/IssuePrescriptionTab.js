import React from "react";
import { Field, reduxForm } from "redux-form";
import { indexIncrement,getPrescriptionsList } from "../../actions";
import {connect} from 'react-redux'
import Axios from "axios";

class IssuePrescriptionTab extends React.Component {
  componentDidMount() {
    this.props.indexIncrement(0);
  }
  increment(index) {
    this.props.formData.values.medicines.push({ name: "", dosage: "" });
    this.props.indexIncrement(index + 1);
  }

  submit(appointment) {
    var prescription = {
      customer: { email: appointment.email },
      doctor: { email: window.data.auth.user },
      medicines: this.props.formData.values.medicines,
    };
    Axios.post("/doc/ws/save-prescription", prescription);
  }
  inputText(props) {
    return (
      <input
        className="form-control"
        name={props.inputName}
        type="text"
        onChange={props.input.onChange}
        style={props.input.style}
        name={props.inputName}
        placeholder={props.placeholder}
      />
    );
  }
  render() {
    var formData = this.props.formData;
    var appointment = this.props.customer;
    return (
      <React.Fragment>
        <form
          style={{
            padding: "40px",
            "margin-left": "0px",
            "margin-right": "0px",
            "max-width": "100%",
          }}
        >
        
          {formData &&
            formData.values &&
            formData.values.medicines &&
            formData.values.medicines.map((el) => (
              <div class="form-row">
                <div
                  class="col text-left"
                  style={{ width: "300px", "max-width": "25%" }}
                >
                  <div class="form-group" style={{ width: "250px" }}>
                    <Field
                      type="text"
                      name={`medicines[${this.props.index}].name`}
                      inputName="name"
                      style={{ "max-width": "47%", "padding-top": "12px" }}
                      placeholder="Medicine Name"
                      component={this.inputText}
                    />
                  </div>
                </div>
                <div
                  class="col text-left"
                  style={{ width: "300px", "max-width": "20%" }}
                >
                  <div class="form-group" style={{ width: "150px" }}>
                    <Field
                      type="text"
                      name={`medicines[${this.props.index}].dosage`}
                      inputName="dosage"
                      style={{ "max-width": "47%", "padding-top": "12px" }}
                      placeholder="Dosage"
                      component={this.inputText}
                    />
                  </div>
                </div>
              </div>
            ))}
          <div class="form-row">
            <div
              class="col text-left"
              style={{
                width: "358px",
                "max-width": "25%",
                "padding-top": "27px",
              }}
            >
              <div class="form-group" style={{ width: "345px" }}>
                <button
                  class="btn btn-primary"
                  type="button"
                  style={{ "background-color": "#3300ff" }}
                  onClick={(ev) => this.increment(this.props.index)}
                >
                  Add
                </button>
              </div>
            </div>
            <div
              class="col text-left"
              style={{
                width: "358px",
                "max-width": "25%",
                "padding-top": "27px",
              }}
            >
              <div class="form-group" style={{ width: "345px" }}>
                <button
                  class="btn btn-primary"
                  type="button"
                  style={{
                    "background-color": "#268234",
                    "padding-left": "11px",
                    "padding-top": "11px",
                    "margin-top": "0px",
                  }}
                  onClick={(ev) => {
                    this.submit(appointment);
                  }}
                >
                  Submit
                </button>
              </div>
            </div>
            <div
              class="col text-left"
              style={{ width: "358px", "max-width": "25%" }}
            ></div>
          </div>
        </form>
      </React.Fragment>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    data: state,
    index: state.index.index,
    formData: state.form.PrescriptionForm
  };
};

export default reduxForm({
  form: "PrescriptionForm",
  destroyOnUnmount: false,
  initialValues: { date: new Date(), medicines: [{ name: "", dosage: "" }] },

  enableReinitialize: true,
  forceUnregisterOnUnmount: true, // a unique identifier for this form
})(
  connect(mapStateToProps, { indexIncrement, getPrescriptionsList })(
    IssuePrescriptionTab
  )
);
