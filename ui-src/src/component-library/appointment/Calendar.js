import Calendar from 'react-calendar'
import React from 'react'
import './Calendar.css';
import {connect} from 'react-redux'
import {getAppointments} from '../../actions'
import {formatDate} from '../../utils/utils'

class AppCalendar extends React.Component{
    changeDate(value,ev,doctor){        
        this.props.getAppointments(formatDate(new Date(value)),doctor)

    }
    render(){
       
        
        return (
            <div class="col" style={{"max-width": "30%"}}>
            <Calendar
            minDate={new Date()}
            nextLabel=">"
            prevLabel="<"
            next2Label=">>"
            prev2Label="<<"
            onChange={(value,ev)=>this.changeDate(value,ev,this.props.doctor)}
                        />
            </div>
        )
    }
}
export const mapStateToProps=(state)=>{
    const urlParams = new URLSearchParams(window.location.search);
    var doctor = urlParams.get("doctor");
    return {data:state,doctor:doctor}
}
export default connect(mapStateToProps,{getAppointments})(AppCalendar);