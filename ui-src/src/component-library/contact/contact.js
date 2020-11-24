import React from 'react'
import {reduxForm,Field} from 'redux-form'
import {connect} from 'react-redux'
import {textInput,textAreaInput,emailInput,SubmitButton} from '../auth/FormComponents';
import {spinner} from '../../actions'
import Axios from 'axios';
import { MessageCard } from '../messagecards/bookingsuccess';


class ContactFormComponent extends React.Component{
    submitFeedBack(data){
        Axios.post('/ws/submit-feedback',data).then((res)=>{if(res.status==200){window.location.replace('/contact-us?success')}})
       this.props.spinner(true)
        
        
    }
    render(){
        
        return (

            <main class="page contact-us-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Contact Us</h2>
                    
                </div>
                <form >
                    {window.msg&&<MessageCard message={window.msg}/>}
                    <div class="form-group"><label>Name</label>
                    <Field name="name" inputName="name" component={textInput} />

                    
                    </div>
                    <div class="form-group"><label>Subject</label><Field name="subject" inputName="subject" component={textInput} /></div>
                    <div class="form-group"><label>Email</label><Field name="email" inputName="email" component={emailInput} /></div>
                    <div class="form-group"><label>Message</label><Field name="message" inputName="message" component={textAreaInput} /></div>
        <div class="form-group"><button class="btn btn-primary btn-block" onClick={(ev)=>this.submitFeedBack(this.props.formData.values)} type="button">{this.props.spin&&<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"> </span>}{!this.props.spin&&`Send`}</button></div>
                </form>
            </div>
        </section>
    </main>

        )

    }
}

const mapStateToProps = (state) => {
    return { formData: state.form.ContactForm,spin:state.spinner.spinner };
  };
  
  export default reduxForm({
    form: "ContactForm",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true // a unique identifier for this form
  })(connect(mapStateToProps,{spinner})(ContactFormComponent));