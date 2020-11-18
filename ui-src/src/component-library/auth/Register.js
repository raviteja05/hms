import React from 'react'
import {Field,reduxForm} from 'redux-form'
import {connect} from 'react-redux'
import { error } from "../../actions";
import qs from 'qs'
import {textInput,emailInput,passwordInput,textAreaInput,SubmitButton} from './FormComponents';
import axios from 'axios'


class RegisterFormComponent extends React.Component{
    submit(ev,props){
        var error = {};

    if (!props.values) {
      ev.preventDefault();
      ev.stopPropagation();
      error["email"] = "Please enter a valid email";
      error["password"] = "Password should not be empty";
      error["firstName"] = "Please enter first name";
      error["lastName"] = "Please enter last name";
      error["phoneNo"] = "Please enter a phone no";
      error["address"] = "Please enter address";
    }
    if (props.values && !props.values.email) {
      ev.preventDefault();
      ev.stopPropagation();

      error["email"] = "Please enter a valid email";
    }
    if (props.values && !props.values.firstName) {
        ev.preventDefault();
        ev.stopPropagation();
  
        error["firstName"] = "Please enter first name";
      }
      if (props.values && !props.values.lastName) {
        ev.preventDefault();
        ev.stopPropagation();
  
        error["lastName"] = "Please enter last name";
      }
    if (props.values && !props.values.password) {
      ev.preventDefault();
      ev.stopPropagation();
      error["password"] = "Password should not be empty";
    }
    if (props.values && !props.values.address) {
        ev.preventDefault();
        ev.stopPropagation();
        error["address"] = "Address should not be empty";
      }
      if (props.values && !props.values.phoneNo) {
        ev.preventDefault();
        ev.stopPropagation();
        error["phoneNo"] = "Phone number should not be empty";
      }
      if (props.values && !new RegExp("[0-9]{10,11}").test(props.values.phoneNo)) {
        ev.preventDefault();
        ev.stopPropagation();
        error["phoneNoValid"] = "Please enter a valid phone number";
      }
    if (props.values && props.values.password!=props.values.rpassword) {
        ev.preventDefault();
        ev.stopPropagation();
        error["rpassword"] = "Confirm password should match with the password entered";
      }

    this.props.error(error);
        
    }
    

    render(){
        var isAdmin=window.data.auth.role==="ADMIN"
        var actionUrl=isAdmin?"/admin/signup":"signup"
        
        return (
            <div class="login-clean"  style={{"background-color": "rgb(238,238,238)"}}>
        <form method="post" action={actionUrl} onSubmit={(ev)=>this.submit(ev,this.props.formData)} style={{"max-width": "629px"}}>
            <h2 class="text-center" style={{"padding-bottom": "15px"}}>Sign Up</h2>
            <div class="form-group">
                <div class="form-row" style={{"width": "549px"}}>
                    <div class="col-xl-6"><Field type="text" name="firstName" inputName="firstName" placeholder="First Name" style={{"width": "260px"}} component={textInput} />
                    {this.props.err && this.props.err.firstName && (
              <p className="text-danger">{this.props.err.firstName}</p>
            )}</div>
                    <div class="col-xl-6"><Field type="text" name="lastName" inputName="lastName" placeholder="Last Name" style={{"width": "260px"}} component={textInput} />
                    {this.props.err && this.props.err.lastName && (
              <p className="text-danger">{this.props.err.lastName}</p>)}
                    </div>
                    
                </div>
            </div>
            <div class="form-group"><Field type="email" name="email" inputName="email" placeholder="Email" component={emailInput} /></div>
            
            {this.props.err && this.props.err.email && (
              <p className="text-danger">{this.props.err.email}</p>
            )}
            <div class="form-group"><Field type="password" name="password" inputName="password" placeholder="Password" component={passwordInput} /></div>
            {this.props.err && this.props.err.password && (
              <p className="text-danger">{this.props.err.password}</p>
            )}
            <div class="form-group"><Field type="password" name="rpassword" inputName="rpassword" placeholder="Confirm Password" component={passwordInput} /></div>
            {this.props.err && this.props.err.rpassword && (
              <p className="text-danger">{this.props.err.rpassword}</p>
            )}
            {isAdmin&&<div class="form-group"><select class="form-control" name="userType"><option value="DOCTOR" selected="">DOCTOR</option><option value="CUSTOMER">CUSTOMER</option><option value="ADMIN">ADMIN</option></select></div>}
            <div class="form-group"><Field type="text" name="phoneNo" inputName="phoneNo" placeholder="Phone Number"  component={textInput} /></div>            
            {this.props.err && this.props.err.phoneNo && (
              <p className="text-danger">{this.props.err.phoneNo}</p>
            )}
            {this.props.err && this.props.err.phoneNoValid && (
              <p className="text-danger">{this.props.err.phoneNoValid}</p>
            )}
            
                        
            <div class="form-group"><Field name="address" inputName="address" placeholder="Address" component={textAreaInput} /></div>
            {this.props.err && this.props.err.address && (
              <p className="text-danger">{this.props.err.address}</p>
            )}
            <div class="form-group"><SubmitButton className="btn btn-primary btn-block" type="submit"  style={{"background-color": "#1e76c6","width": "175px","padding-left": "11px","margin-left": "170px"}} value="Register"/></div>
            
        </form>
    </div>

        )

    }
}

const mapStateToProps = (state) => {
    return { formData: state.form.RegisterForm,err: state.error.data };
  };


export default reduxForm({
    form: "RegisterForm",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true, // a unique identifier for this form
  })(connect(mapStateToProps,{error})(RegisterFormComponent));