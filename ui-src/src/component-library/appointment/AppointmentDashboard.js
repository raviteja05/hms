import AppCalendar from './Calendar'
import BookAppointmentsContainer from './BookAppointmentsContainer'
import React from 'react'

class AppointmentDashboard extends React.Component{
    
    render(){
        return (
            <div class="container">
            
            <div class="row">
                <BookAppointmentsContainer/>
                <AppCalendar/>
            </div>
            <div class="row">
                <div class="col">
                    <nav style={{"margin-left": "25%"}}>
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">4</a></li>
                            <li class="page-item"><a class="page-link" href="#">5</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        )
    }
}

export default AppointmentDashboard;