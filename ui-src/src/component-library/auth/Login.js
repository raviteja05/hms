import React from "react";
import { Field, reduxForm } from "redux-form";
import { connect } from "react-redux";
import qs from "qs";
import { error } from "../../actions";
import { emailInput, passwordInput, SubmitButton } from "./FormComponents";
import axios from "axios";

class LoginComponent extends React.Component {
  submit(ev, props) {
    var error = {};

    if (!props.values) {
      ev.preventDefault();
      ev.stopPropagation();
      error["email"] = "Please enter a valid email";
      error["password"] = "Password should not be empty";
    }
    if (props.values && !props.values.email) {
      ev.preventDefault();
      ev.stopPropagation();

      error["email"] = "Please enter a valid email";
    }
    if (props.values && !props.values.password) {
      ev.preventDefault();
      ev.stopPropagation();
      error["password"] = "Password should not be empty";
    }

    this.props.error(error);
  }
  render() {
    return (
      <div
        class="login-clean"
        style={{ "background-color": "rgb(238,238,238)" }}
      >
        <form
          action="/perform_login"
          onSubmit={(ev) => this.submit(ev, this.props.formData)}
          method="post"
        >
          <h2 class="sr-only">Login Form</h2>
          <div class="form-group">
            <Field
              type="email"
              name="email"
              inputName="username"
              placeholder="Email"
              component={emailInput}
            />
            {this.props.err && this.props.err.email && (
              <p className="text-danger">{this.props.err.email}</p>
            )}
          </div>
          <div class="form-group">
            <Field
              type="password"
              name="password"
              inputName="password"
              placeholder="Password"
              component={passwordInput}
            />
            {this.props.err && this.props.err.password && (
              <p className="text-danger">{this.props.err.password}</p>
            )}
          </div>
          <div class="form-group">
            <SubmitButton
              className="btn btn-primary btn-block"
              type="submit"
              style={{ "background-color": "#1e76c6" }}
              value="Login"
            />
          </div>
          <a class="forgot" href="/forgot">
            Forgot your email or password?
          </a>
          <a class="forgot" href="/signup">
            Not a member? Sign Up
          </a>
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return { formData: state.form.LoginForm, err: state.error.data };
};

export default reduxForm({
  form: "LoginForm",
  destroyOnUnmount: false,
  forceUnregisterOnUnmount: true, // a unique identifier for this form
})(connect(mapStateToProps, { error })(LoginComponent));
