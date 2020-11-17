import React from "react";
import { Field, reduxForm } from "redux-form";
import { connect } from "react-redux";
import {MessageCard} from '../messagecards/bookingsuccess'
import {message} from '../../actions'
import axios from "axios";

class EditProfileForm extends React.Component {
  submit(data) {
    var role = window.data.auth.role;
    
    if (role === "DOCTOR") {
      axios.post("/doc/ws/update-profile", data).then((res)=>{if(res.status===200){this.props.message("Successfully updated profile")}});
    } else if (role === "CUSTOMER") {
      axios.post("/app/ws/update-profile", data);
    }
    else if (role === "EMPLOYEE") {
      axios.post("/admin/ws/update-profile", data);
    }
  }
  textInput(props) {
   
    return (
      <input disabled={props.disabled} type={props.type} {...props.input} />
    );
  }
  textArea(props) {
    
    return <textarea {...props.input} />;
  }

  render() {
    var role = window.data.auth.role;
    return (
      <form>
        {this.props.displayMessage&&<div> <MessageCard message={this.props.displayMessage}/></div>}
        <table class="table table-bordered">
          <thead>
            <tr>
              <th colspan="4">Edit Profile</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>First Name</td>
              <td>
                <Field
                  type="text"
                  name="firstName"
                  component={this.textInput}
                />
              </td>
              <td>Last Name</td>
              <td>
                <Field type="text" name="lastName" component={this.textInput} />
              </td>
            </tr>
            <tr>
              <td>Email</td>
              <td>
                <Field
                  type="email"
                  name="email"
                  disabled
                  component={this.textInput}
                />
              </td>
              <td>Phone No</td>
              <td>
                <Field type="text" name="phoneNo" component={this.textInput} />
              </td>
            </tr>
            {role == "CUSTOMER" && (
              <tr>
                <td>Age</td>
                <td>
                  <Field type="number" name="age" component={this.textInput} />
                </td>
                <td>Blood Group</td>
                <td>
                  <Field
                    type="text"
                    name="bloodGroup"
                    component={this.textInput}
                  />
                </td>
              </tr>
            )}
            {/* <tr>
              <td>Change Password</td>
              <td>
                <input type="password" />
              </td>
              <td>Confirm Password</td>
              <td>
                <input type="password" />
              </td>
            </tr>  */}
            {role == "DOCTOR" && (
              <tr>
                <td>Designation</td>
                <td>
                  <Field
                    type="text"
                    name="designation"
                    component={this.textInput}
                  />
                </td>
                <td>Specialization</td>
                <td>
                  <Field
                    type="text"
                    name="specialization"
                    component={this.textInput}
                  />
                </td>
              </tr>
            )}
            {role == "CUSTOMER" && (
              <tr>
                <td>Height</td>
                <td>
                  <Field
                    type="number"
                    name="height"
                    component={this.textInput}
                  />
                </td>
                <td>Weight</td>
                <td>
                  <Field
                    type="number"
                    name="weight"
                    component={this.textInput}
                  />
                </td>
              </tr>
            )}
            <tr>
              <td>Address</td>
              <td colspan="3">
                <Field
                  type="textarea"
                  name="address"
                  component={this.textArea}
                />
              </td>
            </tr>
            {role == "CUSTOMER" && (
              <tr>
                <td>Known Allergies</td>
                <td colspan="3">
                  <textarea cols="50"></textarea>
                </td>
              </tr>
            )}
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td>
                <button
                  class="btn btn-primary"
                  type="button"
                  onClick={(ev) => this.submit(this.props.formData.values)}
                >
                  Save
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    );
  }
}

export default reduxForm({
  form: "EditProfile",
  enableReinitialize: true, // a unique identifier for this form
})(
  connect((state) => ({
    formData: state.form.EditProfile,
    displayMessage:state.message.data
  }),{message})(EditProfileForm)
);
