import React from "react";
import { connect } from "react-redux";
import Axios from "axios";
import IssuePrescriptionTab from "./IssuePrescriptionTab";
import ViewPrescriptionsTab from "./ViewPrescriptionsTab";
import {TabHeader} from './TabHeader'
import {getPrescriptionsList} from '../../actions'


class TabContent extends React.Component {  
  
  render() {
    
    var customer=this.props.customerDetails
    
  
    return (
      <div>
       {customer&&customer.email&& <TabHeader customerId={customer.email} getPrescriptions={this.props.getPrescriptionsList} />}
        <div class="tab-content">
          <div class="tab-pane active" role="tabpanel" id="tab-1">
            <IssuePrescriptionTab customer={customer}/>
          </div>
          <div class="tab-pane" role="tabpanel" id="tab-2">
           {this.props.prescriptions.prescriptionsList&&<ViewPrescriptionsTab prescriptions={this.props.prescriptions.prescriptionsList}/>}
          </div>
          <div class="tab-pane" role="tabpanel" id="tab-3">
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
                  <tr>
                    <td>10-09-2019 12:12:00</td>
                    <td>Ravi</td>
                    <td>Cell 1</td>
                  </tr>
                  <tr>
                    <td>
                      10-09-2019 12:12:00
                      <br />
                    </td>
                    <td>Cell 3</td>
                    <td>Cell 3</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    prescriptions:state.prescriptionsList
    
  };
};

export default connect(mapStateToProps,{getPrescriptionsList})(TabContent);

