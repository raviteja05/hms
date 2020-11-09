import React from 'react'
import {textAreaInput,Button} from '../auth/FormComponents';
import {Field,reduxForm} from 'redux-form'
import {connect} from 'react-redux'
import {addAppointmentNotes} from '../../actions'


class AppointmentNotes extends React.Component{
    update(notes){
        const urlParams = new URLSearchParams(window.location.search);
        const appId = urlParams.get('appId');
        var data={
            id:appId,
            appointmentNotes:notes
        }
        this.props.addAppointmentNotes(data)

    }
    render(){
        console.log(this.props.data)
        return (<div>
            <form  style={{"max-width": "629px","padding":"35px"}}>
            <div class="form-group"><Field name="appointmentNotes" inputName="appointmentNotes" placeholder="Appointment Notes" component={textAreaInput} /></div>
            <div class="form-group"><Button className="btn btn-primary btn-block" onClick={(ev)=>{this.update(this.props.data.values.appointmentNotes)}} type="submit"  style={{"background-color": "#1e76c6","width": "175px","padding-left": "11px","margin-left": "170px"}} value="Submit"/></div>
            
        </form>
        </div>)
    }
}

const mapStateToProps=(state)=>{
    return {data:state.formReducer.AppointmentNotes}
}
export default reduxForm({
    form: "AppointmentNotes",
    destroyOnUnmount: false,
    forceUnregisterOnUnmount: true, // a unique identifier for this form
  })(connect(mapStateToProps,{addAppointmentNotes})(AppointmentNotes));
