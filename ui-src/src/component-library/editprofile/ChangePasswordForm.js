import React from "react";
import ReactDOM from "react-dom";
import { Field, reduxForm } from "redux-form";
import { connect } from "react-redux";
import Axios from "axios";

class ChangePasswordForm extends React.Component {
  textInput(props) {
    return (
      <input disabled={props.disabled} type={props.type} {...props.input} />
    );
  }
  submit(ev,data){
    console.log(data)
    Axios.request({
      method: 'POST',
      headers:{
        'Content-Type': 'application/json'
      },
      url:'/ws/update-password',data:data})

    this.close()

  }

  close() {
    document.getElementById("changepassword-modal").style = "display:none";
    document.getElementById("changepassword-modal").className = "modal fade";
  }
  render() {
    return ReactDOM.createPortal(
      <div
        role="dialog"
        tabindex="-1"
        class="modal fade"
        id="changepassword-modal"
        style={{ display: "none" }}
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">Change Password</h4>
            </div>
            <div class="modal-body" style={{ height: "215px" }}>
              <form>
              <table class="table">
              
                <tr>
               <td> 
                  <label>Password</label></td>
                 <td> <Field
                    type="password"
                    name="password"
                    component={this.textInput}
                  /></td>
                
                </tr>
                
                
                  <tr>
                    <td>
                  <label>Confirm Password</label></td>
                  <td>
                  <Field
                    type="password"
                    name="rpassword"
                    component={this.textInput}
                  /></td>
                  </tr>
                
               <tr><td>
                      <button
                        class="btn btn-secondary btn-block"
                        type="button"
                        onClick={(ev) => this.close()}
                        style={{ width: "175px" }}
                      >
                        Close
                      </button></td>
                   <td>
                      <button
                        class="btn btn-primary btn-block"
                        type="button"
                        onClick={(ev)=>this.submit(ev,this.props.data.values.password)}
                        style={{ width: "175px" }}
                      >
                        Submit
                      </button>
                    
                      </td></tr>
                </table>
              </form>
            </div>
          </div>
        </div>
      </div>,
      document.getElementById("popup")
    );
  }
}
const mapStateToProps = (state) => {
  return { data: state.form.ChangePassword };
};
export default reduxForm({ form: "ChangePassword" })(
  connect(mapStateToProps)(ChangePasswordForm)
);
