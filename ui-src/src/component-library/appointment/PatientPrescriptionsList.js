import React from "react";
import { getPrescriptionsList,prescription } from "../../actions";
import {connect} from 'react-redux'
import ViewPrescription from '../view-appointment/ViewPrescription'
class PatientPrescriptionList extends React.Component {
  componentDidMount() {
    var customerID = window.data.auth.user;
    var role = window.data.auth.role;
    this.props.getPrescriptionsList(customerID, role);
  }
  click(id,role){
    this.props.prescription(id,role);
    document.getElementById('prescription-modal').style="display:block;background:lightgray;";
    document.getElementById('prescription-modal').className="modal fade show"
  }
  render() {
    
    var role = window.data.auth.role;
    return (
      <div class="container">
        <div class="row">
          <div class="col">
            <h4>Prescriptions</h4>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th>Date</th>
                    <th>Doctor</th>
                    <th>Link</th>
                  </tr>
                </thead>
                <tbody>
                  {this.props.data&&
                  this.props.data.prescriptionsList&&
                  this.props.data.prescriptionsList.map(el=><tr>
                    <td>{el.date}</td>
                    <td>Dr. {el.doctorViewData.firstName} {el.doctorViewData.lastName}</td>
                    <td>
                      <button class="btn btn-primary" onClick={(ev)=>this.click(el.id,role)} type="button">
                        View
                      </button>
                    </td>
                  </tr>)}
                </tbody>
              </table>
              <ViewPrescription prescription={this.props.prescriptionData}/>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return { data: state.prescriptionsList ,prescriptionData:state.prescription};
};
export default connect(mapStateToProps, { getPrescriptionsList,prescription })(
  PatientPrescriptionList
);
