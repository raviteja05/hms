import React from 'react'
import {textAreaInput,Button} from '../auth/FormComponents';
import {Field,reduxForm} from 'redux-form'
import {connect} from 'react-redux'
import {MessageCard} from '../messagecards/bookingsuccess'
import {addAppointmentNotes,message,error} from '../../actions'


class AppointmentNotes extends React.Component{

    update(notes){
        var err={}
        if(notes){
        const urlParams = new URLSearchParams(window.location.search);
        const appId = urlParams.get('appId');
        var data={
            id:appId,
            appointmentNotes:notes
        }
        this.props.addAppointmentNotes(data)
        this.props.message({appointmentNotesUpdate:"Successfully updated appointment notes"})
    }else{
        err["appointmentNotes"]="Appointment notes cannot be blank"
        this.props.error(err);
    }

    }
    render(){
       console.log(this.props.err)
       var disabled=this.props.data&&this.props.data.values&&this.props.data.values.appointmentNotes?false:true
       var buttonClass=disabled?"secondary":"primary"
        return (<div>
            <form  style={{"max-width": "629px","padding":"35px"}}>
            {this.props.displayMessage&&this.props.displayMessage.appointmentNotesUpdate&&<div> <MessageCard message={this.props.displayMessage.appointmentNotesUpdate}/></div>}
            <div class="form-group"><Field name="appointmentNotes" inputName="appointmentNotes" placeholder="Appointment Notes" component={textAreaInput} /></div>
            {this.props.err && this.props.err.email && 
              <p className="text-danger">{this.props.err.appointmentNotes}</p>}
            <div class="form-group"><button className={`btn btn-${buttonClass} btn-block`} disabled={disabled} onClick={(ev)=>{this.update(this.props.data.values.appointmentNotes)}} type="button"  style={{"width": "175px","padding-left": "11px","margin-left": "170px"}}>Submit</button></div>
            
        </form>
        </div>)
    }
}

const mapStateToProps=(state)=>{
    return {data:state.form.AppointmentNotes,displayMessage:state.message.data
    ,err:state.error.data
    }
}
export default reduxForm({
    form: "AppointmentNotes",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true, // a unique identifier for this form
  })(connect(mapStateToProps,{addAppointmentNotes,message,error})(AppointmentNotes));
