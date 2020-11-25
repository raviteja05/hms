import AppCalendar from './Calendar'
import BookAppointmentsContainer from './BookAppointmentsContainer'
import React from 'react'

class AppointmentDashboard extends React.Component{
    
    render(){
        return (
            <div class="container" style={{"position":"relative","min-height":"50vh"}}>
            
            <div class="row">
                <BookAppointmentsContainer/>
                <AppCalendar/>
            </div>
           
        </div>
        )
    }
}

export default AppointmentDashboard;