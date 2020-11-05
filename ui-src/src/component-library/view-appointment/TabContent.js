import React from "react";
import { connect } from "react-redux";
import Axios from "axios";
import IssuePrescriptionTab from "./IssuePrescriptionTab";
import ViewPrescriptionsTab from "./ViewPrescriptionsTab";
import {TabHeader} from './TabHeader'
import {getPrescriptionsList,appointmentsHistory} from '../../actions'
import AppointmentsHistory from "./AppointmentsHistory";



class TabContent extends React.Component {  
  
  render() {
    
    var customer=this.props.customerDetails
    
  
    return (
      <div>
       {customer&&customer.email&& <TabHeader customerId={customer.email} appointmentsHistory={this.props.appointmentsHistory} getPrescriptions={this.props.getPrescriptionsList} />}
        <div class="tab-content">
          <div class="tab-pane active" role="tabpanel" id="tab-1">
            <IssuePrescriptionTab customer={customer}/>
          </div>
          <div class="tab-pane" role="tabpanel" id="tab-2">
           {this.props.prescriptions.prescriptionsList&&<ViewPrescriptionsTab prescriptions={this.props.prescriptions.prescriptionsList}/>}
          </div>
          <div class="tab-pane" role="tabpanel" id="tab-3">
            {this.props.appointmentsHistory&&<AppointmentsHistory appointmentsHistory={this.props.appointmentHistory} customer={customer}/>}
          </div>
          <div class="tab-pane" role="tabpanel" id="tab-4">
            
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    prescriptions:state.prescriptionsList,
    appointmentHistory:state.appointmentsHistory
    
  };
};

export default connect(mapStateToProps,{getPrescriptionsList,appointmentsHistory})(TabContent);

