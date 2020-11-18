import React from "react";
import { Field, reduxForm } from "redux-form";
import { connect } from "react-redux";
import { error } from "../../actions";
import {  SubmitButton } from "./FormComponents";
import Axios from "axios";

class ForgotPasswordComponent extends React.Component {
  submit(ev, props) {
    var error = {};

    if (!props.values) {
      ev.preventDefault();
      ev.stopPropagation();
      error["email"] = "Please enter a valid email";
      error["password"] = "Password should not be empty";
    }
    else if (props.values && !props.values.email) {
      ev.preventDefault();
      ev.stopPropagation();

      error["email"] = "Please enter a valid email";
    }
    
    this.props.error(error);
  }

  textInput(props) {
    return (
      <input disabled={props.disabled} placeholder={props.placeholder} type={props.type} {...props.input} />
    );
  }
  render() {
    return (
      <div
        class="login-clean"
        style={{ "background-color": "rgb(238,238,238)" }}
      >
          
        <form
         action="/ws/reset-password"
         onSubmit={(ev) => this.submit(ev, this.props.formData)}
          
        >
          
          <div class="form-group">
          <p> If the provided email is correct we would send your new password to your registered mail</p>
            <Field
              type="email"
              name="email"
              placeholder="Email"
              component={this.textInput}
            />
            {this.props.err && this.props.err.email && (
              <p className="text-danger">{this.props.err.email}</p>
            )}
          </div>
          
          <div class="form-group">
            <button
              className="btn btn-primary btn-block"
              type="submit"
              style={{ "background-color": "#1e76c6" }}
              
             
            >Submit</button>
          </div>
          
          
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return { formData: state.form.ForgotPassword, err: state.error.data };
};

export default reduxForm({
  form: "ForgotPassword",
  destroyOnUnmount: false,
  forceUnregisterOnUnmount: true, // a unique identifier for this form
})(connect(mapStateToProps, { error })(ForgotPasswordComponent));
