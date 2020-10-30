import Calendar from 'react-calendar'
import React from 'react'
import './Calendar.css';
import {connect} from 'react-redux'
import {getAppointments} from '../../actions'
import {formatDate} from '../../utils/utils'

class AppCalendar extends React.Component{
    changeDate(value,ev){
        console.log(formatDate(new Date(value)))
        this.props.getAppointments(formatDate(new Date(value)))

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
            onChange={(value,ev)=>{this.changeDate(value,ev)}}
                        />
            </div>
        )
    }
}
export const mapStateToProps=(state)=>{
    return {data:state}
}
export default connect(mapStateToProps,{getAppointments})(AppCalendar);