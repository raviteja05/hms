import React from 'react'


class ViewPrescriptionsTab extends React.Component{
    render(){
       

        return ( <div class="table-responsive" style={{ width: "700px" }}>
        <table class="table">
          <thead>
            <tr>
              <th style={{ width: "150px" }}>Date</th>
              <th style={{ width: "200px" }}>Doctor</th>
              <th style={{ width: "200px" }}>Link</th>
            </tr>
          </thead>
          <tbody>
            {this.props.prescriptions&&this.props.prescriptions.map(el=><tr>
              <td>{el.date}</td>
              <td>Dr. {el.doctorViewData.firstName} {el.doctorViewData.lastName}</td>
              <td>view</td>
            </tr>)}
            
          </tbody>
        </table>
      </div>)

    }
}


  export default ViewPrescriptionsTab;