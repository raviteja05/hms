import React from 'react'
import {Field,reduxForm} from 'redux-form'
import {connect} from 'react-redux'
import qs from 'qs'
import {textInput,emailInput,passwordInput,textAreaInput,SubmitButton} from './FormComponents';
import axios from 'axios'


class RegisterFormComponent extends React.Component{
    submit(ev,props){
        
    }
    

    render(){
        var isAdmin=window.data.auth.role==="ADMIN"
        
        return (
            <div class="login-clean"  style={{"background-color": "rgb(238,238,238)"}}>
        <form method="post" action="/signup" onSubmit={(ev)=>this.submit(ev,this.props.formData)} style={{"max-width": "629px"}}>
            <h2 class="text-center" style={{"padding-bottom": "15px"}}>Sign Up</h2>
            <div class="form-group">
                <div class="form-row" style={{"width": "549px"}}>
                    <div class="col-xl-6"><Field type="text" name="firstName" inputName="firstName" placeholder="First Name" style={{"width": "260px"}} component={textInput} /></div>
                    <div class="col-xl-6"><Field type="text" name="lastName" inputName="lastName" placeholder="Last Name" style={{"width": "260px"}} component={textInput} /></div>
                    
                </div>
            </div>
            <div class="form-group"><Field type="email" name="email" inputName="email" placeholder="Email" component={emailInput} /></div>
            <div class="form-group"><Field type="password" name="password" inputName="password" placeholder="Password" component={passwordInput} /></div>
            <div class="form-group"><Field type="password" name="password" inputName="rpassword" placeholder="Confirm Password" component={passwordInput} /></div>
            {isAdmin&&<div class="form-group"><select class="form-control"><option value="DOCTOR" selected="">DOCTOR</option><option value="CUSTOMER">CUSTOMER</option><option value="ADMIN">ADMIN</option></select></div>}
            <div class="form-group"><Field type="text" name="phoneNo" inputName="phoneNo" placeholder="Phone Number"  component={textInput} /></div>            
            <div class="form-group"><Field name="address" inputName="address" placeholder="Address" component={textAreaInput} /></div>
            <div class="form-group"><SubmitButton className="btn btn-primary btn-block" type="submit"  style={{"background-color": "#1e76c6","width": "175px","padding-left": "11px","margin-left": "170px"}} value="Register"/></div>
            
        </form>
    </div>

        )

    }
}

const mapStateToProps = (state) => {
    return { formData: state.formReducer.RegisterForm };
  };


export default reduxForm({
    form: "RegisterForm",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true, // a unique identifier for this form
  })(connect(mapStateToProps)(RegisterFormComponent));