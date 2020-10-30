import React from 'react'
import {Field,reduxForm} from 'redux-form'
import {connect} from 'react-redux'
import qs from 'qs'
import {emailInput,passwordInput,SubmitButton} from './FormComponents';
import axios from 'axios'


class LoginComponent extends React.Component{
    submit(ev,props){
        
        }
    render(){
        return (
            <div class="login-clean" style={{"background-color": "rgb(238,238,238)"}}>
        <form action="/perform_login" method="post">
            <h2 class="sr-only">Login Form</h2>
            <div class="form-group"><Field type="email" name="email" inputName="username" placeholder="Email" component={emailInput} /></div>
            <div class="form-group"><Field type="password" name="password" inputName="password" placeholder="Password" component={passwordInput} /></div>
            <div class="form-group"><SubmitButton className="btn btn-primary btn-block" type="submit" onSubmit={(ev)=>this.submit(ev,this.props.formData)} style={{"background-color": "#1e76c6"}} value="Login"/></div>
           <a class="forgot" href="#">Forgot your email or password?</a><a class="forgot" href="/signup">Not a member? Sign Up</a></form>
    </div>
        )

    }
}

const mapStateToProps = (state) => {
    return { formData: state.formReducer.LoginForm };
  };

export default reduxForm({
    form: "LoginForm",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true, // a unique identifier for this form
  })(connect(mapStateToProps)(LoginComponent));