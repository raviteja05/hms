import React from "react";
import { connect } from "react-redux";
import EditProfileForm from './EditProfileForm'
import { error, profileData,loadProfile } from "../../actions";
import {  
  emailInput,
  passwordInput,
  textAreaInput,
  SubmitButton,
} from "../auth/FormComponents";
class EditProfile extends React.Component {
  
  componentDidMount() {
    var role = window.data.auth.role;
    this.props.profileData(role);

    
    
  }
  
  
 
  
  render() {

    var initialValues=this.props.initialValues
    var data=initialValues?{firstName:initialValues.firstName,lastName:initialValues.lastName
    ,email:initialValues.email
    }:{}
    
    return (
      <div class="container">
        <div class="table-responsive table-borderless">
        
       {this.props.initialValues&& <EditProfileForm initialValues={this.props.initialValues}/>}
        </div>
      </div>
    );
  }
}
const mapStateToProps = (state) => {
  return { initialValues: state.profile.data,formData:state.form };
};


export default connect(mapStateToProps,{ error, profileData})(EditProfile);
