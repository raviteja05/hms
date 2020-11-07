import React from "react";
import  TabContent  from "./TabContent";
import {connect} from 'react-redux'
import {viewAppointment} from '../../actions'
class ViewAppointment extends React.Component {
  componentDidMount(){
    const urlParams = new URLSearchParams(window.location.search);
    const appId = urlParams.get('appId');
    this.props.viewAppointment(appId)
  }
  render() {
    var data=this.props.customerDetails
    
    
    return (
     <div class="container">
      {data&&<React.Fragment><div class="row">
          <div class="col">
            <h5>Patient Details</h5>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="table-responsive" style={{"max-width": "75%"}}>
              <table class="table">
                <thead>
                  <tr></tr>
                </thead>
                <tbody>
                  <tr>
                    <td style={{"width":"130px"}}>
                      <strong>First Name</strong>
                    </td>
                    <td style={{"width":"250px"}}>{data.firstName}</td>
                    <td style={{"width":"200px"}}>
                      <strong>Last Name</strong>
                    </td>
                    <td>{data.lastName}</td>
                  </tr>
                  <tr>
                    <td style={{"width":"130px"}}>
                      <strong>Age</strong>
                    </td>
                    <td style={{"width":"250px"}}>{data.age}</td>
                    <td style={{"width":"150px"}}>
                      <strong>Blood Group</strong>
                    </td>
                    <td>{data.bloodGroup}</td>
                  </tr>
                  <tr>
                    <td style={{"width":"130px"}}>
                      <strong>Email</strong>
                    </td>
                    <td style={{"width":"250px"}}>{data.email}</td>
                    <td style={{"width":"150px"}}>
                      <strong>Height</strong>
                    </td>
                    <td>{data.height}</td>
                  </tr>
                  <tr>
                    <td style={{"width":"130px"}}>
                      <strong>Weight</strong>
                    </td>
                    <td style={{"width":"250px"}}>{data.weight}</td>
                    <td style={{"width":"150px"}}>
                      <strong>Notes</strong>
                    </td>
    <td>{data.notes}</td>
                  </tr>
                  <tr>
                    <td style={{"width":"163px"}}>
                      <strong>Known Allergies</strong>
                    </td>
                    <td >{data.knownAllergies}</td>
                    <td ></td>
                    <td ></td>
                  </tr>
                  <tr>
                    <td style={{"width":"163px"}}>
                      <br />
                    </td>
                    <td ></td>
                    <td ></td>
                    <td ></td>
                  </tr>
                </tbody>
              </table>
            </div>

            <TabContent customerDetails={data}/>
          </div>
        </div></React.Fragment>}
      </div>
    )
  }
}
const mapStateToProps=(state)=>{
    return {customerDetails:state.viewAppointment.appointment}
}
export default connect(mapStateToProps,{viewAppointment})(ViewAppointment)
