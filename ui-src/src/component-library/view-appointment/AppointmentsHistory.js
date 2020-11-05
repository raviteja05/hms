import React from 'react'
import {connect} from 'react-redux'


class AppointmentsHistory extends React.Component{
   

    render(){
       var data=this.props.appointmentsHistory.data
        return (
            <div class="table-responsive" style={{ width: "700px" }}>
              <table class="table">
                <thead>
                  <tr>
                    <th style={{ width: "150px" }}>Date and Time</th>
                    <th style={{ width: "200px" }}>Doctor</th>
                    <th style={{ width: "200px" }}>Notes</th>
                  </tr>
                </thead>
                <tbody>
                 {data&& data.map(el=><tr>
                    <td>{el.date} {el.appointmentTime}</td>
                    <td>Dr. {el.doctor.firstName} {el.doctor.lastName}</td>
                    <td>{el.appointmentNotes}</td>
                  </tr>)}
                  
                </tbody>
              </table>
            </div>
        )
    }
}


export default AppointmentsHistory